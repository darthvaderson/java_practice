package thread;

class MyRunnable implements Runnable{
	
	String str;
	MyRunnable(String str){
		this.str = str;
	}
	@Override
	public void run() {
		for(int i = 0 ; i < 10 ; i++) {
			System.out.println(str);
			try {
				Thread.sleep((int)(Math.random()*1000));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
public class RunnableExam {

	public static void main(String[] args) {
		
		// 자바는 단일 상속만 지원한다. 따라서, 특정 클래스가
		// 이미  다른 클래스를 상속하고 있을 경우 Thread 클래스를 상속받지 못한다.
		// 반면 Interface는 여러가지 implement 가능하기 때문에 Runnable Interface가 존재한다.
		
		MyRunnable t1 = new MyRunnable("2pac");
		MyRunnable t2 = new MyRunnable("Biggie");
		
		//MyThread 는 Thread를 상속받지 않았기 떄문에 start() Method가 없다. run()밖에 없다.
		
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t2);
		
		thread1.start();
		thread2.start();
		
		System.out.println("Main Thread ENDED !");
	}
}
