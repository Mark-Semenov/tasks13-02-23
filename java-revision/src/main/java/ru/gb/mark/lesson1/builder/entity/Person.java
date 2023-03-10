package ru.gb.mark.lesson1.builder.entity;

import lombok.Data;

@Data
public class Person {

    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

}
