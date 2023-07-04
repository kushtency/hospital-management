package dev.project.backend.controller.secureController;

import dev.project.backend.entities.Physician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.project.backend.dto.Send;
import dev.project.backend.entities.Patient;
import dev.project.backend.entities.PatientRecord;
import dev.project.backend.service.PatientService;
import dev.project.backend.service.PhysicianService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/patient/")
public class PatientAPI {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private PhysicianService physicianService;
	
//    @GetMapping("set-problem/")
//    public ResponseEntity<Map<String, Object>> setComplaint(@RequestBody Problem problem,){
//    	///get user
//    	
//        return null;
//    }
//    
	@GetMapping("get-record/{patientID}")
	public ResponseEntity<Map<String, Object>> setRecord(@PathVariable Long patientID){
		
		Map<String, Object> res = new HashMap<>();
		Patient patient = patientService.getRecords(patientID);
		Send.response.set("here is the record", 1);
		res.put("message", Send.response);
		res.put("details", patient.getPatientRecords());
		return ResponseEntity.ok(res);
	}
	
	@GetMapping("change-physician/{patientID}")
	public ResponseEntity<Map<String, Object>> changeDoctor(@RequestBody Long physicianID,@PathVariable Long patientID){
		
		Map<String, Object> res = new HashMap<>();
		//get patient
		Patient patient = patientService.getRecords(patientID);
		//add patient to physician
		physicianService.addPatient(patient,physicianID);
		
		Send.response.set("patient added successfull", 1);
		res.put("message", Send.response);
		res.put("details", patient);
		return ResponseEntity.ok(res);
		
	}

	@GetMapping("physician-list/{patientID}")
	public ResponseEntity<Map<String, Object>> list(@PathVariable Long patientID){
		Map<String, Object> res = new HashMap<>();
		List<Physician> ls = patientService.getPhysicianList(patientID);
		res.put("list", ls);
		return ResponseEntity.ok(res);
	}
    
    
}
