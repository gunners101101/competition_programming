package lesson13;
import java.util.*;
public class Question3 {
	static int[] parent;
	static int score = 0;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		parent = new int[n+1];
		for(int i = 1; i <= n; i++) {
			parent[i] = i%k;
		}
		List<E> edge = new ArrayList<>();
		for(int i = 1; i < n; i++) {
			int w = sc.nextInt(); edge.add(new E(i, i+1, w));
		}
		Collections.sort(edge);; int cnt =0 , ans = 0;
		for(E e: edge) {
			int fu = find(e.u), fv = find(e.v);
			if(fu!=fv) {
				parent[fu] = fv;
				ans+= e.w;
			}
		}
		System.out.println(ans);
	}
	static int find(int x) { 
        if (parent[x] != x) { 
            parent[x] = find(parent[x]); 
        } 
        return parent[x]; 
    }
	static class E implements Comparable<E>{
		int u, v, w;
		E(int u0, int v0, int w0){u = u0; v = v0; w = w0;}
		public int compareTo(E x) {return Integer.compare(w, x.w);}
	}
}
