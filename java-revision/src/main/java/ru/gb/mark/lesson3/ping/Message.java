package ru.gb.mark.lesson3.ping;

public class Message {

    private String msg;
    private final int count;

    public Message(int count) {
        this.count = count;
        msg = pong();
    }

    public String ping() {
        return "ping";
    }

    public String pong() {
        return "pong";
    }

    public synchronized void run() {
        int c = 0;
        while (c < count) {
            try {

                switch (msg) {
                    case "ping" -> msg = pong();
                    case "pong" -> msg = ping();
                }

                print(msg);
                c++;
                this.notify();
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                this.notify();
            }

        }
    }

    private void print(String text) {
        System.out.println(text);
    }
}
