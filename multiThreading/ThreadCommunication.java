class SharedResource {
    private int data;
    private boolean hasData = false;

    
    public synchronized int consume() {
        while (!hasData) {
            try {
                wait();  
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        notify();  
        return data;
    }

   
    public synchronized void produce(int data) {
        while (hasData) {
            try {
                wait();  
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.data = data;
        hasData = true;
        notify();  
    }
}

class Producer extends Thread {
    private final SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Producer produced: " + i);
            resource.produce(i);
            try {
                Thread.sleep(1000);  
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer extends Thread {
    private final SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            int data = resource.consume();
            System.out.println("Consumer consumed: " + data);
            try {
                Thread.sleep(1500);  
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);

        producer.start();
        consumer.start();
    }
}

