package lesson16;
import java.util.*;
public class J5 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list[] = new ArrayList[n+1];
		for(int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 1; i <= n; i++) {
			int x = sc.nextInt();
			for(int j = 0; j < x; j++) {
				list[i].add(sc.nextInt());
			}
		}
		boolean[] vis = new boolean[n+1]; 
		int[] dis = new int[n+1]; 
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(1);
		vis[1] = true;
		dis[1] = 1;
		int small = -1;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int nex : list[cur]) {
				if(!vis[nex]) {
					vis[nex] = true;
					dis[nex] = dis[cur] + 1;
					queue.add(nex);
					if(list[nex].size() == 0 && small == -1) {
						small = dis[nex];
					}
				}
			}
		}
		boolean flag = true;
		for(int i = 1; i < n+1; i++) {
			if(!vis[i]) {
				flag = false;
				break;
			}
		}
		if(flag) {
			System.out.println("Y");
			System.out.println(small);
		}
		else {
			System.out.println("N");
			System.out.println(small);
		}
	}
}
