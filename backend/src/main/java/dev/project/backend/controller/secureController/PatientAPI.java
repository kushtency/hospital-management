package dev.project.backend.controller.secureController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/patient/")
public class PatientAPI {
    @GetMapping("test/")
    public String test(){
        return "hello from secured route";
    }
}
