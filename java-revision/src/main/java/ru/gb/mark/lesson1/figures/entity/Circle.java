package ru.gb.mark.lesson1.figures.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Circle extends Figure {

    private int radius;

    @Override
    public Double calculateSqr() {
        double PI = 3.14;
        return PI * (Math.pow(radius, 2));
    }

}
