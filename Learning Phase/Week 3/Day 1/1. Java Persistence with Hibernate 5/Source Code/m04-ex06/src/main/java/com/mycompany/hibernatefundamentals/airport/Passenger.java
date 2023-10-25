package com.mycompany.hibernatefundamentals.airport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PASSENGERS")
public class Passenger {
	@Id
	@GeneratedValue
	private int id;

	private String name;
	
	@ElementCollection
	@CollectionTable(name = "PASSENGER_TICKETS", joinColumns = { 
			@JoinColumn(name = "PASSENGER_ID", referencedColumnName = "ID")
	})
	private List<Ticket> tickets = new ArrayList<>();

	public Passenger(String name) {

		this.name = name;

	}

	public Passenger() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ticket> getTickets() {
		return Collections.unmodifiableList(tickets);
	}

	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}

}
