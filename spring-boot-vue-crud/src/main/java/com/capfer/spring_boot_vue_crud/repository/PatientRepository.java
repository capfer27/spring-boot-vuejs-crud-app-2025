package com.capfer.spring_boot_vue_crud.repository;

import com.capfer.spring_boot_vue_crud.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByPhoneNumber(String phoneNumber);

    Optional<Patient> findByEmail(String email);

    void deleteByPhoneNumber(String phoneNumber);
}
