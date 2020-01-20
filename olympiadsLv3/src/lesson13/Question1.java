package lesson13;
import java.util.*;
public class Question1 {
	static int[] parent, rank;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		parent = new int[n+1];
		rank = new int[n+1];
		for(int i = 0; i < n+1; i++) {
			parent[i] = i;
		}
		for(int i = 0;i < m; i++) {
			int k = sc.nextInt();
			int x = sc.nextInt();
			for(int j = 0; j < k-1; j++) {
				int y = sc.nextInt();
				union(x,y);
				x = y;
			}
			
		}
		int c = 0;
		String ans = "";
		for(int i = 1; i < n+1; i++) {
			if(find(1) == find(i)) {
				c++;
				ans += i + " ";
			}
		}
		System.out.println(c);
		System.out.println(ans);
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
