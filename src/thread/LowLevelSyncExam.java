package thread;

import java.util.LinkedList;
import java.util.Random;

class Processor {
	
	private LinkedList<Integer> list = new LinkedList<>();
	private final int LIMIT = 10;
	private Object lock = new Object();
	
	void produce() throws InterruptedException{
		
		int value = 0;
		
		while(true) {
			
			synchronized(lock) {
				
				while(list.size() == LIMIT) {
					lock.wait();
				}
				
				list.add(value++);
				lock.notify();
			}
			
		}
	}
	void consume() throws InterruptedException{
		
		Random random = new Random();
		
		while(true) {
			
			synchronized(lock) {
				
				while(list.size() == 0){
					lock.wait();
				}
				System.out.print("List size is : "+list.size());
				int value = list.removeFirst();
				System.out.println("; value is : "+value);
				lock.notify();
			}
			
			Thread.sleep(random.nextInt(1000));
		}
	}
	
	
}
public class LowLevelSyncExam {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		final Processor processor = new Processor();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
		
		// main thread waits until t1, t2 thread ends
		t1.join();
		t2.join();
		
	}
}
