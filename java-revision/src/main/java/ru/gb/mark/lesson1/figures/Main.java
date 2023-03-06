package ru.gb.mark.lesson1.figures;

import ru.gb.mark.lesson1.figures.entity.Circle;
import ru.gb.mark.lesson1.figures.entity.Figure;
import ru.gb.mark.lesson1.figures.entity.Rectangle;
import ru.gb.mark.lesson1.figures.entity.Square;

public class Main {

    public static void main(String[] args) {

        Figure figure = new Square(5);
        System.out.println(figure.calculateSqr());

        figure = new Circle(6);
        System.out.println(figure.calculateSqr());

        figure = new Rectangle(3, 5);
        System.out.println(figure.calculateSqr());

    }
}
