package org.gudigar.ObjectClassLevelLock;

public class RunnerService implements Runnable {

	@Override
	public void run() {
		display2();
	}
	
	//Every object will have one unique lock
	//only one thread can acquire the local at a time. 
	//Object level locking is where one thread acquires a lock on one object and when other thread comes in, 
	//it will wait for the previous thread to release the lock
	//Make this method synchoronized to achieve object level locking
	//2 ways to achive object level locking. This is the first way of specifying synchronized keyword over the method
	private synchronized void display() {
		try {
			System.out.println("Thread " + Thread.currentThread().getName() + " entering this method");
			Thread.sleep(2000);
			System.out.println("Thread " + Thread.currentThread().getName() + " leaving this method");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//2nd way is to using synchronized(this) keyword
	private void display1() {
		synchronized (this) {
			try {
				System.out.println("Thread " + Thread.currentThread().getName() + " entering this method");
				Thread.sleep(2000);
				System.out.println("Thread " + Thread.currentThread().getName() + " leaving this method");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//Class Level locking. Irrespective of how many instance of class is created, there will be one lock per class.
	//Thread-0 will acquire class level lock. When Thread-1 comes in, this lock is alreay acquired by Thread-0, so thread-1 will wait
	//outside the static synchonized method or synchronized block to acquire that lock
	//2 Ways to achieve it. 1st way is this
	private void display2() {
		synchronized (RunnerService.class) {
			try {
				System.out.println("Thread " + Thread.currentThread().getName() + " entering this method");
				Thread.sleep(2000);
				System.out.println("Thread " + Thread.currentThread().getName() + " leaving this method");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//2nd way to achieve class level locking
	private static synchronized void display3() {
		try {
			System.out.println("Thread " + Thread.currentThread().getName() + " entering this method");
			Thread.sleep(2000);
			System.out.println("Thread " + Thread.currentThread().getName() + " leaving this method");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
