package lesson1;
import java.io.*;
import java.util.*;
public class Question4 {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer t;
	public static void main(String args[]) throws IOException{
		int n = readInt();
		int t = readInt();
		long da[] = new long[t+2];
		long db[] = new long[t+2];
		long dc[] = new long[t+2];
		for(int i = 1; i <= n; i++) {
			int x = readInt();
			int y = readInt();
			int a = readInt();
			int b = readInt();
			int c = readInt();
			long va = a;
			long vb = b-2L*a*x;
			long vc = 1L*a*x*x - 1L*b*x +c;
			da[x] += va;
			db[x] += vb;
			dc[x] += vc;
			da[y+1] -= va;
			db[y+1] -= vb;
			dc[y+1] -= vc;
		}
		for(int i = 1; i <= t; i++) {
			da[i] += da[i-1]; 
			db[i] += db[i-1]; 
			dc[i] += dc[i-1]; 
			System.out.print(da[i]*i*i + db[i]*i + dc[i] + " ");
		}
	}
	static int readInt() throws IOException {
		while (t == null || !t.hasMoreTokens()) {
			t = new StringTokenizer(br.readLine().trim());
		}
		return Integer.parseInt(t.nextToken());
	}
}
