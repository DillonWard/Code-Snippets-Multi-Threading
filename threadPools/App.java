// REFERENCE - CAVE OF PROGRAMMING - https://www.youtube.com/user/caveofprogramming
package multithreading.threadPools;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// runs multiple processes at once
class Processor implements Runnable{
	
	private int id;
	
	// constructor that takes in an ID
	public Processor(int id){
		this.id = id;
	}
	
	public void run(){
		System.out.println("Starting " + id);
		
		try {
			// puts the thread to sleep for 5000 milliseconds/5 seconds
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed " + id);
	}
}


public class App {

	public static void main(String[] args) {
		
		// creates 2 threads - each thread processes a task
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for(int i = 0; i < 5; i++){
			// submits a task 
			executor.submit(new Processor(i));
		}
		
		executor.shutdown();
		
		System.out.println("All tasks submited.");
		
		// waits for all tasks to finish only within a certain time
		try {
			executor.awaitTermination(30, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("All tasks completed.");
	}
}
