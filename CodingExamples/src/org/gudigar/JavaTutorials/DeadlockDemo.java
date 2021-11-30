package org.gudigar.JavaTutorials;

public class DeadlockDemo {
	
	//Since synchronization works only on objects, creating 2 string objects
	//where lock can be acquired on it
	String s1 = "Abhishek";
	String s2 = "Gudigar";
	
	/*
	 * Deadlock is a part of multithreading
	 * Deadlock can happen in a situation when a thread is waiting for object lock
	 * that is acquired by another thread and second thread is waiting for an object lock that
	 * is acquired by first thread.
	 */
	public static void main(String[] args) {
		DeadlockDemo obj = new DeadlockDemo();
		obj.t1.start();
		obj.t2.start();
	}
	
	//this is my one thread object, 
	//Created the thread object using Anonymous inner class
	//Here t1 object locks s1 and goes to sleep for 100 ms
	//Meanwhile t2 object locks s2 thread and attempts to access s1, but s1 is already locked by t1
	//When t1 wakes up it tries to acquire lock on s2, but s2 is already locked by t2
	Thread t1 = new Thread() {
		public void run() {
			while(true) {
				synchronized (s1) { //this will put lock on s1
					try {
						System.out.println(Thread.currentThread().getName() + " locked " + s1);
						Thread.sleep(100); //wait for 100 ms
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					synchronized (s2) { //Here i will put lock on s2
						System.out.println(Thread.currentThread().getName() + " locked " + s2);
						System.out.println(s1 + s2);
					}
				}
			}
		}
	};
	
	//Creating 2nd thread object
	Thread t2 = new Thread() {
		public void run() {
			while(true) {
				synchronized (s2) { //First i will put lock on S2
					System.out.println(Thread.currentThread().getName() + " locked " + s2);
					synchronized (s1) { //Then i will put lock on s1
						System.out.println(Thread.currentThread().getName() + " locked " + s1);
						System.out.println(s1 + s2);
					}
				}
			}
		}
	};

}

/*
 * How to detect deadlock
 * Jconsole tool (Java Monitoring and management console) -> jdk-bin
 * Local process and remote process
 * 
 * To resolve the issue, we need to code such that the  threads has to acquire locks
 * on the resources in the same order
*/