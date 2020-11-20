package basic;


class Person{
	
	String name;
	static {
		System.out.println("Person Static Block");
	}
	Person(String name){
		this.name  = name;
		System.out.println(name+" constructed");
	}
	{
		System.out.println("Person instance [" + this.hashCode() +"]" );
	}
	
}
public class StaticAndInstanceBlockExam {
	
	public static void main(String[] args) {
		
		/*
		 * 실행 순서
		 * 클래스 인스턴스 처음 생성될 때,
		 * 클래스  static 블록은 최초 1회만 실행된다. 아마도 정적 자원들 초기화 목적이 아닌가 싶음.
		 * 인스턴스가 생성될 때마다,
		 * 먼저 인스턴스 블록이 실행 된 다음, 생성자 내부 로직이 실행된다.
		 */
		Person p1 = new Person("철수");
		Person p2 = new Person("철희");
		Person p3 = new Person("젠틀맨");
		
	}
}
