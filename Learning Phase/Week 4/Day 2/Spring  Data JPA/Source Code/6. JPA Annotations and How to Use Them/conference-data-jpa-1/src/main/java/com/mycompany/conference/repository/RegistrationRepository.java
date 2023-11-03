package com.mycompany.conference.repository;

import com.mycompany.conference.model.Registration;
import com.mycompany.conference.model.RegistrationReport;

import java.util.List;

public interface RegistrationRepository {
    Registration save(Registration registration);

    List<Registration> findAll();

    List<RegistrationReport> findAllReports();
}
