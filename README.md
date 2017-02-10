# Multi-Threading Code Snippets
The purpose of this repository is to demonstrate and display usage of simple Multi Threading in Java. It will contain numerous java files, all of which are different ways of writing and using Concurrent Programming and Multi Threading. I found it to be very beneficial to go through tutorials that explained and demonstraited code examples of Multi Threading, this repository will contain my gradual understanding and usage of Multi-Threading, starting from small examples and working my way up.
The repository will contain examples of:

1. Basic Threads
2. Basic Thread Synchronization
3. Multiple Locks
4. Thread Pools
5. Executor Service
6. Countdown Latches

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

[Reference](https://www.youtube.com/user/caveofprogramming)
