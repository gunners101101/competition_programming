package lesson1;
import java.util.*;
import java.io.*;
public class Question5 {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer t;
	public static void main(String args[]) throws IOException{
		int n = readInt();
		int[][] psa = new int[652][652];
		int a[] = new int[500002];
		int b[] = new int[500002];
		for(int i = 1; i <= n; i++) {
			a[i] = readInt();
			b[i] = readInt();
			a[i]++;
			b[i]++;
			psa[a[i]][b[i]]++;
		}
		for(int i = 1; i <= 651; i++) {
			for(int j = 1; j <= 651; j++) {
				psa[i][j] += psa[i-1][j] + psa[i][j-1] - psa[i-1][j-1];
			}
		}
		for(int i = 1; i <= n; i++) {
			int x = a[i];
			int y = b[i];
			int hi = psa[651][651] - psa[x][651] - psa[651][y] + psa[x][y];
			int lo = psa[x-1][y-1];
			if(x==651) {
				lo += psa[1][y] - psa[1][y-1];
			}
			if(y==651) {
				lo += psa[x][651] - psa[x-1][651];
			}
			System.out.println((hi+1) + " " + (n-lo));
		}
	}
	static int readInt() throws IOException {
		while (t == null || !t.hasMoreTokens()) {
			t = new StringTokenizer(br.readLine().trim());
		}
		return Integer.parseInt(t.nextToken());
	}
}
