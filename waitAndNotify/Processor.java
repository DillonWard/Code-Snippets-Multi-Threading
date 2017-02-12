package multithreading.waitAndNotify;

import java.util.Scanner;

public class Processor {

	/*
	 * the first method (produce) is called, which contains a wait
	 * the wait() is waiting for a notify()
	 * the produce lock is relinquished and the other method is called
	 * sleep finishes and the lock for notify is called
	 * waiting for return key
	 * the wait is notified and the first thread is continued
	 */
	public void produce() throws InterruptedException{
		synchronized (this) {
			System.out.println("Procuder thread running.");
			wait();
			System.out.println("Resumed.");
		}
	}
	
	public void consume() throws InterruptedException {
		
		Scanner scan = new Scanner(System.in);
		Thread.sleep(2000);
		
		synchronized (this) {
			System.out.println("Waiting for return key.");
			scan.nextLine();
			System.out.println("Return key pressed.");
			notify();			
		}
	}
}
