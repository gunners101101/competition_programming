//package ccc22;

//import java.io.*;
import java.util.*;
public class Main {
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static StringTokenizer t;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = sc.nextInt();
		int good = sc.nextInt() - n+1;
		int[] ans = new int[n];
		int c = 0;
		while(good > 0) {
			if(good == 1) {
				ans[c] = 1;
				good--;
				c++;
			}
			else if(c+1 < n) {
				ans[c] = 1;
				ans[c+1] = 2;
				good-=2;
				c += 2;
			}
			else if(c < n){
				ans[c] = 1;
				c++;
				good--;
			}
			else {
				break;
			}
		}
		if(c != n) {
			for(int i = c; i < n; i++) {
				ans[i] = 1;
			}
		}
		if(good == 0) {
			for(int i = 0; i < n; i++) {
				System.out.println(ans[i]);
			}
		}
		else {
			System.out.println(-1);
		}
		
	}
//	int x = sc.nextInt();
//	//Set<String> mustGroupSet = new HashSet<>();
//	List<String> mustGroupArray = new ArrayList<>();
//	String[][] mustGroup = new String[x][2];
//	for(int i = 0; i < x; i++) {
//		mustGroup[i][0] = sc.next();
//		mustGroup[i][1] = sc.next();
//		mustGroupArray.add(mustGroup[i][0] + " " + mustGroup[i][1]);
//		
//	}
//	int y = sc.nextInt();
//	//Set<String> notGroupSet = new HashSet<>();
//	List<String> notGroupArray = new ArrayList<>();
//	String[][] notGroup = new String[y][2];
//	for(int i = 0; i < y; i++) {
//		notGroup[i][0] = sc.next();
//		notGroup[i][1] = sc.next();
//		notGroupArray.add(notGroup[i][0] + " " +  notGroup[i][1]);
//	}
//	int g = sc.nextInt();
//	String[] groups;
//	int ans = 0;
//	sc.nextLine();
//	for(int i = 0; i < g; i++) {
//		groups = sc.nextLine().split(" ");
//		for(int v = 0; v < mustGroupArray.size(); v++) {
//			String[] var = mustGroupArray.get(v).split(" ");
//			//System.out.println(mustGroup[v][0] + " " + mustGroup[v][1]);
//			boolean flag1 = groups[0].equals(var[0]) || groups[1].equals(var[0]) || groups[2].equals(var[0]);
//			boolean flag2 = groups[0].equals(var[1]) || groups[1].equals(var[1]) || groups[2].equals(var[1]);
//			boolean flag3 = mustGroupArray.contains(var[0]+ " " + var[1]);
//			if((flag1 && !flag2 && flag3)){
//				ans++;
//				mustGroupArray.remove(var[0]+ " " + var[1]);
//				//System.out.println(ans);
//			}
//			else if((!flag1 && flag2 && flag3)) {
//				ans++;
//				mustGroupArray.remove(var[0]+ " " + var[1]);
//				//System.out.println(ans);
//			}
//		}
//		
//		for(int v = 0; v < notGroupArray.size(); v++) {
//			String[] var = notGroupArray.get(v).split(" ");
//			boolean flag1 = groups[0].equals(var[0]) || groups[1].equals(var[0]) || groups[2].equals(var[0]);
//			boolean flag2 = groups[0].equals(var[1]) || groups[1].equals(var[1]) || groups[2].equals(var[1]);;
//		//	boolean flag3 = notGroupSet.contains(notGroup[v][0]+ " " +  notGroup[v][1]);
//			if(flag1 && flag2){
//				ans++;
//			//	notGroupSet.remove(notGroup[v][0]+ " " + notGroup[v][1]);
//				//System.out.println(notGroup[v][0] + " " + notGroup[v][1]);
//			}
//		}
//	}
//	System.out.println(ans);
//	static int readInt() throws IOException {
//		while (t == null || !t.hasMoreTokens()) {
//			t = new StringTokenizer(br.readLine().trim());
//		}
//		return Integer.parseInt(t.nextToken());
//	}
	//Scanner sc = new Scanner(System.in);
//	int n = sc.nextInt();
//	int x;
//	int c = 0;
//	for(int i = 0;i <= n/4; i++) {
//		x = n- 4*i;
//		if(x%5 == 0) {
//			c++;
//		}
//	}
//	System.out.println(c);
}
