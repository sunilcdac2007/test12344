package com.harman.blockingQueue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class LockDemo {
public static void main(String ...args)
{
	try {
		//writeFile4();
		writeFile1();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
public static void writeFile1() throws IOException {
	File fout = new File("out.txt");
	FileOutputStream fos = new FileOutputStream(fout);
 
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
 
	for (int i = 0; i < 10; i++) {
		bw.write("something");
		bw.newLine();
	}
 
	bw.close();
}
public static void writeFile4() throws IOException {
	File fout = new File("out.txt");
	FileOutputStream fos = new FileOutputStream(fout);
 
	OutputStreamWriter osw = new OutputStreamWriter(fos);
 
	for (int i = 0; i < 10; i++) {
		osw.write("something");
	}
 
	osw.close();
}
	
}
