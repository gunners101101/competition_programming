package lesson27;
import java.util.*;
public class Question2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int lines = sc.nextInt();
		int start = sc.nextInt();
		int end = sc.nextInt();
		int n = sc.nextInt();
		ArrayList<Integer> list[]  = new ArrayList[lines+1];
		for(int i = 0; i <= lines; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[x].add(y);
		}
		
		int[] dis = new int[n+1];
		boolean[] vis = new boolean[n+1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int i : list[cur]) {
				if(!vis[i]) {
					queue.add(i);
					vis[i] = true;
					dis[i] = dis[cur]+1;
				}
			}
		}
		System.out.println(dis[end]);
	}
}
