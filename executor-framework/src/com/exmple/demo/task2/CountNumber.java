package com.exmple.demo.task2;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CountNumber implements Callable<Integer> {
	private int countTo;

	public CountNumber(int countTo) {
		super();
		this.countTo = countTo;
	}

	@Override
	public Integer call() throws Exception {
		int total = 0;
		for (int ind = 0; ind <= countTo; ind++) {
			total += ind;

		}
		TimeUnit.MILLISECONDS.sleep(100);
		return total;
	}

}
