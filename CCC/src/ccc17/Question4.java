package ccc17;
import java.io.*;
import java.util.*;
public class Question4 {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer t;
	static int[] parent, rank;
	static ArrayList<String> active = new ArrayList<>();
	static ArrayList<Edge> allEdges = new ArrayList<>();
	static int change = 0;
	static int edgesUsed = 0;
	public static void main(String args[]) throws IOException{
		int n = readInt();
		int m = readInt();
		int d = readInt();
		parent = new int[n+1];
		rank = new int[n+1];
		for(int i = 0; i < n-1; i++) {
			int u = readInt();
			int v = readInt();
			long w = readLong();
			allEdges.add(new Edge(u, v, w, 0));
		}
		Map<String, Edge> edge_weights = new HashMap<>(); 
		for(int i = n-1; i < m; i++) {
			int u = readInt();
			int v = readInt();
			long w = readLong();
			String e1 = u + "_" + v;
			if (edge_weights.containsKey(e1) && edge_weights.get(e1).w > w) {
				edge_weights.get(e1).w = w;
			}
			else if (!edge_weights.containsKey(e1)) {
				Edge e = new Edge(u, v, w, 1);
				allEdges.add(e);
				edge_weights.put(e1, e);
			}
		}
		Collections.sort(allEdges);
		for(int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		for(Edge cur : allEdges) {
			if(union(cur.u, cur.v, cur.w) && cur.e == 1) {
				change++;
			}
			if(n-1 == edgesUsed) {
				break;
			}
		}
		System.out.println(change);
	}
	static int find(int x) { 
        if (parent[x] != x) { 
            parent[x] = find(parent[x]); 
        } 
        return parent[x]; 
    } 
	static boolean union(int x, int y, long w) { 
        int xRoot = find(x), yRoot = find(y); 
        if (xRoot == yRoot) {
            return false;
        }
        edgesUsed++;
        if (rank[xRoot] < rank[yRoot]) { 
            parent[xRoot] = yRoot; 
        }
        else if (rank[yRoot] < rank[xRoot]) { 
            parent[yRoot] = xRoot; 
        }
        else { 
            parent[yRoot] = xRoot; 
            rank[xRoot] = rank[xRoot] + 1; 
        } 
        return true;
    } 
	static class Edge implements Comparable<Edge>{
		int u, v, e;
		long w;
		Edge(int u0, int v0, long w0, int e0){ u = u0; v = v0; w = w0; e = e0;}
		public int compareTo(Edge x) {return Long.compare(w, x.w);}
	}
	static int readInt() throws IOException {
		while (t == null || !t.hasMoreTokens()) {
			t = new StringTokenizer(br.readLine().trim());
		}
		return Integer.parseInt(t.nextToken());
	}
	static long readLong() throws IOException {
		while (t == null || !t.hasMoreTokens()) {
			t = new StringTokenizer(br.readLine().trim());
		}
		return Long.parseLong(t.nextToken());
	}
}
