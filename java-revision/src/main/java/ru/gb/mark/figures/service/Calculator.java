package ru.gb.mark.figures.service;

public interface Calculator {
    default Double calculateSqr() {
        return (double) 0;
    }
}
