package ccc21;
import java.io.*;
import java.util.*;

import lesson16.Question4.edge;


public class Main {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer t;
	public static void main(String args[]) throws Exception{
		int n = readInt();
		int w = readInt();
		int d = readInt();
		List<Integer> adj[] = new ArrayList[n+1];
		List<Integer> trainAdj[];
		for(int i = 0; i < n+1; i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i = 0; i < w; i++) {
			adj[readInt()].add(readInt());
		}
		int[] stationOrder = new int[n];
		for(int i = 0; i < n; i++) {
			stationOrder[i] = readInt();
		}
		
		for(int t = 0; t < d; t++) {
			int trainPos = 0;
			trainAdj = new ArrayList[n+1];
			for(int i = 0; i < n+1; i++) {
				trainAdj[i] = new ArrayList<>();
			}
			int x = readInt();
			int y = readInt();
			int temp = stationOrder[x];
			stationOrder[x] = stationOrder[y];
			stationOrder[y] = temp;
			for(int i = 1; i < n; i++) {
				trainAdj[stationOrder[i-1]].add(stationOrder[i]);
			}
			
		}
	}
	public static void BFS(int nodes) {
		boolean[] vis = new boolean[nodes]; 
		int[] dis = new int[nodes];
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(0);
		vis[0] = true;
		//System.out.println(weight);
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(Integer nex : tempAdj[cur]) {
				if(!vis[nex]) {
					vis[nex] = true;
					queue.add(nex);
					dis[nex] = Math.min(dis[nex], dis[cur]+1);
				}
			}
		}
	}
	static int readInt() throws IOException {
		while (t == null || !t.hasMoreTokens()) {
			t = new StringTokenizer(br.readLine().trim());
		}
		return Integer.parseInt(t.nextToken());
	}
	
}
