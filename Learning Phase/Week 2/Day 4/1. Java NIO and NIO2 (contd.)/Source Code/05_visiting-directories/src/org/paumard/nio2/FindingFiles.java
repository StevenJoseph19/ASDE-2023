package org.paumard.nio2;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.stream.Stream;

public class FindingFiles {

	public static void main(String[] args) throws IOException {

//		Path path = Paths.get(URI.create("file:///C:/Users/Admin/Pictures/Screenshots"));
//
//		boolean exists = Files.exists(path);
//		System.out.println("exists = " + exists);
//
//		Stream<Path> find1 =
//				Files.find(path, Integer.MAX_VALUE, (p, attr) -> true);
//
//		System.out.println("count = " + find1.count());
//
//		Stream<Path> find2 =
//				Files.find(path, Integer.MAX_VALUE, (p, attr) -> p.toString().endsWith(".png"));
//		System.out.println("count = " + find2.count());
//
//		Calendar c = GregorianCalendar.getInstance();
//		c.set(2023, Calendar.JANUARY, 1, 0, 0);
//		long date = c.getTimeInMillis();
//
//		Stream<Path> find3 =
//				Files.find(path, Integer.MAX_VALUE, (p, attr) -> attr.creationTime().toMillis() > date);
//		System.out.println("count = " + find3.count());
	}
}
