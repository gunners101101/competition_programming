package ccc21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class P3 {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer t;
	public static void main(String args[]) throws Exception{
		int n =  readInt();
		int farthest = 0;
		person[] friend = new person[n];
		for(int i = 0; i < n; i++) {
			int p = readInt();
			if(p > farthest) {
				farthest = p;
			}
			int w = readInt();
			int d = readInt();
			friend[i] = new person(p, w, d);
		}
		long min = Integer.MAX_VALUE;
		for(int i = 0; i < farthest+1; i++) {
			long temp = 0;
			for(int j = 0; j < n; j++) {
				long dis = Math.abs(i-friend[j].P)-friend[j].D;
				if(dis > 0) {
					temp += dis*friend[j].W;
				}
			}
			if(temp < min) {
				min = temp;
			}
		}
		System.out.println(min);
	}
	static int readInt() throws IOException {
		while (t == null || !t.hasMoreTokens()) {
			t = new StringTokenizer(br.readLine().trim());
		}
		return Integer.parseInt(t.nextToken());
	}
	static long readLong() throws IOException {
		while (t == null || !t.hasMoreTokens()) {
			t = new StringTokenizer(br.readLine().trim());
		}
		return Integer.parseInt(t.nextToken());
	}
	static class person {
		long P, W, D;
		person(long p0, long w0, long d0){P = p0; W = w0; D = d0;}
	}
}
