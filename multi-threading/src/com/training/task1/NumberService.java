package com.training.task1;

public class NumberService {
public NumberService() {
	super();
}
public int sumNumber(int countTo) {
	int sum=0;
	for (int i = 0; i <= countTo; i++) {
		sum+=i;
	}
	System.out.println("Current Thread:= "+Thread.currentThread().getName());
	return sum;
	
}
}
