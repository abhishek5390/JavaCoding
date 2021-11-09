package org.gudigar.ObjectClassLevelLock;

public class LockLevels {

	public static void main(String[] args) {
		RunnerService r1 = new RunnerService();
		RunnerService r2 = new RunnerService();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}

}
