package multithreading.five;

public class App {
	
	private volatile int count = 0;
	
	// method to be called synchronously
	public synchronized void increment(){
		count++;
	}

	public static void main(String[] args) {
		
		App app = new App();
		app.threadHolder(); // calls the threadHolder method
	}
	
	/* a counter is made and incremented by 2 different threads
	 * the threads both finish their loops fully
	 * and the value the counter will be the amount of the two loops
	 */
	
	public void threadHolder(){
		Thread t1 = new Thread(new Runnable(){

			public void run(){
				for(int i = 0; i < 10000; i++){
					increment(); // count is incremented from here
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			
			public void run(){
				for(int i = 0; i < 10000; i++){
					increment();
				}
			
			}
		});
		
		// the threads are started
		t1.start();
		t2.start();
		
		// .join makes the threads wait for another to be completed
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Count is: " + count);
	}
}
