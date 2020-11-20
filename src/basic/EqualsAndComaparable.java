package basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

class Model implements Comparable<Model> {
	
	String name;
	int height;
	int weight;
	
	Model(String name, int height, int weight){
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	@Override
	public boolean equals(Object O) {
		if(O instanceof Model) {
			return ((Model)O).name.equals(name);
		}
		else {
			return false;
		}
	}
	@Override
	public int compareTo(Model model) {
		
		return height-model.height;
		
	}
	@Override
	public String toString() {
		
		return name +" "+height+" "+weight;
	}
}

public class EqualsAndComaparable {
	
	public static void main(String[] args) {
		
		ArrayList<Model> list = new ArrayList<>();
		
		Model one = new Model("James",185, 70);
		Model two = new Model("Wattson",182, 75);
		Model three = new Model("Tom", 186, 68);
		Model four = new Model("James", 186, 71);
		
		list.add(one);list.add(two);list.add(three);list.add(four);
		
		HashSet<Model> hashset = new HashSet<>();
		TreeSet<Model> treeset = new TreeSet<>();
		
		
		//Hash Set의 올바른 사용법 : 비교 객체간의 동등성 판별이 명확해야 한다. HashCode() && Equals() 오버라이드 할 것.
		list.forEach( Model -> {
			hashset.add(Model);
		});
		
		// 새로들어오려는 객체는 만약 동등하게 여겨지는 객체가 있을 시 HashSet에 추가되지 못한다.
		System.out.println(hashset);
		System.out.println();
		
		for(Model m : list) {
			if(treeset.contains(m)) {
				System.out.println("[DATA ALREADY EXISTS!] "+m);
			}else {
				treeset.add(m);
				System.out.println("[ADDED] "+m);
			}
		}
		
		System.out.println(treeset);
		
		// Hashset에 넣을 떄는 Equals && HashCode 기준으로 동등성만을 따진다.
		// Treeset에 넣을 때는 Equals 등등에는 관심이 없고, Comparator만을 중심으로 대소비교만을 해서 넣을지 말지를 판단한다.
		// 같다고 판단되는 경우에는 새로들어오려는 객체를 삽입하지 않는다.
	}
}
