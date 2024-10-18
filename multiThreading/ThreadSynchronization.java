class Counter {
    private int count = 0;

    // Synchronized method to ensure thread-safe access to increment
    public synchronized void increment() {
        count++;  // Only one thread can increment the count at a time
    }

    public int getCount() {
        return count;
    }
}

class MyThread extends Thread {
    private Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class ThreadSynchronization {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Create two threads that share the same Counter object
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        // The final value of count should be 2000
        System.out.println("Final count: " + counter.getCount());
    }
}

