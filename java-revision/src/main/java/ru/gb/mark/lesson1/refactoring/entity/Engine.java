package ru.gb.mark.lesson1.refactoring.entity;

import lombok.Data;

@Data
public abstract class Engine {
    protected String type;

    public Engine(String type) {
        this.type = type;
    }
}
