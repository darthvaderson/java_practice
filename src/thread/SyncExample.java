package thread;

public class SyncExample {
	private String mMessage;
	
	public static void main(String[] args) {
		SyncExample temp = new SyncExample();
		System.out.println("@@@@@ Test START @@@@@");
		
		new Thread( () -> {
			for(int i = 0 ; i < 1000; i++) {
				temp.callMe("Thread1");
			}
		}).start();
		
		new Thread( () -> {
			for(int i = 0 ; i < 1000 ; i++) {
				temp.callMe("Thread2");
			}
		}).start();
		
		System.out.println("@@@@@ Test END @@@@@");
		
	}
	//�޼ҵ忡 synchronized�� �ɸ� �� �Լ��� ���Ե� �ش� ��ü�� LOCK�� �Ŵ� ���̴�.
	public synchronized void callMe(String whoCallMe) {
		mMessage = whoCallMe;
		
		try {
			long sleep = (long) (Math.random() * 100);
			Thread.sleep(sleep);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		if(!mMessage.contentEquals(whoCallMe)) {
			System.out.println(whoCallMe+ "|"+mMessage);
		}
	}
}
