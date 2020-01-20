package lesson14;
import java.util.*;
public class Question4 {
	static int n;
	static int[][] adj;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		adj = new int[n+1][n+1]; 
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			adj[x][y] = w;
			adj[y][x] = w;
		}
		int[] dis = new int[n+1];
		boolean vis[] = new boolean[n+1];
		Arrays.fill(dis, 0x03f3f3f3f);
		dis[1] = 0;
		for(int i = 0; i < n-1; i++) {
			int x = MIN(dis, vis);
			vis[x] = true;
			for(int j = 1; j < n+1; j++) {
				if (adj[x][j] != 0) {
					if(dis[x] != Integer.MAX_VALUE && dis[x] + adj[x][j] < dis[j]) {
						dis[j] = dis[x] + adj[x][j];
					}
				}
			}
		}
		for(int i = 1; i < n+1; i++) {
			if(dis[i] == 0x03f3f3f3f) {
				System.out.println(-1);
			}
			else {
				System.out.println(dis[i]);
			}
		}
	}
	static int MIN (int dis[], boolean vis[]) {
		int min  = 0x03f3f3f3f, minIndex = -1;
		for(int i = 1; i < n+1; i++) {
			if(vis[i] == false && dis[i] < min) {
				min = dis[i];
				minIndex = i;
			}
		}
		return minIndex;
	}


}
