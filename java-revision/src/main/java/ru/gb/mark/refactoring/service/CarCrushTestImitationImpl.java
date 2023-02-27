package ru.gb.mark.refactoring.service;

import lombok.Data;
import ru.gb.mark.refactoring.entity.Car;

@Data
public class CarCrushTestImitationImpl implements CarCrushTestImitation {

    private Car car;

    public void testing() {

        System.out.println("Testing: " + System.lineSeparator());
        System.out.println(car.getName() != null ? car.getName() : "none");
        System.out.println(car.getColor() != null ? car.getColor() : "none");
        System.out.println(car.getEngine() != null ? car.getEngine().getType() : "none");

        if (car.getAct() != null) {
            car.getAct().start();
            car.getAct().move();
            car.getAct().stop();
            car.getAct().open();
        }

        System.out.println();
    }


}
