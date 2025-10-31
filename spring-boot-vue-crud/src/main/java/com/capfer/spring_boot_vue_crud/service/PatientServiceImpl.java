package com.capfer.spring_boot_vue_crud.service;

import com.capfer.spring_boot_vue_crud.dto.PatientDTO;
import com.capfer.spring_boot_vue_crud.dto.UpdatePatientDTO;
import com.capfer.spring_boot_vue_crud.exception.PatientNotFoundException;
import com.capfer.spring_boot_vue_crud.mapper.PatientMapper;
import com.capfer.spring_boot_vue_crud.model.Patient;
import com.capfer.spring_boot_vue_crud.repository.PatientRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientServiceImpl implements IPatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientDTO getByPhoneNumber(String phoneNumber) {
        Optional<Patient> optionalPatient = patientRepository.findByPhoneNumber(phoneNumber);
        if (optionalPatient.isEmpty()) {
            throw new PatientNotFoundException("Patient " + phoneNumber + " was not found.");
        }

        return PatientMapper.mapToDTO(optionalPatient.get());
    }

    @Override
    public void create(PatientDTO patientDTO) {
        Patient patient = PatientMapper.mapToEntity(construct(patientDTO));
        patientRepository.save(patient);
    }

    private PatientDTO construct(PatientDTO patientDTO) {
        String phoneNumber = getPhoneNumber(patientDTO);
        return new PatientDTO(
                patientDTO.id(),
                patientDTO.name(),
                patientDTO.email(),
                phoneNumber,
                patientDTO.gender()
        );
    }

    //TODO: Remove this as phoneNumber can no longer be empty.
    private static String getPhoneNumber(PatientDTO patientDTO) {
        return Strings.isBlank(patientDTO.phoneNumber())
                ? UUID.randomUUID().toString()
                : patientDTO.phoneNumber();
    }

    @Override
    public List<PatientDTO> getPatients() {
        return patientRepository.findAll()
                .stream()
                .map(PatientMapper::mapToDTO)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isEmpty()) {
            throw new PatientNotFoundException("Patient " + id + " does not exists.");
        }
        patientRepository.deleteById(id);
    }

    @Override
    @Transactional
    public PatientDTO getById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isEmpty()) {
            throw new PatientNotFoundException("Patient " + id + " does not exists.");
        }
        return PatientMapper.mapToDTO(patient.get());
    }

    @Override
    public void updatePatient(UpdatePatientDTO patientDTO) {
        Optional<Patient> patient = patientRepository.findById(patientDTO.id());
        if (patient.isEmpty()) {
                throw new PatientNotFoundException("Patient with email: " + patientDTO.email() + " does not exists.");
        }

        Patient updatedPatient = PatientMapper.mapToUpdateEntity(patientDTO, patient.get());
        patientRepository.save(updatedPatient);
    }

    @Override
    @Transactional
    public void deletePatientByPhoneNumber(String phoneNumber) {
        Optional<Patient> patient = patientRepository.findByPhoneNumber(phoneNumber);
        if (patient.isEmpty()) {
            throw new PatientNotFoundException("Patient " + phoneNumber + " does not exists.");
        }
        patientRepository.deleteByPhoneNumber(phoneNumber);
    }
}
