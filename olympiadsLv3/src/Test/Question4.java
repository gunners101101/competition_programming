package Test;
import java.util.*;
public class Question4 {
	static int[] parent, rank;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();
		parent = new int[n+1];
		rank = new int[n+1];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
		List<Edge> list = new ArrayList<>();
		List<Edge> list2 = new ArrayList<>();
		for(int i = 0 ; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			list.add(new Edge(x, y, c1));
			list2.add(new Edge(x, y, c2));
		}
		Collections.sort(list);
		Collections.sort(list2);
		Set<Integer> set = new HashSet<>();
		int max = 0;
		for(int i = 0; i <= n; i++) {
			set.add(list.get(i).u);
			set.add(list.get(i).v);
			if(set.size()-1 == i+1 && i<k) {
				System.out.println(list.get(i).c1);
				union(list.get(i).u, list.get(i).v);
				max = Math.max(max, list.get(i).c1);
			}
			else if(set.size()-1 == i+1){
				union(list2.get(i).u, list2.get(i).v);
				max = Math.max(max, list2.get(i).c1);
			}
			if(i==m) {
				break;
			}
		}
		System.out.println(max);
	}
	static int find(int x) { 
        if (parent[x] != x) { 
            parent[x] = find(parent[x]); 
        } 
        return parent[x]; 
    } 
	static void union(int x, int y) 
    { 
        int xRoot = find(x), yRoot = find(y); 
        if (xRoot == yRoot) 
            return; 
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
    } 
	static class Edge implements Comparable<Edge>{
		int u, v, c1;
		Edge(int u0,int v0, int c10){u =u0; v = v0; c1 = c10;}
		public int compareTo(Edge x) {return Integer.compare(c1, x.c1);}
	}
}
