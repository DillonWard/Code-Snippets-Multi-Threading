// REFERENCE - CAVE OF PROGRAMMING - https://www.youtube.com/user/caveofprogramming
package multithreading.basicOne;

class Runner extends Thread{

	public void run() {
		for(int i = 0; i < 10; i++){
			
			System.out.println("Number: " + i);
			
			try {
				Thread.sleep(100); // puts the thread to sleep
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class App {

	public static void main(String[] args) {
		
		// Both are running concurrently
		Runner runner = new Runner();
		runner.start();
		
		Runner runner1 = new Runner();
		runner1.start();
	}
}