package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharEx01 {
	public static void main(String[] args) {
		
		// System.in �� Ű���� �Է��� �ǹ�	
		// �ٿ��� �κа� ��ɻ�� �κ��� ���� ���߾� ����ϴ� Decorator Pattern�� ����
		// Ű����κ��� ���� �� �Է¹���
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
