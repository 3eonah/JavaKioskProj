
import java.io.FileOutputStream;

public class ConsoleCopy {

	public static void main(String[] args) {
		if(args.length!=1) {
			System.out.println("usage:java ConsoleCopy <filename>");
			System.exit(1);
		}
		try {
			Copier cp=new Copier(System.in, new FileOutputStream(args[0]));
			//args[0] is <filename>
			cp.copy();
			//console에 친 내용이 <filename> 이름을 가진 file로 만들어짐
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
