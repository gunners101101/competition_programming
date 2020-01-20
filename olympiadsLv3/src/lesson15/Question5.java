package lesson15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Question5 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int g = sc.nextInt();
		boolean[] fresh = new boolean[n+1];
		for(int i = 0; i < g; i++) {
			fresh[sc.nextInt()] = true;
		}
		List<Edge> adj[] = new ArrayList[n+1];
		for(int i = 0; i < n+1; i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i = 1; i <= m; i++) {
			int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
			adj[u].add(new Edge(v, w));
		}
		int dis[] = new int[n+1];
		boolean vis[] = new boolean[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[0] = 0;
		for(int k = 1; k <= n; k++) {
			int min = Integer.MAX_VALUE, id = -1;
			for(int i = 0; i <= n; i++) {
				if(!vis[i] && dis[i] < min) {min = dis[i]; id = i;}
			}
			if(id == -1) break;
			vis[id] = true;
			for(Edge e : adj[id]) {
				if(dis[e.v] > dis[id] + e.w) {
					dis[e.v] = dis[id] + e.w;
				}
			}
		}
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			if(dis[i] < t && fresh[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	static class Edge{
		int v, w;
		Edge(int v0, int w0){v = v0; w = w0;}
	}
}
