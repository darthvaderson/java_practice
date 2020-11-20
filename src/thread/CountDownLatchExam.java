package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor01 implements Runnable{
	private CountDownLatch latch;
	
	Processor01(CountDownLatch latch){
		this.latch = latch;
	}
	
	public void run() {
		System.out.println("Started.");
		System.out.println("current : "+Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		latch.countDown();
	}
}


public class CountDownLatchExam {
	
	
	public static void main(String[] args) {
		
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(int i = 0 ; i < 3 ; i++) {
			executor.submit(new Processor01(latch));
		}
		
		//waits until countdownlatch counts down to zero
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Completed.");
		
	}
}
