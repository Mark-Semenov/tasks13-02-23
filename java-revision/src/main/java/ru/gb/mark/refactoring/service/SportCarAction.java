package ru.gb.mark.refactoring.service;

public class SportCarAction implements Act {

    @Override
    public void start() {
        System.out.println("Fast start");
    }

    @Override
    public void move() {
        System.out.println("Fast move");
    }

    @Override
    public void stop() {
        System.out.println("Fast stop");
    }

    @Override
    public void open() {
        System.out.println("2 doors are open");
    }
}
