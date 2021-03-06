package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ByteEx01 {
	
	public static void main(String[] args) {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try{
			fis = new FileInputStream("src/io/ByteEx.java");
			fos = new FileOutputStream("byte.txt");
			
			int readData = -1;
			while((readData = fis.read()) != -1) {
				fos.write(readData);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				fis.close();
				fos.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
