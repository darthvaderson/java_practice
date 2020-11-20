package etc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class TimeExample {
	
	public static void main(String[] args) {
		
		//JAVA 8���� �߰��� Time PACKAGE, ������ Date �Ǵ� Calendar�� ��ü
		
		LocalDateTime timePoint = LocalDateTime.now();
		System.out.println(timePoint);
		
		LocalDate ld1 = LocalDate.of(2020, Month.OCTOBER, 17);
		System.out.println(ld1);
		
		LocalTime lt1 = LocalTime.of(17, 40);
		System.out.println(lt1);
		LocalTime lt2 = LocalTime.parse("10:15:30");
		System.out.println(lt2);
		
		LocalDate ld2 = timePoint.toLocalDate();
		System.out.println(ld2);
		
		Month month = timePoint.getMonth();
		System.out.println(month);
		
	}
}
