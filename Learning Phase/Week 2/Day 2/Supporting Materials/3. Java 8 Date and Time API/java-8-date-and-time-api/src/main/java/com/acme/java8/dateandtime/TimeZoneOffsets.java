package com.acme.java8.dateandtime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Set;
import java.util.function.Predicate;

public class TimeZoneOffsets {

	public static void main(String[] args) {
		// Step 1
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dtf.format(dt));

		// Step 2
		ZonedDateTime gmt = ZonedDateTime.now(ZoneId.of("GMT+0"));
		System.out.println(dtf.format(gmt));

		// Step 3
		ZonedDateTime ny = ZonedDateTime.now(ZoneId.of("America/New_York"));
		System.out.println(dtf.format(ny));

		// Step 4
		Set<String> zones = ZoneId.getAvailableZoneIds();
		// Step 4
//		zones.forEach(z -> System.out.println(z));
		
		//Step 5
		Predicate<String> condition = str -> str.contains("London");
		zones.forEach(z -> {
			if(condition.test(z))
				System.out.println(z);
		}
		);
	}

}
