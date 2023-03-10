package ru.gb.mark.lesson5.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String mark;


    public Student setName(String name) {
        this.name = name;
        return this;
    }
}
