package thread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor02 implements Runnable{
	
	private int id;
	
	public Processor02(int id) {
		this.id = id;
	}
	
	public void run() {
		System.out.println("Starting :" + id);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
		}
		System.out.println("Completed :"+id);
	}
	
}
public class ThreadPoolExample02 {
	
	public static void main(String[] args) {
		
		// 유효 프로세서 갯수
		System.out.println(Runtime.getRuntime().availableProcessors());
		// 쓰레드 풀 크기를 2개로 설정
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for(int i = 0 ; i < 5 ; i++) {
			executor.submit(new Processor02(i));
		}
		
		executor.shutdown();
		
		System.out.println("All tasks submitted. ");
		
		try {
			if(executor.awaitTermination(5, TimeUnit.SECONDS)) {
				System.out.println("TASK COMPLETED");
			}else {
				List<Runnable> list = executor.shutdownNow();
				System.out.println(list.toString());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
