
import java.io.*;

public class DataStreamTest {

	public static void main(String[] args) throws IOException {
		DataInputStream in=null;
		DataOutputStream out=null;
		
		try {
			out=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("data.txt")));
			out.writeDouble(11.03);
			out.writeInt(1960);
			out.writeUTF("Java Data Processing for IO Stream: 문자 출력.");
			out.flush();
			
			in=new DataInputStream(new BufferedInputStream(new FileInputStream("data.txt")));
			System.out.println(in.readDouble());
			System.out.println(in.readInt());
			System.out.println(in.readUTF());

		}
		finally {
			if(in!=null) in.close();
			if(out!=null) out.close();
		}

	}

}
