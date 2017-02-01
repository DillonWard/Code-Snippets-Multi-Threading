package multithreading.four;

import java.util.Scanner;

class Processor extends Thread{
	
	
	private volatile boolean isActive = true; // Volatile controller so it isn't cached
	
	public void run(){
		
		while(isActive){
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown(){
		isActive = false;
	}
}

public class App {

	public static void main(String[] args) {
		Processor proc1 = new Processor();
		proc1.start();
		
		System.out.println("Press [RETURN] to exit");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		proc1.shutdown();
	}
}
