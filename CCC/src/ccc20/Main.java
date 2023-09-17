package ccc20;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer t;
	public static void main(String args[]) throws IOException{
		int n = Integer.parseInt(br.readLine());
		E[] time = new E[n];
		double max = 0;
		for(int i = 0; i < n; i++) {
			t = new StringTokenizer(br.readLine());
			time[i] = new E(Integer.parseInt(t.nextToken()), Integer.parseInt(t.nextToken()));
		}
		Arrays.sort(time);
		for(int j = 1; j < n; j++) {
			max = Math.max(max, Math.abs((time[j-1].dis - time[j].dis)*1.0/(time[j-1].time - time[j].time)));
		}
		System.out.println(max);
	}
	static class E implements Comparable<E>{
		int time, dis;
		E(int u0, int v0){time = u0; dis = v0;}
		public int compareTo(E x) {return Integer.compare(time, x.time);}
	}
}
//Q1
//static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//static StringTokenizer t;
//public static void main(String args[]) throws IOException{
//	int n = Integer.parseInt(br.readLine());
//	long[] time = new long[n];
//	long[] dis = new long[n];
//	double max = 0;
//	for(int i = 0; i < n; i++) {
//		t = new StringTokenizer(br.readLine());
//		time[i] = Integer.parseInt(t.nextToken());
//		dis[i] = Integer.parseInt(t.nextToken());
//		for(int j = 0; j < i; j ++) {
//			max = Math.max(max, Math.abs((dis[i] - dis[j])*1.0/(time[i] - time[j])));
//		}
//	}
////	for(int i = 0; i < n; i++) {
////		for(int j = i+1; j < n; j++) {
////			max = Math.max(max, Math.abs((time[i][1] - time[j][1])*1.0/(time[i][0] - time[j][0])));
////		}
////	}
//	System.out.println(max);
//}

//q2
//static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//static StringTokenizer t;
//public static void main(String args[]) throws IOException{
//	Scanner sc = new Scanner(System.in);
//	int n = Integer.parseInt(br.readLine());
//	int m = Integer.parseInt(br.readLine());
//	int[][] cells = new int[n+1][m+1];
//	for(int i = 1; i <= n; i++) {
//		t = new StringTokenizer(br.readLine());
//		int j = 1;
//		while(t.hasMoreTokens()) {
//			cells[i][j] = Integer.parseInt(t.nextToken());
//			j++;
//		}
//	}
//	Queue<Integer> q = new LinkedList<>();
//	q.add(1);
//	q.add(1);
//	boolean[][] vis = new boolean[n+1][m+1];
//	vis[1][1] = true;
//	while(!q.isEmpty()) {
//		int curR = q.poll();
//		int curC = q.poll();
//		for(int i = 1; i <= Math.sqrt(cells[curR][curC]); i++) {
//			int b = cells[curR][curC]/i;
//			if(cells[curR][curC]%i == 0) {
//				if(i <= n && b <= m && !vis[i][b]) {
//					if(i == n && b == m) {
//						System.out.println("yes");
//						return;
//					}
//					else {
//						vis[i][b] = true;
//						q.add(i);
//						q.add(b);
//					}
//				}
//				if(b <= n && i <= m && !vis[b][i]) {
//					if(b == n && i == m) {
//						System.out.println("yes");
//						return;
//					}
//					else {
//						vis[b][i] = true;
//						q.add(b);
//						q.add(i);
//					}
//				}
//			}
//		}
//	}
//	System.out.println("no");
//}

//q3
//public static void main(String args[]) {
//	Scanner sc = new Scanner(System.in);
//	String s = sc.nextLine();
//	String n = sc.nextLine();
//	int[] freq = new int[26];
//	for(int i = 0; i < s.length(); i++) {
//		freq[s.charAt(i)-'a']++;
//	}
//	int ans = 0;
//	Set<String> set = new HashSet<>();
//	for(int i = 0; i <= n.length()-s.length(); i++) {
//		int[] temp = freq.clone();
//		boolean flag = true;
//		String check = "";
//		for(int j = 0; j < s.length(); j++) {
//			if(temp[n.charAt(i+j)-'a'] > 0) {
//				check += n.charAt(i+j);
//				temp[n.charAt(i+j)-'a']--;
//			}
//			else {
//				if(freq[n.charAt(i+j)-'a'] == 0) {
//					i += n.length();
//				}
//				flag = false;
//				break;
//			}
//		}
//		if(flag) {
//			int size = set.size();
//			set.add(check);
//			if(set.size() > size) {
//				ans++;
//			}
//		}
//	}
//	System.out.println(ans);
//}
//q4
//static char[] s;
//public static void main(String args[]) {
//	Scanner sc = new Scanner(System.in);
//	s = sc.nextLine().toCharArray();
//}
//public int swaps(int numb, char[] s) {
//	for(int i = 0; i < s.length; i++) {
//		if(check(i)) {
//			continue;
//		}
//		else {
//			for(int j = 0; j < s.length; j++) {
//				if(j == i || check(j) || s[j] == s[i]) continue;
//				else {
//					swaps(numb+1, s);
//				}
//			}
//		}
//	}
//}
//public static boolean check(int i) {
//	int b = 0;
//	if(i-1 == -1) {
//		b = s.length-1;
//	}
//	else {
//		b = i-1;
//	}
//	int a = 0;
//	if(i+1 == s.length) {
//		a = 0;
//	}
//	else {
//		a = i+1;
//	}
//	if(s[i] == s[a] ||s[i] == s[b]) {
//		return true;
//	}
//	else {
//		return false;
//	}
//}