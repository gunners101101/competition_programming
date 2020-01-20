package lesson13;
import java.util.*;
public class Question5 {
	static int N, M, D, day[]; static List<Integer> adj[];
	public static void main(String ags[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt(); D = sc.nextInt(); adj = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			int tar = sc.nextInt() , k = sc.nextInt();
			for(int j = 1; j <= k; j++) {
				adj[tar].add(sc.nextInt());
			}
		}
		day = new int[N+1]; Arrays.fill(day, (int)1e9);
		for(int i=1; i <= D; i++) {
			int x = sc.nextInt(); day[x] = Math.min(day[x], i);
		}
		int ans = dfs(1);
		System.out.println(ans > 0 ? -1: ans);
	}
	static int dfs(int u) {
		int latest = 0;
		for(int v : adj[u]) latest = Math.max(latest, dfs(v));
		if(latest == 0) {
			latest = day[u];
		}
		else {
			latest = Math.min(latest, day[u]);
		}
		return latest;
	}
}
