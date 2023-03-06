package ru.gb.mark.lesson1.refactoring.entity;

import lombok.Data;
import ru.gb.mark.lesson1.refactoring.service.Act;

@Data
public class Car implements Comparable<Car> {

    private String color;
    private String name;
    private int id;
    private Engine engine;
    private Act act;

    public Car setAct(Act act) {
        this.act = act;
        return this;
    }

    public Car setId(int id) {
        this.id = id;
        return this;
    }

    public Car setColor(String color) {
        this.color = color;
        return this;
    }

    public Car setName(String name) {
        this.name = name;
        return this;
    }

    public Car setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }


    @Override
    public int compareTo(Car o) {
        return Integer.compare(getId(), o.getId());
    }

}
