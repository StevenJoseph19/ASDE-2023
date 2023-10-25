package com.mycompany.hibernatefundamentals.airport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENTS")
public class Payment {

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "TICKET_ID", referencedColumnName = "ID"),
			@JoinColumn(name = "TICKET_NUMBER", referencedColumnName = "NUMBER") })
	private Ticket ticket;

	private int amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
