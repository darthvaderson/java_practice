package thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerExam {
	
	//concurrent package에 속한 클래스들은 THREAD-SAFE하다. 따라서,
	//can access the instance from multiful threads, without worrying thread synchronization.
	
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					consumer();
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
	private static void producer() throws InterruptedException {
		Random random = new Random();
		
		while(true) {
			// put의 장점 : queue가 꽉 찼을 때, 공간이 생길 때까지 기다린다. 
			queue.put(random.nextInt(100));
		}
	}
	private static void consumer() throws InterruptedException {
		Random random = new Random();
		
		while(true) {
			Thread.sleep(100);
			
			if(random.nextInt(10) == 0) {
				// take는 만약에  queue가 비어있으면, 뭔가 들어올 때까지 기다린다.
				Integer value = queue.take();
				
				System.out.println("Taken value : "+value + "; Queue size is : "+queue.size());
			}
		}
	}
}
