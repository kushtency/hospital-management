package dev.project.backend.controller.publicController;

import dev.project.backend.dto.*;
import dev.project.backend.entities.Physician;
import dev.project.backend.entities.User;
import dev.project.backend.service.PhysicianService;
import dev.project.backend.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/public/")
public class RegisterAPI {
    
	private final UserService userService;
    
	@Autowired
	private PhysicianService physicianService;
	
    @Autowired
    public RegisterAPI(UserService userService){
        this.userService = userService;
    }
    @PostMapping("register/")
    public ResponseEntity<Map<String, Object>> registerUser(@RequestBody CombinedInfo user){
        var res = new HashMap<String, Object>();
        System.out.println(user);
        Message message = userService.createUser(user);
        res.put("message", message);
        if(message.getStatus() != 1){
            res.put("user", null);
            return ResponseEntity.status(403).body(res);
        }
        return ResponseEntity.ok().body(res);
    }
    @PostMapping("login/")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody LoginCredentials loginCredentials){
        var res = new HashMap<String, Object>();
        User u = userService.getUser(loginCredentials.getEmailID());
        if(u != null){
            UserDetails userDetails = new UserDetails(u.getName(), u.getEmailID(), u.getSex(), u.getRole(), u.getAge());
            String token = userService.loginUser(loginCredentials);
            Send.response.set("login successfully", 1);
            res.put("message", Send.response);
            res.put("details", userDetails);
            res.put("token", token);
            return ResponseEntity.ok(res);
        }
        Send.response.set("user don't exist check email id", 0);
        res.put("message", Send.response);
        res.put("details", null);
        res.put("token", null);
        return ResponseEntity.status(403).body(res);
    }
    
    @GetMapping("get-all-speciality/")
	public ResponseEntity<Map<String,Object>> getAllSpeciality(){
		Map<String,Object> res = new HashMap<>();
		//getting physician details
		List<String> specialityList = physicianService.getSpeciality();
		Send.response.set("here is the list of speciality ", 1);
		res.put("message", Send.response);
		//get patient attach to physician
		res.put("details", specialityList);
		return ResponseEntity.ok(res);
	}
    
    @GetMapping("get-all-physician-speciality/{speciality}")
	public ResponseEntity<Map<String,Object>> getPhysicianBySpeciality(@PathVariable String speciality){
		Map<String,Object> res = new HashMap<>();
		//getting physician details
		List<Physician> physicianList = physicianService.getPhysicianBySpeciality(speciality);
		Send.response.set("here is the list of doctor with "+ speciality, 1);
		res.put("message", Send.response);
		//get patient attach to physician
		res.put("details", physicianList);
		return ResponseEntity.ok(res);
	}
    
}
