package ccc17;
import java.io.*;
import java.util.*;
public class Question1 {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer t;
	public static void main(String args[])throws IOException{
		int n = readInt();
		int[] sw = new int[n];
		int[] sem = new int[n];
		for(int i = 0; i < n; i++) {
			sw[i] = readInt();
		}
		for(int i = 0; i < n; i++) {
			sem[i] = readInt();
		}
		int sum1 = 0;
		int sum2 = 0;
		int index = 0; 
		for(int i = 0; i < n; i++) {
			sum1 += sw[i];
			sum2 += sem[i];
			if(sum1 == sum2) {
				index = i+1;
			}
		}
		System.out.println(index);
	}
	static int readInt() throws IOException {
		while (t == null || !t.hasMoreTokens()) {
			t = new StringTokenizer(br.readLine().trim());
		}
		return Integer.parseInt(t.nextToken());
	}
}
