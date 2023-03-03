
import java.awt.GridLayout;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import javax.swing.*;

public class OrderThread implements Runnable {
	String menu;
	String runMsg;
	String endMsg;

	//Constructor
	public OrderThread(String str) {

		menu=str;
		runMsg="["+menu+"] 를 조리중...";
		endMsg="["+menu+"] 를 조리 완료!";

	}
	public String getRunMsg() {
		return runMsg;
	}
	
	public String getEndMsg() {
		return endMsg;
	}

	@Override
	public void run() {
		
		try {
			
			System.out.println(runMsg);
			//조리 과정을 나타내는 스레드
			Thread t=new Thread(new CookingThread());
			t.start();
			Thread.sleep(1000); //timeout for 1 second
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(endMsg);

	}

}
