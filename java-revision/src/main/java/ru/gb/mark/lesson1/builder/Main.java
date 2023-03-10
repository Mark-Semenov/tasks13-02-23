package ru.gb.mark.lesson1.builder;

import ru.gb.mark.lesson1.builder.entity.Person;

public class Main {

    public static void main(String[] args) {

        Person person = PersonBuilder.builder()
                .setFirstName("John")
                .setMiddleName("Middle")
                .setLastName("Black")
                .setGender("Male")
                .setAge(30)
                .setPhone("+324234234324242")
                .setAddress("10351 Santa Monica Boulevard Suite 250. Los Angeles 90025")
                .setCountry("USA")
                .build();

        System.out.println(person.toString());
    }
}
