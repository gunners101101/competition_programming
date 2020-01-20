package lesson16;
import java.io.*;
import java.util.*;
public class Question7 {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer t;
	static boolean vis[][];
	static char[][] city;
	static int cnt;
	static int visNodes = 0;
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int row = readToken();
		int col = readToken();
		city = new char[row][col];
		for(int i = 0; i < row; i++) {
			city[i] = br.readLine().toCharArray();
		}
		vis = new boolean[row][col];
		cnt = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(!vis[i][j]) {
					BFS(i, j, row, col);
				}
				if(visNodes == row*col) {
					break;
				}
			}
			if(visNodes == row*col) {
				break;
			}
		}
		System.out.println(cnt);
	}
	public static void BFS(int startY, int startX, int row, int col) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(startY);
		queue.add(startX);
		vis[startY][startX] = true;
		visNodes++;
		boolean[][] vis2 = new boolean[row][col];
		vis2[startY][startX] = true;
		while(!queue.isEmpty()) {
			int curY = queue.poll();
			int curX = queue.poll();
			if(city[curY][curX] == 'S' && !vis2[curY+1][curX]) {
				if(vis[curY+1][curX]) {
					return;
				}
				visNodes++;
				vis2[curY+1][curX] = true;
				vis[curY+1][curX] = true;
				queue.add(curY+1);
				queue.add(curX);
			}
			else if(city[curY][curX] == 'N' && !vis2[curY-1][curX]){
				if(vis[curY-1][curX]) {
					return;
				}
				visNodes++;
				vis2[curY-1][curX] = true;
				vis[curY-1][curX] = true;
				queue.add(curY-1);
				queue.add(curX);
			}
			else if(city[curY][curX] == 'E' && !vis2[curY][curX+1]){
				if(vis[curY][curX+1]) {
					return;
				}
				visNodes++;
				vis2[curY][curX+1] = true;
				vis[curY][curX+1] = true;
				queue.add(curY);
				queue.add(curX+1);
			}
			else if(city[curY][curX] == 'W' && !vis2[curY][curX-1]){
				if(vis[curY][curX-1]) {
					return;
				}
				visNodes++;
				vis2[curY][curX-1] = true;
				vis[curY][curX-1] = true;
				queue.add(curY);
				queue.add(curX-1);
			}
		}
		cnt++;
	}
	static int readToken() throws IOException {
		while (t == null || !t.hasMoreTokens()) {
			t = new StringTokenizer(br.readLine().trim());
		}
		return Integer.parseInt(t.nextToken());
	}
}
