package com.mycompany.hibernatefundamentals.airport;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PASSENGERS")
public class Passenger {
	@Id
	@GeneratedValue
	private int id;

	private String name;

	@Convert(converter = VipConverter.class)
	private boolean vip;

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

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

}
