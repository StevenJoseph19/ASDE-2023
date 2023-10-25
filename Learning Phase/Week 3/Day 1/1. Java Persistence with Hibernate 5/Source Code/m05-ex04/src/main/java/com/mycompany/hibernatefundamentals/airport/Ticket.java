package com.mycompany.hibernatefundamentals.airport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "TICKETS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Ticket {

	@Id
	@GeneratedValue
	private int id;

	private String number;
	
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


}
