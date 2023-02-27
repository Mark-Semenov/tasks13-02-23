package ru.gb.mark.refactoring.entity;

import lombok.Data;

@Data
public abstract class Engine {
    protected String type;

    public Engine(String type) {
        this.type = type;
    }
}
