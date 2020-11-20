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
		 * ���� ����
		 * Ŭ���� �ν��Ͻ� ó�� ������ ��,
		 * Ŭ����  static ����� ���� 1ȸ�� ����ȴ�. �Ƹ��� ���� �ڿ��� �ʱ�ȭ ������ �ƴѰ� ����.
		 * �ν��Ͻ��� ������ ������,
		 * ���� �ν��Ͻ� ����� ���� �� ����, ������ ���� ������ ����ȴ�.
		 */
		Person p1 = new Person("ö��");
		Person p2 = new Person("ö��");
		Person p3 = new Person("��Ʋ��");
		
	}
}
