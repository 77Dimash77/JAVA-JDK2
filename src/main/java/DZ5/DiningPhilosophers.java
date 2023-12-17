package DZ5;

import java.util.concurrent.Semaphore;

class Philosopher extends Thread {
    private static Semaphore semaphore = new Semaphore(2);

    private int id;
    private int eatCount;

    public Philosopher(int id) {
        this.id = id;
        this.eatCount = 0;
    }

    private void think() {
        System.out.println("Philosopher " + id + " is thinking");
    }

    private void eat() throws InterruptedException {
        semaphore.acquire();
        System.out.println("Philosopher " + id + " is eating (count: " + (eatCount + 1) + ")");
        eatCount++;
        Thread.sleep(500);
        semaphore.release();
    }

    @Override
    public void run() {
        try {
            while (eatCount < 3) {
                think();
                eat();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class DiningPhilosophers {
    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];

        for (int i = 0; i < 5; i++) {
            philosophers[i] = new Philosopher(i);
            philosophers[i].start();
        }
    }
}
