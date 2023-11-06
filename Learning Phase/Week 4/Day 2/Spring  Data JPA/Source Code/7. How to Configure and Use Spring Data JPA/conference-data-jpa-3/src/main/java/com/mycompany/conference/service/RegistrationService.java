package com.mycompany.conference.service;

import java.util.List;

import javax.transaction.Transactional;

import com.mycompany.conference.model.Registration;
import com.mycompany.conference.model.RegistrationReport;

public interface RegistrationService {

	Registration addRegistration(Registration registration);

	List<Registration> findAll();

	List<RegistrationReport> findAllReports();

}