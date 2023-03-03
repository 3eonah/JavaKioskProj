
import java.io.*;

public class FileCopy2 {

	public static void main(String[] args) throws IOException {
		FileReader inputData=null;
		FileWriter outputData=null;
		
		try {
			inputData=new FileReader("./input.txt");
			outputData=new FileWriter("output.txt");
			
			int c;
			while((c=inputData.read())!=-1) {
				//단순 by-passing. 필요시 처리 기능 구현
				outputData.write(c);
			}
		}finally {
			if(inputData!=null)	inputData.close();
			if(outputData!=null) outputData.close();
		}

	}

}
