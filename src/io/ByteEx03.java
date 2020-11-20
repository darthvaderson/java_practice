package io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ByteEx03 {

	public static void main(String[] args) {
		/* 
		* try-with-resources ������
		*close()�޼ҵ带 ����ڰ� ȣ������ �ʴ���, 
		*Exception�� �߻����� �ʾҴٸ� �ڵ����� close()�� �ǰ� �� �� �ִ� ���
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
