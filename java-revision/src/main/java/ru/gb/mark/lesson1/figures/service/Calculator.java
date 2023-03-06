package ru.gb.mark.lesson1.figures.service;

public interface Calculator {
    default Double calculateSqr() {
        return (double) 0;
    }
}
