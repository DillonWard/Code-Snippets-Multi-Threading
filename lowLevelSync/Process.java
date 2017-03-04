// REFERENCE - CAVE OF PROGRAMMING - https://www.youtube.com/user/caveofprogramming
package multithreading.lowLevelSync;

import java.util.LinkedList;
import java.util.Random;

public class Process {

	// shared data
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private final int LIMIT = 10;
	private Object lock = new Object();
	
	// adds items
	public void produce() throws InterruptedException{
		
		int value = 0;
		
		while(true){
			
			synchronized (lock) {
				
				while(list.size() == LIMIT){
					lock.wait();
				}
				// adds an incrementing value to the list
				list.add(value++);
				lock.notify();
			}
		}
	}
	
	// removes items
	public void consume() throws InterruptedException{
		
		Random rand = new Random();
		
		while(true){
			
			synchronized (lock) {
				
				while(list.size() == 0){
					lock.wait();
				}
				System.out.println("List size is: " + list.size());
				// removes and returns the first items in the list
				int value = list.removeFirst();
				System.out.println("Value is: " + value);
				lock.notify();
			}
			
			Thread.sleep(rand.nextInt(1000));
		}
	}
}
