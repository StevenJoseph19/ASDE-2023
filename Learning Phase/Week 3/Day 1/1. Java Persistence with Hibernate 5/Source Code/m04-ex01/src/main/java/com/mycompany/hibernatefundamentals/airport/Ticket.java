package com.mycompany.hibernatefundamentals.airport;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TICKETS")
public class Ticket {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@Column(name = "NUMBER")
	private String number;

	@ManyToOne
	@JoinColumn(name = "PASSENGER_ID")
	private Passenger passenger;

	public Ticket(String number) {
		this.number = number;
	}

	public Ticket() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	
	

}
