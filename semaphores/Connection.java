package multithreading.semaphores;

import java.util.concurrent.Semaphore;

public class Connection {

	private static Connection instance = new Connection();
	private int connections = 0;
	private Semaphore sem = new Semaphore(10, true);
	private Connection(){
		
	}
	
	public static Connection getInstance(){
		return instance;
	}

	/*
	 * method to ensure that even if an exception is thrown
	 * the finally - sem.release - will still be called
	 */
	public void connect() throws Exception{
		sem.acquire();
		try{
			doConnect();
		}finally{
			sem.release();
		}
	}
	
	public void doConnect() throws Exception{
		
		synchronized (this) {
			connections++;
			System.out.println("Current Connections: " + connections);
		}
		Thread.sleep(2000);
		synchronized (this) {
			connections--;
		}
		
	}
}
