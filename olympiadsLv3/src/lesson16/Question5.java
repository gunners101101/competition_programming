package lesson16;
import java.io.*;
import java.util.*;
public class Question5 {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer t;
	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = readToken();
		int m = readToken();
		ArrayList<Integer> list[] = new ArrayList[n+m+1];
		for(int i = 1; i < n+m+1; i++) {
			list[i] = new ArrayList<>();
		}
		int k = readToken();
		for(int i = 0; i < k; i++) {
			int x = readToken();
			int y = n+readToken();
			list[x].add(y);
			list[y].add(x);
		}
		for(int i = 1; i < n+1; i++) {
			boolean vis[] = new boolean[n+m+1];
			for(int j : list[i]) {
				for(int p: list[j]) {
					if(p != i) {
						if(!vis[p]) {
							vis[p] = true;
						}
						else {
							System.out.println("NO");
							return;
						}
					}
				}
			}
		}
		System.out.println("YES");
	}
	static int readToken() throws IOException {
		while (t == null || !t.hasMoreTokens()) {
			t = new StringTokenizer(br.readLine().trim());
		}
		return Integer.parseInt(t.nextToken());
	}
}
