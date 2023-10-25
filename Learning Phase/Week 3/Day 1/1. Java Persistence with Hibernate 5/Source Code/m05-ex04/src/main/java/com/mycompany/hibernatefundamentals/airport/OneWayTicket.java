package com.mycompany.hibernatefundamentals.airport;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ONE_WAY_TICKETS")
public class OneWayTicket extends Ticket {
	
	private LocalDate latestDepartureDate;

	public LocalDate getLatestDepartureDate() {
		return latestDepartureDate;
	}

	public void setLatestDepartureDate(LocalDate latestDepartureDate) {
		this.latestDepartureDate = latestDepartureDate;
	}
	
	

}
