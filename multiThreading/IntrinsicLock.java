class SharedResource {
    private int counter = 0;

    // Synchronized method ensures intrinsic locking on 'this'
    public synchronized void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}

class MyThread extends Thread {
    private SharedResource resource;

    public MyThread(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            resource.increment();  // Locked using 'synchronized'
        }
    }
}

public class IntrinsicLock {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        MyThread t1 = new MyThread(resource);
        MyThread t2 = new MyThread(resource);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // Expecting 2000 after both threads finish incrementing
        System.out.println("Final Counter: " + resource.getCounter());
    }
}

