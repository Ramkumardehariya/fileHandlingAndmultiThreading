class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running, iteration: " + i);
            try {
                Thread.sleep(1000);  // Pauses for 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted.");
            }
        }
    }
}

public class ThreadMethodsExample {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        t1.setName("Worker-1");
        t1.start();

        t1.join();  // Wait for t1 to finish before continuing

        System.out.println(t1.getName() + " is alive? " + t1.isAlive());  // False after t1 finishes
    }
}

