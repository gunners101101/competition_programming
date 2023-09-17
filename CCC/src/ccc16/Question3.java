package ccc16;
import java.io.*;
import java.util.*;
public class Question3 {
	static ArrayList<Integer> edge[];
	static int id = 0;
	static int dis[];
	static boolean vis[];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer t;
	public static void main(String args[]) throws IOException{
	//	Scanner sc = new Scanner(System.in);
		int n = readInt();
		int m = readInt();
		ArrayList<Integer> pho = new ArrayList<>();
		for(int i = 0; i < m; i++) {
			pho.add(readInt());
		}
		edge = new ArrayList[n];
		ArrayList<Integer> list = new ArrayList(); 
		for(int i = 0; i < n; i++) {
			list.add(i);
			edge[i] = new ArrayList<>();
		}
		int[] top = new int[n];
		for(int i = 0; i < n-1; i++) {
			int x = readInt();
			int y = readInt();
			edge[x].add(y);
			edge[y].add(x);
			top[x]++;
			top[y]++;
		}
		int edges = n-1;
		for(int j = 0; j <n-1; j++) {
			boolean flag = true;
			for(int i = 0; i < n; i++) {
				int ind = i;
				if(top[ind] == 1 && !pho.contains(ind)) {
					flag = false;
					edge[edge[ind].get(0)].remove((Integer) ind);
					top[edge[ind].get(0)]--;
					top[ind]--;
					edge[ind].remove(0);
					edges--;
				}
			}
			if(flag) {
				break;
			}
		}
//		for(int i = 0; i < n; i++) {
//			System.out.println(edge[i]);
//		}
		dis = new int[n];
		vis = new boolean[n];
		DFS(pho.get(0));
		dis = new int[n];
		vis = new boolean[n];
		DFS(id);
		int ans = dis[id] + (edges-dis[id])*2;
		System.out.println(ans);
	}
	
	static void DFS(int v){
		vis[v] = true;
    	for(int e : edge[v]){
    		if (!vis[e]) {
    			dis[e] = dis[v]+1;
    			if(dis[e] > dis[id]) {
    				id = e;
    			}
    			DFS(e);
    		}
    	}
	}
	static int readInt() throws IOException {
		while (t == null || !t.hasMoreTokens()) {
			t = new StringTokenizer(br.readLine().trim());
		}
		return Integer.parseInt(t.nextToken());
	}
}
