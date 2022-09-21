package com.training.demo.task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
	public static void singleThreadExecutor() {
		ExecutorService service = Executors.newSingleThreadExecutor();
		UsingPringString[] tasks = { new UsingPringString("Idly", "Sambar"), new UsingPringString("Pizza", "Coke"),
				new UsingPringString("Paratha", "Achar"), new UsingPringString("Tea", "Biscuit") };
		for (UsingPringString eachTask : tasks) {
			service.submit(eachTask);

		}
		service.shutdown();
	}
	
	public static void fixedThreadPool() {
		int processorCount=Runtime.getRuntime().availableProcessors();
		System.out.println("Processor Count:="+processorCount);
		ExecutorService service = Executors.newFixedThreadPool(3);
		UsingPringString[] tasks = { 
				new UsingPringString("Idly", "Sambar"),
				new UsingPringString("Pizza", "Coke"),
				new UsingPringString("Tea", "Biscuit"),
				new UsingPringString("Paratha", "Achar")  
				};
		for (UsingPringString eachTask : tasks) {
			service.submit(eachTask);

		}
		service.shutdown();
	}

	public static void main(String[] args) {
//		singleThreadExecutor();
		fixedThreadPool();
	}

}
