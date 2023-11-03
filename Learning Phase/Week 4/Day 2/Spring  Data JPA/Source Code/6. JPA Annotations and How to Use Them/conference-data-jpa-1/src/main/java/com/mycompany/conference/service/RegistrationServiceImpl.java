package com.mycompany.conference.service;

import java.util.List;

//import javax.transaction.Transactional;

import com.mycompany.conference.model.RegistrationReport;
import com.mycompany.conference.repository.CourseRepository;
import com.mycompany.conference.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.conference.model.Course;
import com.mycompany.conference.model.Registration;

import javax.transaction.Transactional;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private CourseRepository courseRepository;


//    @Override
//    @Transactional
//    public Registration addRegistration(Registration registration) {
//        return registration;
//        return registrationRepository.save(registration);
//
//    }


    @Override
    @Transactional
    public Registration addRegistration(Registration registration) {
        Registration tempRegistration;

        if (registration.getId() == null) {
            tempRegistration = registrationRepository.save(registration);
            Course course = new Course();
            course.setName("Intro");
            course.setDescription("Every attendee must complete the intro");
            course.setRegistration(registration);

            courseRepository.save(course);
        } else {
            tempRegistration = registrationRepository.save(registration);
        }

        return tempRegistration;
    }

    @Override
    public List<Registration> findAll() {

        return registrationRepository.findAll();
    }


	public List<RegistrationReport> findAllReports() {
		return registrationRepository.findAllReports();
	}

}
