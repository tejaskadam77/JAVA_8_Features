package com.example.threadCreation;

class YieldThread extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("in Child thread");
			// this will give chance to other threads of same or higher priority to execute
			// first by stopping its execution.
			Thread.yield();
			System.out.println("after yield method in child thread");
			// main thread will finish execution first.
		}
	}
}

public class ThreadYieldDemo {
	public static void main(String[] args) throws InterruptedException {
		YieldThread y = new YieldThread();
		y.start();
		y.join();

		for (int i = 0; i < 10; i++) {
			System.out.println("in Main thread");
		}
	}

}
