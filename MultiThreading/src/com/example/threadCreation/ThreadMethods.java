package com.example.threadCreation;

public class ThreadMethods {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getPriority());
		System.out.println(Thread.currentThread().getState());
		Thread.currentThread().setPriority(10);
		System.out.println(Thread.currentThread().getPriority());
	}

}
