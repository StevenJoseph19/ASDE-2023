package com.mycompany.hibernatefundamentals.airport;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TICKETS")
public class Ticket {

	@EmbeddedId
	private TicketKey id;

	private String origin;
	private String destination;

	public Ticket() {

	}

	public TicketKey getId() {
		return id;
	}

	public void setId(TicketKey id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}
