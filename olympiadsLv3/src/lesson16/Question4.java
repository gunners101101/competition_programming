package lesson16;
import java.util.*;
public class Question4 {
	static ArrayList<edge> list[];
	static int[] nodeCherries;
	static int ans = 0, MaxWeight, cherries;
	static Set<Integer> set  = new HashSet<>();
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int patches = sc.nextInt();
		cherries = sc.nextInt();
		MaxWeight = sc.nextInt();
		nodeCherries = new int[patches+1];
		for(int i = 1; i < patches+1; i++) {
			nodeCherries[i] = sc.nextInt();
		}
		list = new ArrayList[patches+1];
		for(int i = 0; i < patches+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < patches-1; i++) {
			list[sc.nextInt()].add(new edge(sc.nextInt(), sc.nextInt()));
		}
		BFS(patches, 1);
		System.out.println(ans);
	}
	public static void BFS(int nodes, int start) {
		boolean[] vis = new boolean[nodes+1]; 
		int[] parent = new int[nodes+1];
		int[] weight = new int[nodes+1];
		int[] total = new int[nodes+1];
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(start);
		vis[start] = true;
		//System.out.println(weight);
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(edge nex : list[cur]) {
				if(!vis[nex.u]) {
					vis[nex.u] = true;
					queue.add(nex.u);
					parent[nex.u] = cur;
					weight[nex.u] = nex.w;
					total[nex.u] = nodeCherries[nex.u];
				}
			}
		}
		for(int i = nodes; i > 1; i--) {
			weight[parent[i]] += weight[i];
			total[parent[i]] += total[i];
		}
		for(int i = 2; i <= nodes; i++) {
			if(weight[i] <= MaxWeight && total[i] >= cherries) {
				ans++;
			}
		}
	}
	static class edge{
		int u, w;
		edge(int u0, int w0){ u = u0; w = w0;}
	}
}
