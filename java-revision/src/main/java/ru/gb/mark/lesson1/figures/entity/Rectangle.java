package ru.gb.mark.lesson1.figures.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Rectangle extends Figure {

    private int a;
    private int b;

    @Override
    public Double calculateSqr() {
        return (double) (a * b);
    }
}
