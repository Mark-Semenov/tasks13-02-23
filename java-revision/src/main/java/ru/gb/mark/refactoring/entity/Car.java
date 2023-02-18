package ru.gb.mark.refactoring.entity;

import lombok.Data;
import ru.gb.mark.refactoring.service.Act;

@Data
// made it non-abstract POJO class
public class Car {

    private String color;
    private String name;

    //Use composition
    private Engine engine; //created abstract Engine
    private Act act; //link to any action, let to choose different strategy

    public Car setAct(Act act) {
        this.act = act;
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

//    protected void start() {
//        System.out.println("Car starting");
//    }

//    abstract void open();


//    public Engine getEngine() {
//        return engine;
//    }
//
//    public void setEngine(Engine engine) {
//        this.engine = engine;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

}
