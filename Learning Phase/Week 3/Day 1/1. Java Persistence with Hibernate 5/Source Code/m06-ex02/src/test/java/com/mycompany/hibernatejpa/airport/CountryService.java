package com.mycompany.hibernatejpa.airport;

import org.springframework.transaction.annotation.Transactional;

import com.mycompany.hibernatejpa.airport.Country;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CountryService {
	
	@PersistenceContext
	private EntityManager em;

    public static final String[][] COUNTRY_INIT_DATA = {{"Australia", "AU"}, {"Canada", "CA"}, {"France", "FR"},
            {"Germany", "DE"}, {"Italy", "IT"}, {"Japan", "JP"}, {"Romania", "RO"},
            {"Russian Federation", "RU"}, {"Spain", "ES"}, {"Switzerland", "CH"},
            {"United Kingdom", "UK"}, {"United States", "US"}};

    @Transactional
    public void init() {
        for (int i = 0; i < COUNTRY_INIT_DATA.length; i++) {
            String[] countryInitData = COUNTRY_INIT_DATA[i];
            Country country = new Country(countryInitData[0], countryInitData[1]);
            em.persist(country);
        }
    }

    @Transactional
    public void clear() {
    	em.createQuery("DELETE FROM Country c").executeUpdate();
    }

    public List<Country> getAllCountries() {
//        return em.createQuery("SELECT c FROM Country c").getResultList();
    	
    	CriteriaBuilder cb = em.getCriteriaBuilder();
    	CriteriaQuery<Country> q = cb.createQuery(Country.class);
    	Root<Country> c = q.from(Country.class);
    	
    	q.select(c);
    	
    	TypedQuery<Country> query = em.createQuery(q);
    	
    	List<Country> results = query.getResultList();
    	
    	return results;
    }

}
