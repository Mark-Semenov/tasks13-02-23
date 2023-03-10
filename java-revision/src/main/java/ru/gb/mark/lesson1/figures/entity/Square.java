package ru.gb.mark.lesson1.figures.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Square extends Figure {

    private int a;

    @Override
    public Double calculateSqr() {
        return Math.pow(a, 2);
    }

}
