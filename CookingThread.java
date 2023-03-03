
import java.util.*;

public class CookingThread implements Runnable{

	Thread mainT,t1,t2,t3;
	
	public CookingThread() {
		mainT=Thread.currentThread();
		t1=new Thread(this,"Prep");
		t2=new Thread(this,"Cook");
		t3=new Thread(this,"Decoration");
		
	}
	
	@Override
	public void run() {
		try {
			
			t1.start();
			System.out.println(mainT.getName()+"의 "+t1.getName()+"을 하는 중입니다.");
			
			t2.start();
			System.out.println(mainT.getName()+"의 "+t2.getName()+"을 하는 중입니다.");
			
			t3.start();
			System.out.println(mainT.getName()+"의 "+t3.getName()+"을 하는 중입니다.");
			
			Thread.sleep(1000);
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
	}
}
