package org.gudigar.ConcurrentModificationException;

public class WaitAndNotifyAndNotifyAll {

	//throws interruptedException, whenever we use wait and notify
	public static void main(String[] args) throws InterruptedException {
		
		//Wait() caused the current thread to wait until another thread invokes the notify() or notifyAll methods
		//for that object
		//It tells the calling thread to give up the lock and go to sleep (goes to runnable stage) 
		//until some other thread enters the same monitor and calls notify()
		
		//Notify() wakes up a single thread that is waiting on that object's monitor
		//Notify all() wakes up all the threads that are waiting on that object's monitor
		
		/*
		A1 a = new A1();
		a.start();
		//we have to use synchronized since we use wait and notify
		synchronized (a) {
			System.out.println("Main thread");
			a.wait();
			System.out.println("Main thread got notified");
			System.out.println(a.t);
		}
		*/
		
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
	}

}

class Q{
	int num;
	boolean valueSet = false;
	public synchronized void put(int num) {
		while(valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Put : " + num);
		this.num = num;
		valueSet = true;
		notify();
	}
	
	public synchronized void get() {
		while(!valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Get : " + num);
		valueSet = false;
		notify();
	}
}

class Producer implements Runnable{
	Q q;

	public Producer(Q q) {
		this.q = q;
		Thread t = new Thread(this,"Producer");
		t.start();
	}

	@Override
	public void run() {
		int i=0;
		while(true) {
			q.put(i++);
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				
			}
		}	
	}	
}

class Consumer implements Runnable{
	Q q;

	public Consumer(Q q) {
		this.q = q;
		Thread t = new Thread(this,"Consumer");
		t.start();
	}

	@Override
	public void run() {
		while(true) {
			q.get();
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				
			}
		}	
	}	
}
class A1 extends Thread{
	
	int t = 0;
	public void run() {
		synchronized (this) {
			for (int i = 0; i <= 10; i++) {
				t = t + i;	
			}
			this.notify();
		}
	}
}
