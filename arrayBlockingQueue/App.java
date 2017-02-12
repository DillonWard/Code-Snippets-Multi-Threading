package multithreading.arrayBlockingQueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

	// holds data items which can be added or removed - FIFO
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				try {
					producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}); // Thread t1
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				try {
					consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}); // Thread t2
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
	}
	
	private static void producer() throws InterruptedException{
		/*
		 * integers are randomly selected
		 * they are then added to the blocking queue
		 */
		Random rand = new Random();
		
		while(true){
			int value = rand.nextInt(100);
			queue.put(value);
			//queue.put(rand.nextInt(100));
			System.out.println("Value added to queue: " + value);
		}// while
	}// producer
	
	private static void consumer() throws InterruptedException{
		
		// items are randomly taken off the queue
		Random rand = new Random();
		while(true){
			Thread.sleep(100);
			
			if(rand.nextInt(10) == 0){
				// takes an item off the queue 1 in every 10 times
				Integer value = queue.take();
				System.out.println("Taken Value: " + value + "\n Queue size is: " + queue.size());
			}
		}
	}
}
