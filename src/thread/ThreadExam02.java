package thread;

class MusicBox {
	
	public synchronized void playMusicA() {
		for(int i = 0 ; i < 10 ; i++) {
			System.out.println("PLAY  HIPHOP");
			
			try {
				Thread.sleep((int)(Math.random()*1000));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void playMusicB() {
		for(int i = 0 ; i < 10 ; i++) {
			System.out.println("PLAY  CLASSIC");
			
			try {
				Thread.sleep((int)(Math.random()*1000));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void playMusicC() {
		for(int i = 0 ; i < 10 ; i++) {
			synchronized(this) {
			System.out.println("PLAY  AMBIENT");
			}
			try {
				Thread.sleep((int)(Math.random()*1000));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
class MusicPlayer extends Thread{
	
	int type;
	MusicBox musicBox;
	
	MusicPlayer(int type, MusicBox musicBox){
		this.type = type;
		this.musicBox = musicBox;
	}
	@Override
	public void run() {
		switch(type) {
		case 1:
			musicBox.playMusicA();
			break;
		case 2:
			musicBox.playMusicB();
			break;
		case 3:
			musicBox.playMusicC();
			break;
		}
	}
}
public class ThreadExam02 {
	
	public static void main(String[] args) {
		
		MusicBox box = new MusicBox();
		
		MusicPlayer kim = new MusicPlayer(1, box);
		MusicPlayer sun = new MusicPlayer(2, box);
		MusicPlayer hyo = new MusicPlayer(3, box);
		
		kim.start(); sun.start(); hyo.start();
		
	}
}
