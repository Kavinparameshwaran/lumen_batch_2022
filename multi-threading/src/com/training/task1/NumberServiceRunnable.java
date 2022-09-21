package com.training.task1;

public class NumberServiceRunnable implements Runnable { //1
	private String name; 
	private NumberService service;
	private int countTo;

	public NumberServiceRunnable(String name, int countTo) {
		super();
		this.name = name;
		this.countTo = countTo;
		this.service=new NumberService();
		Thread thread=new Thread(this, name);//2 pass runnable to thread constructor
		thread.start();//3 
	}
	@Override
	public void run() {
		System.out.println(this.service.sumNumber(countTo)); //4 run method called by thread scheduler
	}

}
