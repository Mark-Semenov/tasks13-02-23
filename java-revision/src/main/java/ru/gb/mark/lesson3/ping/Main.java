package ru.gb.mark.lesson3.ping;

public class Main {

    public static void main(String[] args) {

        Message message = new Message(4);
        new Thread(message::run).start();
        new Thread(message::run).start();

    }

}
