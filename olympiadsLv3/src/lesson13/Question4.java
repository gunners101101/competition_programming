package lesson13;
import java.util.*;
public class Question4 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer> list[] = new ArrayList[n+1];
		for(int i = 0; i  <n+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < m; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[x].add(y);
			list[y].add(x);
		}
		int ans = 0;
		boolean[] vis = new boolean[n+1]; 
		int[] parent = new int[n+1];
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(1);
		vis[1] = true;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.println(cur);
			for(int nex : list[cur]) {
				if(!vis[nex]) {
					queue.add(nex);
					parent[nex] = cur;
					vis[nex] = true;
					System.out.println(queue);
				}
				else if(parent[nex] != cur){
					list[cur].remove((Integer)nex);
					list[nex].remove((Integer)cur);
					ans++;
				}
			}
		}
		System.out.println(ans);
		if(ans > 1) {
			System.out.println("NO");
		}
		else {
			System.out.println("YES");
		}
	}
}
