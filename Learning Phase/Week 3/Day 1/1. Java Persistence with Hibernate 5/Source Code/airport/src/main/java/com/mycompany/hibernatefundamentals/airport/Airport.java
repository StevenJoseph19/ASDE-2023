package com.mycompany.hibernatefundamentals.airport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AIRPORTS")
@Access(AccessType.FIELD)
public class Airport {
	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@OneToMany(mappedBy = "airport")
	private List<Passenger> passengers = new ArrayList<>();

	public Airport(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Airport() {

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

	public List<Passenger> getPassengers() {
		return Collections.unmodifiableList(passengers);
	}

	public void addPassenger(Passenger passenger) {
		passengers.add(passenger);
	}

}
