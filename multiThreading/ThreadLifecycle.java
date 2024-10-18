class MyThread extends Thread {
    @Override
    public void run() {
        try {
            
            System.out.println(Thread.currentThread().getName() + " is running.");
            
            
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " woke up from sleep.");
            
            
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " is waiting.");
                wait();
            }
            
            System.out.println(Thread.currentThread().getName() + " resumed after waiting.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  
            System.out.println("Thread was interrupted.");
        }
    }
}

public class ThreadLifecycle {
    public static void main(String[] args) throws InterruptedException {
        
        MyThread myThread = new MyThread();
        System.out.println("Thread is created but not yet started.");

        
        myThread.start();
        System.out.println("Thread is in runnable state.");

        
        Thread.sleep(3000);
        
        synchronized (myThread) {
            myThread.notify();  
        }
        
        
        myThread.join();
        System.out.println("Thread execution completed and is in terminated state.");
    }
}

