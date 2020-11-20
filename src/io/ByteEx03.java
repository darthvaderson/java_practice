package io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ByteEx03 {

	public static void main(String[] args) {
		/* 
		* try-with-resources 블럭선언
		*close()메소드를 사용자가 호출하지 않더라도, 
		*Exception이 발생하지 않았다면 자동으로 close()가 되게 할 수 있는 방법
		*/
		try(
				DataOutputStream out = new DataOutputStream(new FileOutputStream("data.txt"));
				){
			out.writeInt(100);
			out.writeBoolean(true);
			out.writeDouble(10.5);
			ArrayList<String> k = new ArrayList<>(Arrays.asList());
			List<String> j = Arrays.asList("a");
			k.add("a");
			for(String s : k) System.out.println(s);
			System.out.println(k.size());
			System.out.println(k.getClass());
			System.out.println(j.getClass());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
