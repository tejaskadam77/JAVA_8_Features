package com.example.threadCreation;

class MyThread extends Thread {
	public void run() {
		System.out.println("My First thread using extending thread class" );
	}
}

public class ThreadExtentionimpl {
	 public static void main(String[] args) {

		MyThread t = new MyThread();
		t.start();
	}
}
