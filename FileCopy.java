

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {

	public static void main(String[] args) {
		if(args.length!=2) {
			System.out.print("usage: java FileCopy");
			System.out.println("<filename> <filename>");
			System.exit(1);
		}
		try {
			Copier cp=new Copier(new FileInputStream(args[0]), 
					new FileOutputStream(args[1],true));
			cp.copy();
			System.out.println("파일 복사가 완료되었습니다.");
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
