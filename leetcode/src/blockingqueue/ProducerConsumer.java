package blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    public static class Producer extends Thread{
        @Override
        public void run(){
            try {
                queue.put("product");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("produce..");
        }
    }

    public static class Consumer extends Thread{
        @Override
        public void run(){
            try {
                String product = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("consume..");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Producer().start();
        }
        for (int i = 0; i < 5; i++) {
            new Consumer().start();
        }
    }
}
