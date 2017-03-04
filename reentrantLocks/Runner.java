// REFERENCE - CAVE OF PROGRAMMING - https://www.youtube.com/user/caveofprogramming
package multithreading.reentrantLocks;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	
	private void increment(){
		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}
	
	public void firstThread() throws InterruptedException{
		
		/* access to the increment method is first locked
		 * it is used by this thread once
		 * count is incremented
		 * it is then unlocked and can be accessed again
		 * both threads work synchronously
		 * count will be 20,000 since both threads increment to 10,000
		 * try/finally is used in case an exception is thrown so it will definitely be unlocked
		 */
		
		lock.lock();
		System.out.println("[Waiting for Condition]");
		cond.await(); // condition has been met and can continue
		
		System.out.println("[Condition Unlocked]");
		try{
			increment();
		}finally{
			lock.unlock();
		}
	}
	
	public void secondThread() throws InterruptedException{
		
		Thread.sleep(1000);
		lock.lock();
		System.out.println("[Press Return]");
		new Scanner(System.in).nextLine();
		System.out.println("[Return Key Pressed]");
		
		cond.signal(); // signals that a condition has been met
		
		try{
			increment();
		}finally{
			lock.unlock();
		}
	}
	
	public void finished(){
		System.out.println("Count is: " + count);
	}
}
