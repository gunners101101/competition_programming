package lesson15;
import java.util.*;

import lesson15.Question5.Edge;
public class Question4 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		double adj[][] = new double[n+1][n+1];
		int[][] speed = new int[n+1][n+1];
		int[][] distance = new int[n+1][n+1];
		for(int i = 1; i <= m; i++) {
			int u = sc.nextInt(), v = sc.nextInt();
			distance[u][v] = sc.nextInt();
			speed[u][v] = sc.nextInt();
			double w = distance[u][v]*1.0/speed[u][v]*60;
			adj[u][v] = w; adj[v][u] = w;
		}
		double dis[] = new double[n+1];
		boolean vis[] = new boolean[n+1];
		int parent[] = new int[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[1] = 0;
		parent[1] = 1;
		for(int k = 1; k <= n; k++) {
			double min = Double.MAX_VALUE;
			int id = -1;
			for(int i = 1; i <= n; i++) {
				if(!vis[i] && dis[i] < min) {min = dis[i]; id = i;}
			}
			if(id == -1) break;
			vis[id] = true;
			for(int nex = 1; nex < adj.length; nex++) {
				if(dis[nex] > dis[id] + adj[id][nex]) {
					parent[nex] = id;
					dis[nex] = dis[id] + adj[id][nex];
				}
			}
		}
		double fastest = dis[n];
		int d = 0;
		int cur = n;
		double t = 0;
		while(cur != 1) {
			t += (distance[parent[cur]][cur]/(speed[parent[cur]][cur] * 0.75))*60;
			cur = parent[cur];
			d++;
		}
		System.out.println(d);
		System.out.println((int)(t-fastest));
	}
}
