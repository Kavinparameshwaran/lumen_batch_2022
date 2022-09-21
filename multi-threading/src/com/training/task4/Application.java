package com.training.task4;

public class Application {

	public static void main(String[] args) {
		BankAccount account = new BankAccount(1000);
		Thread firstThread = new Thread() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Current Balance after Withdraw:="+account.withdraw(5000));
			}

		};
		firstThread.start();
		Thread secondThread = new Thread() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Current Balance After Deposit:="+account.deposit(7000));
			}

		};
		secondThread.start();
	}

}
