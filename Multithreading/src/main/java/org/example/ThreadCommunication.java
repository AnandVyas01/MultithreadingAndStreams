package org.example;

public class ThreadCommunication {
    public static class SharedResource {
        boolean hasData = false;
    }

    // Thread communication
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();
        Object lock = new Object();
        Thread thread = new Thread(() -> {
//            public void met(){
            synchronized (lock) {
                System.out.println("Consumer lock");
                while(!resource.hasData){
                    try {
                        lock.wait();
                        System.out.println("waiting to get data");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Got the data");
                resource.hasData = false;
            }
//            }
        });

        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Producer lock produces data");
//                while(resource.hasData){
                lock.notify();
                resource.hasData = true;
//                }
            }
        });


        thread.start();
        thread1.start();
    }
}
