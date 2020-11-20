package thread;

class MyThread extends Thread{
	
	String str;
	public MyThread(String str) {
		this.str = str;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10 ; i++) {
			System.out.println(str);
			try{
				Thread.sleep((int)(Math.random()*1000));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
public class ThreadExam {
	
	public static void main(String[] args) {
		MyThread t1 = new MyThread("Pop Smoke");
		MyThread t2 = new MyThread("Lil Tjay");
		
		//Thread 동작 시 run()이 아니라 start()를 호출한다.
		
		t1.start();
		t2.start();
		try {
			Thread.sleep(3000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Main Thread ENDED !");
	}
}
