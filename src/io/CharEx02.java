package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CharEx02 {
	public static void main(String[] args) {
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try{
			br = new BufferedReader(new FileReader("src/io/CharEx02.java"));
			// PrintWriter 생성자에서 
			//따로 FileWrite를 받지 않고 파일명을 바로 넣어줘도 된다.
			pw = new PrintWriter(new FileWriter("test.txt"));
			String line = null;
			while((line=br.readLine()) != null){
				pw.println(line);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pw.close();
			try{
				br.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
