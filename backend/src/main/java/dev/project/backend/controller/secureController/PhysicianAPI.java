package dev.project.backend.controller.secureController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.project.backend.dto.Send;
import dev.project.backend.entities.Physician;
import dev.project.backend.service.PatientService;
import dev.project.backend.service.PhysicianService;

@RestController
@RequestMapping("api/physician/")
public class PhysicianAPI {
	
	@Autowired
	private PhysicianService physicianService;
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("get-record/{physicianID}")
	public ResponseEntity<Map<String,Object>> getRecord(@PathVariable Long physicianID){
		Map<String,Object> res = new HashMap<>();
		//getting physician details
		Physician physician = physicianService.getRecord(physicianID);
		Send.response.set("here is the list of patient", 1);
		res.put("message", Send.response);
		//get patient attach to physician
		res.put("details", physician.getListPatient());
		return ResponseEntity.ok(res);
	}
	
//	@GetMapping("get-all-physician-speciality/{speciality}")
//	public ResponseEntity<Map<String,Object>> getPhysicianBySpeciality(@PathVariable String speciality){
//		Map<String,Object> res = new HashMap<>();
//		//getting physician details
//		List<Physician> physicianList = physicianService.getPhysicianBySpeciality(speciality);
//		Send.response.set("here is the list of doctor with "+ speciality, 1);
//		res.put("message", Send.response);
//		//get patient attach to physician
//		res.put("details", physicianList);
//		return ResponseEntity.ok(res);
//	}
	
}
