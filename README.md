# Multi-Threading Code Snippets
The purpose of this repository is to demonstrate and display usage of simple Multi Threading in Java. It will contain numerous java files, all of which are different ways of writing and using Concurrent Programming and Multi Threading. I found it to be very beneficial to go through tutorials that explained and demonstraited code examples of Multi Threading, this repository will contain my gradual understanding and usage of Multi-Threading, starting from small examples and working my way up.
The repository will contain examples of:

1. Basic Threads
2. Basic Thread Synchronization
3. Multiple Locks
4. Thread Pools
5. Countdown Latches
6. Array Blocking Queue
7. Wait and Notify
8. Low Level Synchronization
9. Re-Entrant Locks
10. Deadlock
11. Semaphores
12. Callable and Future
13. Interrupting Threads 

### Multi-Threading
Multi Threading in Java refers to when two or more processes are running concurrently in one single program. Multi-Threading means that multiple lines of a program can be executed at the same time.
Thread classes may contain Runner classes which can `implements` Runnable (a run method) or `extend` Thread.

```
class Runner implements Runnable{
    
    public void run(){
    
    }
}

class Runner extends Thread{

    public void run(){
    
    }
}

```
### Thread Synchronization
Thread Synchronization is used in a situation where multiple threads are trying to access the same resource at the same time, which can sometimes cause some issues where one thread used up a resource more than another. Threads can use the `synchronized` for synchronization to occur. 

```
public synchronized void increment(){
		count++;
	}
```
This class will be accessed and used by two methods synchronously.

### Locks
A lock in Java is used for controlling access to a shared resource by multiple threads, while one thread is using a resource the other is locked out and cannot use it.

### Thread Pools
A Thread pool is a collection of threads that execute asynchronously. Thread pools are used to reduce the number of application threads within a class, and can be used for managing the Threads.

### Countdown Latches
A Countdown Latch is a syncronization aid that allows one or more threads to wait until a set of operations being performed in other threads are complete. A `CountDownLatch` is initialized with a count. The `await()` method blocks until the `countDown()` reaches zero, after which the block is released and the program can continue.

```
CountDownLatch latch = new CountDownLatch(3);
latch.countDown();
latch.await();
```
### Array Blocking Queue
An `ArrayBlockingQueue` is a blocking queue that stores elements inside an array. It is capable of storing unlimited amounts of data. Elements are added to the array using `put()`. Items are also removed from the array using `take()`.
```
queue.put(value);
queue.take();
```
### Wait and Notify
The `wait()` and `notify()` methods are used to block a thread until a specific condition is met. Once one condition is met, using the `notify()`, the thread can continue.
```
    public void produce() throws InterruptedException{
		synchronized (this) {
			wait();
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
```
### Low Level Synchronization

### Re-Entrant Locks

### Deadlock

### Semaphores

### Callable and Future

### Interrupting Threads

#### Reference
[Oracle Docs](https://docs.oracle.com/javase/7/docs/)

[Cave of Coding YouTube](https://www.youtube.com/user/caveofprogramming)
