package com.mycompany.hibernatefundamentals.airport;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TicketKey implements Serializable {

	private String series;
	private String number;
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}
}
