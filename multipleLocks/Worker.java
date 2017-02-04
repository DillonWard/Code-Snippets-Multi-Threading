package multithreading.multipleLocks;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Worker {
	
	// Lock objects to lock other methods out
	private Random rand = new Random();
	private Object lockOne = new Object();
	private Object lockTwo = new Object();
	
	
	private List<Integer> listOne = new ArrayList<Integer>();
	private List<Integer> listTwo = new ArrayList<Integer>();
	
	public void stageOne(){
		// threads lock each other out and add to their lists
		synchronized (lockOne) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			listOne.add(rand.nextInt(100));
		}
	}
	
	public void stageTwo(){
		
		synchronized (lockTwo) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			listTwo.add(rand.nextInt(100));
		}
	}
	
	public void process(){
		
		for(int i = 0; i < 1000; i++){
			stageOne();
			stageTwo();
		}
	}
	
	public void main(){

		long start =  System.currentTimeMillis();

		// used for starting and running the thread
		Thread t1 = new Thread (new Runnable(){

			@Override
			public void run() {
				process();
			}
			
		});
	
		Thread t2 = new Thread (new Runnable(){

			@Override
			public void run() {
				process();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("Time taken: " + (end - start));
		System.out.println("ListOne: " + listOne.size() + "\nListTwo: " + listTwo.size());
	}

}
