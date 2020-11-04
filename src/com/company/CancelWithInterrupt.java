package com.company;

import java.util.concurrent.atomic.AtomicBoolean;

public class CancelWithInterrupt {
    public static void main(String[] args) throws InterruptedException{
        Thread hello = new Thread(() -> {
            while (true) {
                System.out.println("Hello");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignore){
                    System.err.println("Interrupted, going to sleep");
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        hello.start();
        Thread.sleep(3000);
        hello.interrupt();
    }
}


