package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ByteEx02 {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try{
			fis = new FileInputStream("src/io/ByteEx.java");
			fos = new FileOutputStream("byte.txt");
			
			int readCount = -1;
			byte[] buffer = new byte[512];
			while((readCount = fis.read(buffer)) != -1) {
				fos.write(buffer,0,readCount);
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
		long end = System.currentTimeMillis();
		System.out.println(start-end);
		
	}
}
