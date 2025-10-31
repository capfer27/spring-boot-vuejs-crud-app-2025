package com.capfer.spring_boot_vue_crud.controller;

import com.capfer.spring_boot_vue_crud.dto.PatientDTO;
import com.capfer.spring_boot_vue_crud.dto.ResponseDTO;
import com.capfer.spring_boot_vue_crud.dto.UpdatePatientDTO;
import com.capfer.spring_boot_vue_crud.service.IPatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/patients", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:5173")
@Validated
public class PatientController {

    private final IPatientService patientService;

    public PatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create(@Valid @RequestBody PatientDTO patientDTO) {
        patientService.create(patientDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new ResponseDTO(HttpStatus.OK.name(), "Patient created successfully"));
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        List<PatientDTO> patients = patientService.getPatients();
        return ResponseEntity.status(HttpStatus.OK)
                .body(patients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatient(@Valid @PathVariable(name = "id") Long id) {
        PatientDTO patientDTO = patientService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(patientDTO);
    }

    @GetMapping("/details")
    public ResponseEntity<PatientDTO> getByIdentifier(@Valid @RequestParam String phoneNumber) {
        PatientDTO patientDTO = patientService.getByPhoneNumber(phoneNumber);
        return ResponseEntity.status(HttpStatus.OK).body(patientDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updatePatient(@Valid @RequestBody UpdatePatientDTO patientDTO) {
        patientService.updatePatient(patientDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO(HttpStatus.OK.name(), "Patient updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@Valid @PathVariable(name = "id") Long id) {
        patientService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO(HttpStatus.OK.name(), "Patient removed successfully"));
    }

//    @DeleteMapping("/delete")
//    public ResponseEntity<ResponseDTO> deleteByPatientNumber(@RequestParam String phoneNumber) {
//        patientService.deletePatientByPhoneNumber(phoneNumber);
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(new ResponseDTO(HttpStatus.OK.name(), "Patient removed successfully"));
//    }

}
