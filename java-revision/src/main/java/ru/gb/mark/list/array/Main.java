package ru.gb.mark.list.array;

import ru.gb.mark.refactoring.entity.Car;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Array<Car> cars = new Array<>();
        Car car = new Car().setId(19).setName("33333333");
        long start = System.currentTimeMillis();


        for (int i = 0; i < 10000000; i++) {
            cars.add(new Car().setId(i)); //(int) (Math.random() * (i + 10))
        }


        System.out.println(cars.size());


        for (int i = 1000; i < 100000; i++) {
            cars.remove(cars.get(i));
        }


        cars.remove(1);


//        for (Car c : cars) {
//            cars.remove(c);
//        }

        System.out.println(cars.size());

        System.out.println("Index of: " + cars.indexOf(car));
        cars.add(3, new Car().setId(18).setName("999"));
        cars.set(3, car);
        System.out.println("Index of: " + cars.indexOf(car));
//        cars.stream().sorted().forEach(System.out::println);

        Arrays.sort(cars.toArray());



        List<Car> subList = cars.subList(0, 10);
        System.out.println(subList);

        long end = System.currentTimeMillis();
        System.out.format("TIME %dc", (end - start) / 1000);
        System.out.println();

        cars.add(4, new Car().setId(98923));

//        cars.forEach(System.out::println);

    }
}
