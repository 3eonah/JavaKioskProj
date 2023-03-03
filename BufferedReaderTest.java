
import java.io.*;
import java.util.*;

public class BufferedReaderTest {

	String file;
	char comment;
	String delm;
	Hashtable ht;
	
	public BufferedReaderTest(String file) {
		this(file,'#'," \t");
	}
	
	public BufferedReaderTest(String file, char comment) {
		this(file, comment, "\t");
	}
	
	public BufferedReaderTest(String file, char comment, String delm) {
		this.file=file;
		this.comment=comment;
		this.delm=delm;
		ht=new Hashtable();
	}
	
	public void parse() throws IOException{
		String rl;
		BufferedReader br=new BufferedReader(new FileReader(file));
		
		while((rl=br.readLine())!=null) {
			rl=rl.trim();
			if(rl.charAt(0)==comment) {
				continue;
			}else {
				StringTokenizer st=new StringTokenizer(rl,delm,false);
				String key=st.nextToken();
				String value=st.nextToken();
				ht.put(key, value);
			}
		}
		br.close();
	}
	
	public String getValue(String name) {
		return (String)ht.get(name);
	}
	
	public static void main(String[] args) {
		BufferedReaderTest brt=new BufferedReaderTest("server.conf");
		try {
			brt.parse();
			System.out.println(brt.getValue("port"));
			System.out.println(brt.getValue("server"));
			System.out.println(brt.getValue("admin"));
			System.out.println(brt.getValue("port"));

		}catch(Exception e) {
			
		}

	}

}
