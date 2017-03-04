// REFERENCE - CAVE OF PROGRAMMING - https://www.youtube.com/user/caveofprogramming
package multithreading.interruptingThreads;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting");
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		Future<?> future = executor.submit(new Callable<Void>(){

			@Override
			public Void call() throws Exception {
				Random rand = new Random();
				
				for (int i = 0; i < 1E6; i++) {
					// if the thread is interrupted this will be displayed
					if(Thread.currentThread().isInterrupted()){
						System.out.println("Interrupted");
						break;
					}
					
					Math.sin(rand.nextDouble());
				}
				return null;
			}
		});
		
		//executor.shutdown();
		//future.cancel(true);
		executor.shutdownNow();
		executor.awaitTermination(1, TimeUnit.DAYS);
		System.out.println("Finished");
	}
}
