package etc;

enum Season{
	SPRING("��"),
	SUMMER("����"),
	AUTUMN("����"),
	WINTER("�ܿ�");
	
	String name;
	
	Season(String name) {
		this.name = name;
	}
	String getName() {
		return name;
	}
}

public class EnumExample {
	
	public static void main(String[] args) {
		Season season = Season.valueOf("SPRING");
		Season[] seasons = Season.values();
		
		
		for(Season s : seasons) System.out.println(s.getName());
	}
	
}
