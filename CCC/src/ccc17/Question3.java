package ccc17;
import java.io.*;
import java.util.*;
public class Question3 {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer t;
	public static void main(String args[]) throws IOException{
		int[] length = new int[2001];
		int[] sums = new int[4001];
		int n = readInt();
		for(int i = 0; i <n; i++) {
			length[readInt()]++;
		}
		for(int i = 1; i < 2001; i++) {
			if(length[i] > 0) {
				for(int j = i; j < 2001; j++) {
					if(j == i) {
						sums[i+j] += length[j]/2;
					}
					else {
						sums[i+j] += Math.min(length[i], length[j]);
					}
				}
			}
		}
		int longest = 0;
		int longest_freq = 0;
		for(int i = 1; i < 4001; i++) {
			if(sums[i] > longest) {
				longest = sums[i];
				longest_freq = 1;
			}
			else if(longest == sums[i]) {
				longest_freq++;
			}
		}
		System.out.println(longest + " " + longest_freq);
	}
	static int readInt() throws IOException {
		while (t == null || !t.hasMoreTokens()) {
			t = new StringTokenizer(br.readLine().trim());
		}
		return Integer.parseInt(t.nextToken());
	}
}
