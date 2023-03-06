package ru.gb.mark.lesson1.refactoring.service;

public class SimpleCarAction implements Act {

    @Override
    public void start() {
        System.out.println("Waiting... It's trying start...");
        System.out.println("Slow start");
    }

    @Override
    public void move() {
        System.out.println("Slow move");
    }

    @Override
    public void stop() {
        System.out.println("Stop");
    }

    @Override
    public void open() {
        System.out.println("4 doors are open");
    }

}
