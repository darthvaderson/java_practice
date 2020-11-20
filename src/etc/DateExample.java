package etc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
	
	public static void main(String[] args) {
		//Date to String
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = format.format(now);
		System.out.println(str);
		System.out.println(now.getTime());
		
		//String to Date
		//1.
		try {
			String st = "2020-10-13 01:04:33";
			SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = form.parse(st);
			System.out.println(date.getTime());
		}catch(ParseException e) {
			e.printStackTrace();
		}
		System.out.println();
		//2.
		try{
			String s = "01:04:33";
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			Date d = sdf.parse(s);
			System.out.println(d);
			System.out.println(d.getTime());
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
	}
}
