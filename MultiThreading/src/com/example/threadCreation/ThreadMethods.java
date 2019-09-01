package com.example.threadCreation;

class Mythread1 extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("in child thread");
		}
	}
}
class ThreadPriorityDemo extends Thread
{
	public void run()
	{for (int i = 0; i < 10; i++) {
		System.out.println("ThreadPriorityDemo   ---> in child thread");
	}
		
	}
}

public class ThreadMethods {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getPriority());
		System.out.println(Thread.currentThread().getState());
		Thread.currentThread().setPriority(10);
		System.out.println(Thread.currentThread().getPriority());
		Thread.currentThread().setName("First rename of thread");
		System.out.println(Thread.currentThread().getName());
		Mythread1 m = new Mythread1();
		//m.start();
		ThreadPriorityDemo t = new ThreadPriorityDemo();
		t.start();
		t.setPriority(10);//ThreadPriorityDemo thread will run first.	
		for (int i = 0; i < 10; i++) {
			System.out.println("ThreadPriorityDemo   ---> in child thread");
		}
		
	}

}
