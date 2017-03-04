// REFERENCE - CAVE OF PROGRAMMING - https://www.youtube.com/user/caveofprogramming
package multithreading.lowLevelSync;

import multithreading.lowLevelSync.Process;

public class App {

	public static void main(String[] args) throws InterruptedException {
		// a processor object is created
		final Process process = new Process();
		
		/*
		 * 2 threads are created
		 * 2 different methods are called from each thread
		 * both methods are ran in 2 different threads
		 */
		
		Thread t1 = new Thread(new Runnable(){
			
			public void run(){
				try {
					process.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			
			public void run(){
				try {
					process.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		// threads are started
		t1.start();
		t2.start();
		
		// waits for the threads to finish
		t1.join();
		t2.join();
	}
}
