package multithreading;

import java.util.LinkedList;
import java.util.Queue;

// Queue
class ShareQueue{
    private Queue<Integer> queue = new LinkedList<>();
    private final int capacity = 5;

    // produce task
    public synchronized void produce(int value){
        try{
            while(queue.size() == capacity){
                wait();
            }

            queue.add(value);
            System.out.println("Produced: " + value);
            notify();
        }
        catch (InterruptedException e){
            System.out.println("Producer interrupted: " + e.getMessage());
        }
    }

    // consumer task
    public synchronized void consume(){
        try{
            while(queue.isEmpty()){
                wait();
            }

            int value = queue.poll();
            System.out.println("Consumer: " + value);
            notify();
        }
        catch(InterruptedException e){
            System.out.println("Consumer interrupted: " + e.getMessage());
        }
    }
}

// Product
class Producer extends Thread{
    private ShareQueue shareQueue;

    public Producer(ShareQueue shareQueue){
        this.shareQueue = shareQueue;
    }

    @Override
    public void run(){
        for(int i = 0;i < 10;i++){
            shareQueue.produce(i);
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){
                System.out.println("Producer sleep interrupted");
            }
        }
    }
}


// Consumer
class Consumer extends Thread{
    private ShareQueue shareQueue;

    public Consumer(ShareQueue shareQueue){
        this.shareQueue = shareQueue;
    }

    @Override
    public void run(){
        for(int i = 0;i < 10;i++){
            shareQueue.consume();
            try{
                Thread.sleep(150);
            }
            catch(InterruptedException e){
                System.out.println("Consumer sleep interrupted");
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        ShareQueue shareQueue = new ShareQueue();

        Producer p1 = new Producer(shareQueue);
        Consumer c1 = new Consumer(shareQueue);

        p1.start();
        c1.start();
    }
}
