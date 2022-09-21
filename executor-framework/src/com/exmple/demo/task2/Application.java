package com.exmple.demo.task2;

import java.sql.Time;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Application {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(8);
		try {
			Callable<Integer> task = new CountNumber(10);
			Future<Integer> response = service.submit(task);
//			System.out.println("Is Task Completed:=" + response.isDone());
//			System.out.println("Result:=" + response.get());
//			System.out.println("Is Task Completed:=" + response.isDone());

//			if (response.isDone()) {
//				System.out.println("Result:=" + response.get());
//			}
			
			while(!response.isDone()) {
				System.out.println("Waiting to complete");
				TimeUnit.MILLISECONDS.sleep(50);
				System.out.println("Result:=" + response.get());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		service.shutdown();
	}

}
