package thread;

import java.util.HashMap;

public class SyncBlockExample02 {
	
	private HashMap<String, String> mMap1 = new HashMap<>();
	private HashMap<String, String> mMap2 = new HashMap<>();
	
	private final Object ob1 = new Object();
	private final Object ob2 = new Object();
	
	public static void main(String[] args) {
		SyncBlockExample02 syncBlockExample02 = new SyncBlockExample02();
		System.out.println("@@@@@ TEST START @@@@@");
		new Thread(() -> {
			for(int i = 0 ; i < 10; i++) {
				syncBlockExample02.put1("A","B",i);
				syncBlockExample02.get2("C");
			}
		}).start();
		
		new Thread(() -> {
			for(int i = 0 ; i < 10; i++) {
				syncBlockExample02.put2("C","D",i);
				syncBlockExample02.get1("A");
			}
		}).start();
		System.out.println("@@@@@ TEST END @@@@@");
	}
	public void put1(String key, String value,int count) {
		synchronized(ob1) {
			mMap1.put(key, value);
			System.out.println("key : "+key+" value : "+value+" count : "+count);
		}
	}
	public String get1(String key) {
		synchronized(ob1) {
			System.out.println("get "+key+" value: "+mMap1.get(key));
			return mMap1.get(key);
		}
	}
	public void put2(String key, String value, int count) {
		synchronized(ob2) {
			mMap2.put(key, value);
			System.out.println("key : "+key+" value : "+value+" count : "+count);
		}
	}
	public String get2(String key) {
		synchronized(ob2) {
			System.out.println("get "+key+" value: "+mMap2.get(key));
			return mMap2.get(key);
		}
	}
}
