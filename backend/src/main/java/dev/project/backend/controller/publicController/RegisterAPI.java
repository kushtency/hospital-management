package dev.project.backend.controller.publicController;

import dev.project.backend.dto.LoginCredentials;
import dev.project.backend.dto.Message;
import dev.project.backend.dto.Send;
import dev.project.backend.dto.UserDetails;
import dev.project.backend.entities.User;
import dev.project.backend.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/public/")
public class RegisterAPI {
    private final UserService userService;

    @Autowired
    public RegisterAPI(UserService userService){
        this.userService = userService;
    }
    @PostMapping("register/")
    public ResponseEntity<Map<String, Object>> registerUser(@RequestBody User user){
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
            UserDetails userDetails = new UserDetails(u.getName(), u.getEmailID(), u.getSex(), u.getRole());
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
}
