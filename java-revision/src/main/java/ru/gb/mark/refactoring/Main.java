package ru.gb.mark.refactoring;

import ru.gb.mark.refactoring.entity.*;
import ru.gb.mark.refactoring.service.*;

public class Main {

    public static void main(String[] args) {

        CarCrushTestImitation carTest = new CarCrushTestImitationImpl();

        carTest.setCar(
                new Lorry()
                        .setAct(new SimpleCarAction())
                        .setEngine(new SimpleEngine("Diesel"))
                        .setColor("Black")
                        .setName("PickUp-2000")
        );

        carTest.testing();

        carTest.setCar(
                new LightWeightCar()
                        .setAct(new SportCarAction())
                        .setEngine(new SportEngine("Petrol"))
                        .setName("Bugatti Chiron Super Sport 300+")
                        .setColor("Red")
        );

        carTest.testing();

        Lorry lorry = (Lorry) new Lorry()
                .setAct(new SimpleCarAction())
                .setEngine(new SimpleEngine("Gaz"))
                .setName("PickUp-3000");

        lorry.setCapacity(200);
        lorry.load(100);


        carTest.setCar(lorry);
        carTest.testing();


    }
}
