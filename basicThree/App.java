// REFERENCE - CAVE OF PROGRAMMING - https://www.youtube.com/user/caveofprogramming
package multithreading.basicThree;

public class App {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable(){

			@Override
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
		});
		
		t1.start();
	}
}
