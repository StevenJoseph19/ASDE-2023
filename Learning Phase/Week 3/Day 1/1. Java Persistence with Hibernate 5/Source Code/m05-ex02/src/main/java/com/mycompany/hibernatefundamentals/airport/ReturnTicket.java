package com.mycompany.hibernatefundamentals.airport;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "RETURN_TICKETS")
public class ReturnTicket extends Ticket {

	private LocalDate latestReturnDate;

	public LocalDate getLatestReturnDate() {
		return latestReturnDate;
	}

	public void setLatestReturnDate(LocalDate latestReturnDate) {
		this.latestReturnDate = latestReturnDate;
	}

}
