package com.mycompany.hibernatefundamentals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mycompany.hibernatefundamentals.airport.Passenger;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m03.ex01");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Passenger john = new Passenger(1, "John Smith", "3 Flowers Street, Boston");

		em.persist(john);

		em.getTransaction().commit();
		emf.close();

	}

}
