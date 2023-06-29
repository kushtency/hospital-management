package dev.project.backend.controller.secureController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/patient/")
public class PatientAPI {
    @GetMapping("set-complaint/")
    public ResponseEntity<Map<String, Object>> setComplaint(){
        return null;
    }
}
