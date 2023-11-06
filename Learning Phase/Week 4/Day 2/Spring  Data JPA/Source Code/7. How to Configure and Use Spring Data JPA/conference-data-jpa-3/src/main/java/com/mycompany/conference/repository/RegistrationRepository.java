package com.mycompany.conference.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.conference.model.Registration;
import com.mycompany.conference.model.RegistrationReport;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

	List<RegistrationReport> registrationReport();

}