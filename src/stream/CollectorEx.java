package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectorEx {
	
	public static void main(String[] args) {
		
		
		List<String> list  = Arrays.asList("a","b","c","d");
		for(String s : list) {
			System.out.println(s);
		}
		System.out.println(list.getClass());
		System.out.println(new ArrayList<String>(list).getClass());
	}
}
