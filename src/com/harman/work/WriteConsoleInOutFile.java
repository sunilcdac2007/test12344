package com.harman.work;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class WriteConsoleInOutFile {

	public static void main(String...strings)
	{
		System.out.println("returning script name my_script");
		 PrintStream o=null;
		try {
			o = new PrintStream(new File("D://A.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 PrintStream console = System.out;
		 System.setOut(o);
		 System.out.println("This will be written to the text file");
		 
		 System.out.println("This will be written on the console!");
		 
		 System.out.println("This will be written on the console!");
		 System.out.println("This will be written on the console!");
		 System.setOut(console);
	}
	
}
