package lesson1;
import java.util.*;
import java.io.*;
public class Question3 {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer t;
	public static void main(String args[]) throws IOException{
		int n = readInt();
		int m = readInt();
		int k = readInt();
		long dif[][] = new long[5003][5003];
		long psa[][] = new long[5003][5003];
		for(int i = 0; i < k; i++) {
			int r1 = readInt();
			int c1 = readInt();
			int r2 = readInt();
			int c2 = readInt();
			r2++;
			c2++;
			dif[r1][c1]++;
			dif[r1][c2]--;
			dif[r2][c1]--;
			dif[r2][c2]++;
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				dif[i][j] += dif[i-1][j] + dif[i][j-1] - dif[i-1][j-1];
				psa[i][j] += psa[i-1][j] + psa[i][j-1] - psa[i-1][j-1] + dif[i][j];
			}
		}
		int q = readInt();
		for(int i = 1; i <= q; i++) {
			int r1 = readInt();
			int c1 = readInt();
			int r2 = readInt();
			int c2 = readInt();
			r1--; 
			c1--;
			System.out.println(psa[r2][c2] - psa[r1][c2] - psa[r2][c1] + psa[r1][c1]);
		}
	}
	static int readInt() throws IOException {
		while (t == null || !t.hasMoreTokens()) {
			t = new StringTokenizer(br.readLine().trim());
		}
		return Integer.parseInt(t.nextToken());
	}
}
