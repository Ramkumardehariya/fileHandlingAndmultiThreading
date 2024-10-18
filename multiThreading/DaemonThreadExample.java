class MyDaemonThread extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Daemon thread is running...");
                Thread.sleep(1000);  // Simulate background work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Daemon thread interrupted");
            }
        }
    }
}

public class DaemonThreadExample {
    public static void main(String[] args) {
        // Create a new thread
        MyDaemonThread daemonThread = new MyDaemonThread();

        // Set the thread as daemon before starting it
        daemonThread.setDaemon(true);

        // Start the daemon thread
        daemonThread.start();

        // Main thread sleeps for 3 seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Main thread finishes and the JVM will terminate, stopping the daemon thread
        System.out.println("Main thread is finished. Daemon thread will be terminated by JVM.");
    }
}

