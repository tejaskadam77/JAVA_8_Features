package com.example.threadCreation;

class Sender
{
	 public synchronized void send(String message)
	{
		 for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(message);
			}
	}
}

class Demo extends Thread
{
	String msg;
	Sender d;

	Demo(Sender d, String msg) {
		this.d = d;
		this.msg = msg;

	}
	public void run()
	{
		
		d.send(this.msg);
		
	}
	
}
public class SynchronisationDemo {
	public static void main(String[] args) {
		Sender s= new Sender();
		Demo a=new Demo(s,"tejas");
		Demo b=new Demo(s,"patil");
		a.start();
		b.start();

	}

}
