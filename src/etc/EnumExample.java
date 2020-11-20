package etc;

enum Season{
	SPRING("봄"),
	SUMMER("여름"),
	AUTUMN("가을"),
	WINTER("겨울");
	
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
