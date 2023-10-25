package com.mycompany.hibernatefundamentals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.mycompany.hibernatefundamentals.airport.Ticket;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m03.ex04");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Ticket ticket1 = new Ticket();

		ticket1.setSeries("AA");
		ticket1.setNumber("1234");
		ticket1.setOrigin("Bucharest");
		ticket1.setDestination("London");

		em.persist(ticket1);

		em.getTransaction().commit();
		
//		Using EntityManager.find()
//		Ticket foundTicket = em.find(Ticket.class, 1);
//
//		System.out.println("The ticket with Id 1  as found by find() is: " + foundTicket);
//		System.out.println("The ticket with Id 1  as found by find() has the origin as: " + foundTicket.getOrigin());
//		System.out.println("The ticket with Id 1  as found by find() has the destination as: " + foundTicket.getDestination());
		
//		Using JPQL
		
//		foundTicket = em.createQuery("SELECT t FROM Ticket t WHERE t.id = 1", Ticket.class).getSingleResult();
//		System.out.println("The ticket with Id 1  as found by find() is: " + foundTicket);
//		System.out.println("The ticket with Id 1  as found by find() has the origin as: " + foundTicket.getOrigin());
//		System.out.println("The ticket with Id 1  as found by find() has the destination as: " + foundTicket.getDestination());
		
//		Using Criteria API
//
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//
//		CriteriaQuery<Ticket> q = cb.createQuery(Ticket.class);
//		Root<Ticket> c = q.from(Ticket.class);
//		q.select(c);
//
//		TypedQuery<Ticket> query = em.createQuery(q);
//
//		List<Ticket> results = query.getResultList();
//
//		for (Ticket ticket : results) {
//
//			System.out.println("Found ticket from Criteria API is: " + ticket);
//			System.out.println("Found ticket from Criteria API has the origin as: " + foundTicket.getOrigin());
//			System.out.println("Found ticket from Criteria API has the destination as: " + foundTicket.getDestination());
//		}
		
		emf.close();

	}

}
