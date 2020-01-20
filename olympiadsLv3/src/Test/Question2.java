package Test;
import java.io.*;
import java.util.*;

public class Question2 {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer t;
	public static void main(String args[]) throws IOException {
		int n = readToken();
		long m = readToken();
		Factory[] fact = new Factory[n];
		for(int i = 0; i < n; i++) {
			fact[i] = new Factory(readToken(), readToken());
		}
		Arrays.sort(fact);
		long ans = 0;
		long box = 0;
		for(int i = 0; i < n; i++) {
			//System.out.println(ans);
			if(fact[i].a + box > m) {
				ans += (m-box)*fact[i].p;
				box += m-box;
			}
			else {
				ans += fact[i].a*fact[i].p;
				box += fact[i].a;
				
			}
		}
		System.out.println(ans);
	}
	static class Factory implements Comparable<Factory>{
		int p, a;
		Factory(int p0, int a0){p = p0; a = a0;}
		public int compareTo(Factory x) {return Integer.compare(p, x.p);}
	}
	static int readToken() throws IOException {
		while (t == null || !t.hasMoreTokens()) {
			t = new StringTokenizer(br.readLine().trim());
		}
		return Integer.parseInt(t.nextToken());
	}
}
