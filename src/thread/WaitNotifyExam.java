package thread;

class WorkObject {
	
	synchronized void methodA(int i) {
		System.out.println("ThreadA�� "+i+"��°"+" methodA() �۾� ����");
		notify();
		try {
			System.out.println("this is method A try block");
			wait();
		}catch(InterruptedException e) {
			
		}
		System.out.println("ThreadA�� "+i+"��°"+" methodA() �۾� �Ϸ�");

	}
	synchronized void methodB(int i) {
		System.out.println("ThreadB�� "+i+"��°"+" methodB() �۾� ����");
		notify();
		try {
			System.out.println("this is method B try block");
			wait();
		}catch(InterruptedException e) {
			
		}
		System.out.println("ThreadB�� "+i+"��°"+" methodB() �۾� �Ϸ�");

	}
}
class ThreadA extends Thread{
	WorkObject workObject;
	ThreadA(WorkObject workObject){
		this.workObject = workObject;
	}
	
	@Override
	public void run() {
		for(int i = 0 ; i < 5; i++) {
			workObject.methodA(i+1);
		}
	}
	
}
class ThreadB extends Thread{
	WorkObject workObject;
	ThreadB(WorkObject workObject){
		this.workObject = workObject;
	}
	
	@Override
	public void run() {
		for(int i = 0 ; i < 5; i++) {
			workObject.methodB(i+1);
		}
	}
	
}
public class WaitNotifyExam {
	
	public static void main(String[] args) {
		WorkObject sharedObject = new WorkObject();
		ThreadA a = new ThreadA(sharedObject);
		ThreadB b = new ThreadB(sharedObject);
		
		a.start(); 
		b.start();
		
		System.out.println("MAIN THREAD ENDED");
	}
}
