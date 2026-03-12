package org.example;

public class ThreadCommunicationWaitTimeOut
{
    public static class SharedResource {
        boolean hasData = false;
    }
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            System.out.println("Consumer block");
            synchronized (lock) {
                while (!sharedResource.hasData) {
                    try {
                        System.out.println("Waiting for lock 3000ms");
                        lock.wait(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Consumer consumed data successfully");
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Producer block");
            synchronized (lock) {
                System.out.println();
                try {
                    System.out.println("Producer taking time to produce data");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Producer produced data successfully");
                sharedResource.hasData = true;
                lock.notify();
            }
        });

        t1.start();
        t2.start();
    }
}
