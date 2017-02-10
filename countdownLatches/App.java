package multithreading.countdownLatches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class Processor implements Runnable{
	
	// passes processes the latch so they can use it
	private CountDownLatch latch;
	
	// constructor that allows the class use latch
	public Processor(CountDownLatch latch){
		this.latch = latch;
	}
	public void run(){
		
		System.out.println("Started.");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// every time this is called, the latch is counted down by 1
		latch.countDown();
		
	}
	
}
public class App {

	public static void main(String[] args) {

		/* counts down from a number specified
		 * to allow one or more threads wait till the latch reaches 0
		 * one or more threads can count down
		 * threads that are waiting on the latch can then continue
		 */
		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		// creates 3 threads - each thread will have it's own Processor
		for (int i = 0; i < 3; i++) {
			executor.submit(new Processor(latch));
		}
		
		// waits till CountDownLatch is 0
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Finished.");
	}
}
