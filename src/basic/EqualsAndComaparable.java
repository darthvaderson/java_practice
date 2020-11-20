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
		
		
		//Hash Set�� �ùٸ� ���� : �� ��ü���� ��� �Ǻ��� ��Ȯ�ؾ� �Ѵ�. HashCode() && Equals() �������̵� �� ��.
		list.forEach( Model -> {
			hashset.add(Model);
		});
		
		// ���ε������� ��ü�� ���� �����ϰ� �������� ��ü�� ���� �� HashSet�� �߰����� ���Ѵ�.
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
		
		// Hashset�� ���� ���� Equals && HashCode �������� ������� ������.
		// Treeset�� ���� ���� Equals ���� ������ ����, Comparator���� �߽����� ��Һ񱳸��� �ؼ� ������ ������ �Ǵ��Ѵ�.
		// ���ٰ� �ǴܵǴ� ��쿡�� ���ε������� ��ü�� �������� �ʴ´�.
	}
}
