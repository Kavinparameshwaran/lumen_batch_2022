package com.training.task5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadToTextFile implements Runnable {
	private File file;

	public ReadToTextFile(File file) {
		super();
		this.file = file;
		Thread firstThread = new Thread(this);
		firstThread.start();

	}

	@Override
	public void run() {
		try {
			System.out.println(readFromTextFile(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public synchronized String readFromTextFile(File file) throws IOException {
		String name = "";
		String line = null;
		if (file.length() == 0) {
			try {
				System.out.println("File is empty");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		BufferedReader reader = new BufferedReader(new FileReader(file));
		while ((line = reader.readLine()) != null) {
			String[] values = line.split(",");
			for (String eachString : values) {
				name +=eachString+",";
			}
		}
		reader.close();
		System.out.println("File has been read");
		return name;
	}
}
