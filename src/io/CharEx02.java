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
			// PrintWriter �����ڿ��� 
			//���� FileWrite�� ���� �ʰ� ���ϸ��� �ٷ� �־��൵ �ȴ�.
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
