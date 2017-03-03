package multithreading.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class App {

	public static void main(String[] args) throws Exception {
		/*
		 * a semaphore is an object that maintains a count
		 * the count is the number of available permits
		 * used to control access to a resource
		 * semaphore acquire/release can be thought of as lock/unlock
		 */		
		
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i = 0; i < 200; i++){
			executor.submit(new Runnable(){

				public void run() {
					try {
						Connection.getInstance().connect();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		executor.shutdown();
	}
}
