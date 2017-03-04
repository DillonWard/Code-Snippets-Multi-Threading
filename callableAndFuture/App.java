package multithreading.callableAndFuture;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		/*
		 * Callable is used to define the return type of an object
		 * Future is used to find out the status of a object
		 * future uses get() that waits for callable to finish
		 * The program will make a thread sleep for a random amount of time
		 * if the time is greater that a certain amount, an error message is throw from callable
		 * else, future gets the number 
		 */
		
		Future <Integer> future = executor.submit(new Callable<Integer>(){

			// Runnable has run, Callable has call
			public Integer call() throws Exception {
				Random rand = new Random();
				int duration = rand.nextInt(4000);
				
				if(duration > 2000){
					throw new IOException("Sleeping for too long");
				}
				
				System.out.println("Starting");
				
				try {
					Thread.sleep(duration); // thread is put to sleep for random amount of time
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("Finished");
				return duration;
			}			
		});
		
		executor.shutdown();
		
		try {
			// waits for callable to finish, retrieves the message
			System.out.println("Result is: " + future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			IOException ex = (IOException) e.getCause();
			System.out.println(ex.getMessage());
		}

	}
}
