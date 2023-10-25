package com.mycompany.hibernatefundamentals.airport;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("O")
public class OneWayTicket extends Ticket {
	
	private LocalDate latestDepartureDate;

	public LocalDate getLatestDepartureDate() {
		return latestDepartureDate;
	}

	public void setLatestDepartureDate(LocalDate latestDepartureDate) {
		this.latestDepartureDate = latestDepartureDate;
	}
	
	

}
