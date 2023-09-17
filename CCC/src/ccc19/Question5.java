package ccc19;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Question5 {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer t;
	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = readInt();
		int k = readInt();
		int[][] triangle = new int[n][n];
		int m = -1;
		for(int  i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				triangle[i][j] = readInt();
				m = Math.max(m, triangle[i][j]);
			}
		}
		if (k == n) {
			System.out.println(m);
			return;
		}
		while(k > 1) {
			for(int i = 0; i < n-1; i++) {
				for(int j = 0; j <= i; j++) {
					triangle[i][j] = Math.max(triangle[i][j], Math.max(triangle[i+1][j], triangle[i+1][j+1]));
				}
			}
			n--;
			k--;
		}
		long sum = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <=i; j++) {
				sum+=triangle[i][j];
			}
		}
		System.out.println(sum);
	}
	static int readInt() throws IOException {
		while (t == null || !t.hasMoreTokens()) {
			t = new StringTokenizer(br.readLine().trim());
		}
		return Integer.parseInt(t.nextToken());
	}
}
