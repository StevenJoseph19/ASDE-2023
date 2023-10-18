package com.acme.java8.dateandtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DateAndTime {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();

        try (
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(
                                DateAndTime.class.getResourceAsStream("/people.txt")));


        ) {


        } catch (IOException e) {
            System.out.println(e);
        }


    }

}
