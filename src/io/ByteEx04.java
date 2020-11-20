package io;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class ByteEx04 {

	public static void main(String[] args) {
		
		try(
				DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
				){
			int i = dis.readInt();
			boolean flag = dis.readBoolean();
			double k = dis.readDouble();
			System.out.println(i);
			System.out.println(flag);
			System.out.println(k);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
