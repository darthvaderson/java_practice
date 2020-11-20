package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharEx01 {
	public static void main(String[] args) {
		
		// System.in 은 키보드 입력을 의미	
		// 근원지 부분과 기능사용 부분을 끼워 맞추어 사용하는 Decorator Pattern의 예시
		// 키보드로부터 한줄 씩 입력받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try{
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(line);
		
	}
}
