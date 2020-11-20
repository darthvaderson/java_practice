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
		
		// �ڹٴ� ���� ��Ӹ� �����Ѵ�. ����, Ư�� Ŭ������
		// �̹�  �ٸ� Ŭ������ ����ϰ� ���� ��� Thread Ŭ������ ��ӹ��� ���Ѵ�.
		// �ݸ� Interface�� �������� implement �����ϱ� ������ Runnable Interface�� �����Ѵ�.
		
		MyRunnable t1 = new MyRunnable("2pac");
		MyRunnable t2 = new MyRunnable("Biggie");
		
		//MyThread �� Thread�� ��ӹ��� �ʾұ� ������ start() Method�� ����. run()�ۿ� ����.
		
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t2);
		
		thread1.start();
		thread2.start();
		
		System.out.println("Main Thread ENDED !");
	}
}
