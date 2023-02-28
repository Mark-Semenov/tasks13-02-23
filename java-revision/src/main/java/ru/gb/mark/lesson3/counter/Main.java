package ru.gb.mark.lesson3.counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static Counter counter;

    public static void main(String[] args) {

        counter = new Counter(4);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(counter::plus);
        executor.submit(counter::minus);
        executor.shutdown();


    }


}



