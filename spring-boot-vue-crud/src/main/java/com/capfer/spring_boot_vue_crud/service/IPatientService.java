package com.capfer.spring_boot_vue_crud.service;

import com.capfer.spring_boot_vue_crud.dto.PatientDTO;
import com.capfer.spring_boot_vue_crud.dto.UpdatePatientDTO;
import org.springframework.lang.Nullable;

import java.util.List;

public interface IPatientService {

    @Nullable
    PatientDTO getByPhoneNumber(String phoneNumber);

    void create(PatientDTO patientDTO);

    List<PatientDTO> getPatients();

    void deleteById(Long id);

    void deletePatientByPhoneNumber(String phoneNumber);

    PatientDTO getById(Long id);

    void updatePatient(UpdatePatientDTO patientDTO);
}
