package com.example.threadCreation;

class ChildThread extends Thread

{
	int total = 0;
	int n = 5;

	ChildThread(int n) {
		this.n = n;
	}

	public void run() {
	

		synchronized (this) {
			System.out.println("child thread strated calculation");
			for (int i = 0; i < n; i++) {
				total = total + i;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("child thread trying to notify after full calculation");
			this.notify();
		}
		// final value of total is calculated over here only.
		// 10000 line of code which will not change state of object.
		System.out.println("1000 lines of code excetued and total is --->" + total);
	}

}

public class ThreadCommunicationDemo {
	// without any java tools
	/*
	 * public static void main(String[] args) { ChildThread c= new ChildThread(5);
	 * c.start(); //this statement should give value of total after complete
	 * calculation. System.out.println("Intermediate value--->"+c.total); }
	 */

	/*
	 * by using join method it will wait until entire function to complete that is
	 * it will for entire run method to finish but result of total is getting
	 * earlier that is why cannot use join method.
	 */

	/*
	 * public static void main(String[] args) throws InterruptedException {
	 * ChildThread c= new ChildThread(5); c.start(); c.join();//main thread will
	 * wait until child thread completes its execution. //this statement should give
	 * value of total after complete calculation.
	 * System.out.println("Intermediate value--->"+c.total); }
	 */

	// by use of sleep method we cannot guarantee required time with this either we
	// will loose time or get inconsistent result

	/*
	 * public static void main(String[] args) throws InterruptedException {
	 * ChildThread c= new ChildThread(5); c.start(); Thread.sleep(5000);//main
	 * thread will sleep for sometime . //this statement should give value of total
	 * after complete calculation.
	 * System.out.println("Intermediate value--->"+c.total); }
	 */

	// now by using wait and notify we will communicate between threads
	// to call wait method it must have to get lock of that object that means it
	// must be called from synchronized block
//after calling wait method it will immediately release lock
	public static void main(String[] args) throws InterruptedException {
		ChildThread c = new ChildThread(5);
		c.start();

		synchronized (c) {
			System.out.println("main thread waiting for updation ");
			c.wait();// main thread calling wait as it is waiting for updation .
			System.out.println("main thread got notified");
			System.out.println("total value--->" + c.total);
		}
	}

}
