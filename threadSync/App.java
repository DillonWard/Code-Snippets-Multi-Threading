package multithreading.threadSync;

import java.util.Scanner;

class Processor extends Thread{
	
	
	private volatile boolean isActive = true; // Volatile controller so it isn't cached
	
	public void run(){
		
		while(isActive){
			System.out.println("Hello");
			try {
				Thread.sleep(100); // puts the thread to sleep
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	// controller method - sets to false and ends
	public void shutdown(){
		isActive = false;
	}
}

public class App {

	public static void main(String[] args) {
		Processor proc1 = new Processor();
		proc1.start(); // starts the thread
		
		/* the thread is running infinitely
		 * after enter is hit the shutdown method is called
		 * the shutdown turns the controller to false
		 * the thread is ended
		 */
		System.out.println("Press [RETURN] to exit");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		proc1.shutdown();
	}
}
