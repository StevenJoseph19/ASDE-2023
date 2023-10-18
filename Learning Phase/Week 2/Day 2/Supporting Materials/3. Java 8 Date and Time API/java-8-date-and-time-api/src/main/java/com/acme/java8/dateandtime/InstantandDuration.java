package com.acme.java8.dateandtime;

import java.time.Duration;
import java.time.Instant;

public class InstantandDuration {

	public static void main(String[] args) throws InterruptedException {
		// Step 1
		Instant start = Instant.now();

		Thread.sleep(1000); // Step 2
		Instant end = Instant.now();

		System.out.println(start);
		System.out.println(end);

		Duration elapsed = Duration.between(start, end);
//		System.out.println("elapsed.." + elapsed);
		System.out.println("elapsed.." + elapsed.toMillis() +" Milliseconds");//Step 3
		
		
	}

}
