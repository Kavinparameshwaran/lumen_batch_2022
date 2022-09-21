package com.training.task5;

import java.io.File;


public class Application {

	public static void main(String[] args) {
		File file=new File("Student.txt");
		String name="Kavin";
		ReadToTextFile readFile=new ReadToTextFile(file);
		WriteToTextFile writeFile=new WriteToTextFile(file, name);
		
		
		
	}

}
