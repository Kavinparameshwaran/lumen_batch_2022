package com.training.task5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class WriteToTextFile implements Runnable {
	private File file;
	private String name;
	public WriteToTextFile(File file,String name) {
		super();
		this.file=file;
		this.name=name;
		Thread secondThread=new Thread(this);
		secondThread.start();
	}

	@Override
	public void run() {
		System.out.println(writeToTextFile(name,file));
	}
	public  synchronized String writeToTextFile(String name, File file) {
		boolean result = false;
		try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
			writer.println(name);
			result = true;

		} catch (IOException e) {
			e.printStackTrace();
		}
		notifyAll();
		return "File has been written";
	}
	
	


}
