package ru.gb.mark.list.linked;

import ru.gb.mark.refactoring.entity.Car;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Car> cars = new SimpleLinkedList<>();

        Car car = new Car().setId(45);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            cars.add(new Car().setId((int) (Math.random() * (i + 10))));
        }

        cars.forEach(System.out::println);

        cars.remove(2);

        cars.set(0, new Car().setId(123));
        System.out.println(cars);
        cars.remove(car);
        cars.add(3, car);

        System.out.println("Car: " + cars.get(4));

        Object[] objects = cars.toArray();
        Arrays.sort(objects);
        Arrays.stream(objects).forEach(System.out::println);

        long end = System.currentTimeMillis();
        System.out.format("TIME %dc", (end - start) / 1000);
        System.out.println();

    }
}
