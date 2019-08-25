package com.example.threadCreation;

class MyThread2 implements Runnable {
	Thread t;
	String name;

	MyThread2(String name) {
		this.name = name;
		t = new Thread(this);
	}

	public void start()

	{
		t.start();
	}

	public void run() {
		System.out.println("child Thread name======>  " + Thread.currentThread().getName());
		for (int i = 0; i < 10; i++) {
			System.out.println("in child thread");
		}
	}
}

//professional tracking number--- KUR605733431
public class Runnableimpl {
	public static void main(String[] args) throws InterruptedException {

		MyThread2 th = new MyThread2("fisrt child Thread");
		th.start();
		// System.out.println(Thread.currentThread().getPriority());
		th.t.join();// main thread will wait to join mythread2 th,. to finish its execution
		for (int i = 0; i < 10; i++) {
//Added comment.
			System.out.println("in Main thread");
		}

	}
}
