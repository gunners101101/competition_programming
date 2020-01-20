package lesson16;
import java.util.*;
public class Question3 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int Routes = sc.nextInt();
		int q = sc.nextInt();
		Map<String, Integer> cityNumb = new HashMap<>();
		Map<Integer, String> cityName = new HashMap<>();
		ArrayList<Integer> list[] = new ArrayList[Routes*2];
		int nodes = 0;
		for(int i = 0; i < Routes*2; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < Routes; i++) {
			String city1 = sc.next();
			String city2 = sc.next();
			if(!cityNumb.containsKey(city1)) {
				cityNumb.put(city1, nodes);
				cityName.put(nodes, city1);
				nodes++;
			}
			if(!cityNumb.containsKey(city2)) {
				cityNumb.put(city2, nodes);
				cityName.put(nodes, city2);
				nodes++;
			}
			list[cityNumb.get(city1)].add(cityNumb.get(city2));
			list[cityNumb.get(city2)].add(cityNumb.get(city1));
		}
		for(int i = 0; i < q; i++) {
			String city1 = sc.next();
			String city2 = sc.next();
			boolean[] vis = new boolean[nodes]; 
			int[] parent = new int[nodes]; 
			LinkedList<Integer> queue = new LinkedList<>();
			queue.add(cityNumb.get(city1));
			vis[cityNumb.get(city1)] = true;
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				for(int nex : list[cur]) {
					if(!vis[nex]) {
						parent[nex] = cur;
						vis[nex] = true;
						queue.add(nex);
					}
				}
				if(vis[cityNumb.get(city2)]) {
					break;
				}
			}
			int distance = cityNumb.get(city2);
			String ans = "";
			while(!cityName.get(distance).equals(city1)) {
				ans += cityName.get(distance).charAt(0);
				distance = parent[distance];
			}
			ans += city1.charAt(0);
			for(int j = ans.length()-1; j >= 0; j--) {
				System.out.print(ans.charAt(j));
			}
			System.out.println();
		}
	}
}
