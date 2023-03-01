package ru.gb.mark.lesson3.counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private int count = 0;
    private final int size;
    private final Lock lock;

    public Counter(int size) {
        this.size = size;
        lock = new ReentrantLock(true);
    }


    public void increment() {
        try {
            lock.lock();
            count++;
            print();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        try {
            lock.lock();
            count--;
            print();
        } finally {
            lock.unlock();
        }

    }

    public void plus() {
        for (int i = 0; i < size; i++) {
            increment();
        }
    }

    public void minus() {
        for (int i = 0; i < size; i++) {
            decrement();
        }
    }

    public int get() {
        return count;
    }

    public void print() {
        System.out.printf("Thread: %s, Counter: %d%n",
                Thread.currentThread().getName(), get());
    }
}
