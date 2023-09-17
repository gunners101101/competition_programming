package ccc18;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Question5 {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer t;
	static Map<String, String> parent = new HashMap<>(); 
	static Map<String, Integer> rank = new HashMap<>(); 
	public static void main(String args[]) throws IOException {
		int planets = readInt();
		int cities = readInt();
		int local_edges = readInt();
		int planet_edges = readInt();
		long tw = 0;
		long best_case = 0;
		ArrayList<Edge> edges = new ArrayList<>();
		Map<String, Edge> edge_weights = new HashMap<>(); 
		for(int i = 0; i < local_edges; i++) {
			int c1 = readInt();
			int c2 = readInt();
			long w = readLong();
			tw += w*planets;
			if (c1 != c2) {
				for(int planet = 1; planet <= planets; planet++) {
					String e1 = planet + "_" + c1;
					String e2 = planet + "_" + c2;
					if (
							edge_weights.containsKey(e1 + "->" + e2) && edge_weights.get(e1 + "->" + e2).w > w || 
							edge_weights.containsKey(e2 + "->" + e1) && edge_weights.get(e2 + "->" + e1).w > w ) {
						if (e1.compareTo(e2) <= 0) {
							edge_weights.get(e1 + "->" + e2).w = w;
						}
						else {
							edge_weights.get(e2 + "->" + e1).w = w;
						}
					}
					else if (!edge_weights.containsKey(e1 + "->" + e2)) {
						if (e1.compareTo(e2) <= 0) {
							Edge e = new Edge(0, (e1), (e2), w);
							edges.add(e);
							edge_weights.put(e1 + "->" + e2, e);
						}
						else {
							Edge e = new Edge(0, (e1), (e2), w);
							edges.add(e);
							edge_weights.put(e2 + "->" + e1, e);	
						}
					}
				}
			}
		}
		for(int i = 0; i < planet_edges; i++) {
			int p1 = readInt();
			int p2 = readInt();
			long w = readLong();
			tw += w*cities;
			if (p1 != p2) {
				for(int city = 1; city <= cities; city++) {
					edges.add(new Edge(0, (p1 + "_" + city), (p2 + "_" + city), w));
				}
			}
		}
		Collections.sort(edges);
		//System.out.println(edges.get(1).w);
		for(int planet = 1; planet <=planets; planet++) {
			for(int city = 1; city <= cities; city++) {
				parent.put((planet+"_"+city), (planet+"_"+city));
				rank.put((planet+"_"+city), 0);
			}
		}
		int c = 0;
		for(Edge e : edges) {
			String p1 = find(e.u);
			String p2 = find(e.v);
			if(!p1.equals(p2)) {
				union(e.u, e.v);
				best_case += e.w;
				c++;
				if(planets*cities-1 == c) {
					break;
				}
			}
			
		}
		System.out.println(tw-best_case);
	}
	static class Edge implements Comparable<Edge>{
		int local_edges; 
		long w;
		String u, v;
		Edge(int p0, String u0, String v0, long w0){ local_edges = p0; u = u0; v = v0; w = w0;}
		public int compareTo(Edge x) {return Long.compare(w, x.w);}
	} 
	static String find(String x) { 
		//System.out.println(parent.get(x).u + " " + parent.get(x).v);
        if (parent.get(x) != x) { 
            parent.put(x, find(parent.get(x))); 
        } 
        return parent.get(x); 
    } 
	static void union(String x, String y) { 
        String xRoot = find(x), yRoot = find(y);
        if(rank.get(xRoot) > rank.get(yRoot)) {
        	parent.put(yRoot, xRoot); 
        }
        else if(rank.get(xRoot) < rank.get(yRoot)) {
        	parent.put(xRoot, yRoot); 
        }
        else {
        	parent.put(yRoot, xRoot); 
        	rank.put(xRoot, rank.get(xRoot)+1);
        }
    } 
	static int readInt() throws IOException {
		while (t == null || !t.hasMoreTokens()) {
			t = new StringTokenizer(br.readLine().trim());
		}
		return Integer.parseInt(t.nextToken());
	}
	static Long readLong() throws IOException {
		while (t == null || !t.hasMoreTokens()) {
			t = new StringTokenizer(br.readLine().trim());
		}
		return Long.parseLong(t.nextToken());
	}
}
