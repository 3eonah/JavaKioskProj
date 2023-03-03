
import java.io.IOException;

public class ConsoleIO_1 {

	public static void main(String[] args) {
		int b=0, count=0;
		try {
			//read() 메소드는 입력 스트림에서 더 이상 읽어들일 바이트가 없으면 -1을 반환
			//-1을 표현하기 위해 반환 타입을 int형으로 선언
			b=System.in.read();
			while(b!='z') {
				//while (b!= -1)
				
				System.out.print((char)b);
				count++;
				b=System.in.read();
			}
		}
		catch(IOException e){
			System.out.println();
			System.out.println("total byte: "+count);
			System.out.println(e);
		}
		System.out.println();
		System.out.println("total byte:"+count);

	}

}
