package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExample {

	
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		for(int i = 0 ; i < 10 ; i++) {
			
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)executorService;
					
					int poolSize = threadPoolExecutor.getCorePoolSize();
					String threadName = Thread.currentThread().getName();
					System.out.println("[총 스레드 개수  " +poolSize + "] 작업스레드 이름 : "+threadName);
					
					int value = Integer.parseInt("예외발생");
				}
			};
			
			executorService.submit(runnable);
			try {
				Thread.sleep(1000);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
