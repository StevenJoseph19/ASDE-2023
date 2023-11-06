package com.mycompany.conference.repository;

import com.mycompany.conference.model.Registration;
import com.mycompany.conference.model.RegistrationReport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RegistrationRepositoryImpl implements RegistrationRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Registration save(Registration registration) {
        entityManager.persist(registration);
        return registration;
    }

    @Override
    public List<Registration> findAll() {
        List<Registration> registrations = entityManager.createQuery("Select r from Registration r").getResultList();

        return registrations;
    }

    @Override
    public List<RegistrationReport> findAllReports() {
//      String jpql = "SELECT new  com.mycompany.conference.model.RegistrationReport"+
//                    "(r.name, c.name,c.description) " +
//                    "from Registration r, Course c " +
//                    "where r.id = c.registration.id";

//        List<RegistrationReport> registrationReports = entityManager.createQuery(jpql).getResultList();

        List<RegistrationReport> registrationReports = entityManager.createNamedQuery(Registration.REGISTRATION_REPORT).getResultList();
        return registrationReports;
    }

}
