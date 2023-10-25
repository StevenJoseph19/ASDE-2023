package com.mycompany.hibernatefundamentals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mycompany.hibernatefundamentals.airport.Payment;
import com.mycompany.hibernatefundamentals.airport.Ticket;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m04.ex04");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Ticket ticket1 = new Ticket();
		ticket1.setNumber("AA1234");
		ticket1.setOrigin("London");
		ticket1.setDestination("Bucharest");

		Payment payment = new Payment();
		payment.setTicket(ticket1);
		payment.setAmount(200);

		em.persist(ticket1);
		em.persist(payment);

		em.getTransaction().commit();
		emf.close();

	}

}
