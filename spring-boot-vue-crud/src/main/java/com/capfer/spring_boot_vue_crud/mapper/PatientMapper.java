package com.capfer.spring_boot_vue_crud.mapper;

import com.capfer.spring_boot_vue_crud.dto.PatientDTO;
import com.capfer.spring_boot_vue_crud.dto.UpdatePatientDTO;
import com.capfer.spring_boot_vue_crud.model.Patient;

public class PatientMapper {

    public static Patient mapToEntity(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setName(patientDTO.name());
        patient.setEmail(patientDTO.email());
        patient.setPhoneNumber(patientDTO.phoneNumber());
        patient.setGender(patientDTO.gender());
        return patient;
    }

    public static PatientDTO mapToDTO(Patient patient) {
        PatientDTO patientDTO = new PatientDTO(
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getPhoneNumber(),
                patient.getGender()
        );
        return patientDTO;
    }

    public static Patient mapToUpdateEntity(UpdatePatientDTO patientDTO, Patient patient) {
        patient.setName(patientDTO.name());
        patient.setEmail(patientDTO.email());
        patient.setPhoneNumber(patientDTO.phoneNumber());
        patient.setGender(patientDTO.gender());

        return patient;
    }
}
