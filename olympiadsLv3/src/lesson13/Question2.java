package lesson13;
import java.util.*;
public class Question2 {
	static int[] parent, rank;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		for(int t = 0; t < 5; t++) {
			HashMap<String, Integer> list = new HashMap<>();
			int n = sc.nextInt();
			parent = new int[n*2];
			rank = new int[n*2];
			int p = 0;
			for(int i = 0; i < n; i++) {
				String c = sc.next();
				String x = sc.next();
				String y = sc.next();
				if(!list.containsKey(x)) {
					list.put(x, p);
					parent[list.get(x)] = list.get(x);
					p++;
				}
				if(!list.containsKey(y)) {
					list.put(y, p);
					parent[list.get(y)] = list.get(y);
					p++;
				}
				if(c.equals("p")) {
					union(list.get(x), list.get(y));
				}
				else if(find(list.get(x)) ==  find(list.get(y))){
					System.out.println("connected");
				}
				else {
					System.out.println("not connected");
				}
			}
		}
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
}
