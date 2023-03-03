
import java.io.*;

public class Copier {
	protected InputStream in;
	protected OutputStream out;
	protected byte data[];
	
	//Constructor
	public Copier(InputStream in, OutputStream out, int size) {
		this.in=in;
		this.out=out;
		data=new byte[size];
	}
	
	public Copier(InputStream in, OutputStream out) {
		this(in, out, 1024);
	}
	//method
	public void copy() throws IOException{
		int n=0;
		while((n=in.read(data))!=-1) {
			//Processing 기능 추가 (Why need IO)
			out.write(data,0,n);
		}
		in.close();
		out.close();
	}
}
