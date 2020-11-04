package com.company;

import java.util.concurrent.atomic.AtomicBoolean;

public class CancelWithFlag {
    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean flag = new AtomicBoolean();
        flag.set(true);
        Thread hello = new Thread(() -> {
            while (flag.get()) {
                System.out.println("Hello");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignore){}
            }
        });
        hello.start();
        Thread.sleep(5000);
        flag.set(false);

    }
}



