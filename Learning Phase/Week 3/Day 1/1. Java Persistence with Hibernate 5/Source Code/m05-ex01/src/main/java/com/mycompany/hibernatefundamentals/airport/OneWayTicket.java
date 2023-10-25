package com.mycompany.hibernatefundamentals.airport;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class OneWayTicket extends Ticket {
	
	private LocalDate latestDepartureDate;

	public LocalDate getLatestDepartureDate() {
		return latestDepartureDate;
	}

	public void setLatestDepartureDate(LocalDate latestDepartureDate) {
		this.latestDepartureDate = latestDepartureDate;
	}
	
	

}
