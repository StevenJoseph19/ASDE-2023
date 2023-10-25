package com.mycompany.hibernatefundamentals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mycompany.hibernatefundamentals.airport.Passenger;
import com.mycompany.hibernatefundamentals.airport.Ticket;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m04.ex07");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Passenger john = new Passenger("John Smith");

		Ticket ticket1 = new Ticket("AA1234");
		Ticket ticket2 = new Ticket("BB5678");

		john.addTicket(ticket1);
		john.addTicket(ticket2);

		john.addAttribute("VIP", "Yes");
		john.addAttribute("FREQUENT_FLYER", "Yes");

		em.persist(john);

		em.getTransaction().commit();
		emf.close();

	}

}
