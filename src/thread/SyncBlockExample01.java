package thread;

import java.util.ArrayList;

public class SyncBlockExample01 {
	
	public ArrayList<Integer> mList = new ArrayList<>();
	
	public static void main(String[] args) throws InterruptedException {
		
		SyncBlockExample01 temp = new SyncBlockExample01();
		System.out.println("@@@@@ TEST START @@@@@");
		Thread t1 = new Thread( () -> {
			for(int i = 0 ; i <10000 ; i++) {temp.add(i);}
		});
		
		Thread t2 = new Thread( () -> {
			for(int i = 0 ; i <10000 ; i++) {temp.add(i);}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(temp.mList.size());
		System.out.println("@@@@@ TEST END @@@@@");
	}
	public void add(int val) {
		
		//Do Something Else : ����ȭ�� �ʿ� ���� �κ�
		//�ش� �κ� ������ ������ synchronized void add(int val)�� �����ϴ�.
		
		synchronized(this) {
			if(mList.contains(val)==false) {
				mList.add(val);
			}
		}
		
	}
}
