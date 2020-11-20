package io;

import java.io.IOException;
import java.util.Scanner;

public class StandardIO {
	public static void main(String[] args) throws IOException{
		
		
		int a = System.in.read();
		System.out.println("a : "+a);
		int b = System.in.read();
		System.out.println("b : "+b);
		int c = System.in.read();
		System.out.println("c : "+c);
		
		/*
		 * System.in.read()는 하나의 바이트를 입력받아서 처리한다.
		 * 해당 값은 ASCII코드 문자에 대응하는 값으로 저장되며,
		 * 키보드 엔터값이 포함된다.
		 */	
		
		
		try {
			int input;
			while((input=System.in.read()) != -1) {
				System.out.println("input:"+input+",(char)input:"+(char)input);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * 예 1)
		 * ​char a = (char) System.in.read();
		 * 이 함수가 입력되는 것은 0~255까지의 아스키코드 값이므로 char형으로 받고 싶다면 형변환을
		 * 하여서 받아야한다.​
		 * 
		 * 예 2)
		 * int a = System.in.read() - 48;
		 * 숫자를 문자로 인식하기 때문에 해당 숫자의 아스키코드값을 입력받게된다. 따라서 0의 아스키
		 * 코드값인 48을 빼주어서 입력받는다.
		 */




	}
}
