package ccc18;
import java.io.*;
import java.util.*;
public class Question3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer t;
	public static void main(String args[]) throws IOException {
		int n = readInt();
		int m = readInt();
		char[][] grid = new char[n][m];
		boolean[][] cGrid = new boolean[n][m];
		int startX = -1;
		int startY = -1;
		ArrayList<Integer> cameraX = new ArrayList<>();
		ArrayList<Integer> cameraY = new ArrayList<>();
		ArrayList<Integer> emptyX = new ArrayList<>();
		ArrayList<Integer> emptyY = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				if(s.charAt(j) == 'S') {
					startX = j;
					startY = i;
				}
				else if(s.charAt(j) == 'C') {
					cameraX.add(j);
					cameraY.add(i);
				}
				else if(s.charAt(j) == '.') {
					emptyX.add(j);
					emptyY.add(i);
				}
			}
			grid[i] = s.toCharArray();
		}
		for(int i = 0; i < cameraX.size(); i++) {
			int cX = cameraX.get(i);
			int cY = cameraY.get(i);
			while(cX >= 0 && grid[cY][cX] != 'W') {
				if(grid[cY][cX] != 'R' && grid[cY][cX] != 'L' && grid[cY][cX] != 'U' && grid[cY][cX] != 'D') {
					cGrid[cY][cX] = true;
				}
				cX--;
			}
			cX = cameraX.get(i);
			while(cX < m && grid[cY][cX] != 'W') {
				if(grid[cY][cX] != 'R' && grid[cY][cX] != 'L' && grid[cY][cX] != 'U' && grid[cY][cX] != 'D') {
					cGrid[cY][cX] = true;
				}
				cX++;
			}
			cX = cameraX.get(i);
			while(cY >= 0 && grid[cY][cX] != 'W') {
				if(grid[cY][cX] != 'R' && grid[cY][cX] != 'L' && grid[cY][cX] != 'U' && grid[cY][cX] != 'D') {
					cGrid[cY][cX] = true;
				}
				cY--;
			}
			cY = cameraY.get(i);
			while(cY < n && grid[cY][cX] != 'W') {
				if(grid[cY][cX] != 'R' && grid[cY][cX] != 'L' && grid[cY][cX] != 'U' && grid[cY][cX] != 'D') {
					cGrid[cY][cX] = true;
				}
				cY++;
			}
		}
		int moveX[] = {1, -1, 0, 0};
		int moveY[] = {0, 0, 1, -1};
		boolean[][] vis = new boolean[n][m]; 
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(startY);
		queue.add(startX);
		vis[startY][startX] = true;
		int[][] dis = new int[n][m];
		for(int i = 0; i < n; i++) {
			Arrays.fill(dis[i], -1);
		}
		dis[startY][startX] = 0;
		if(!cGrid[startY][startX]) {
			while(!queue.isEmpty()) {
				int curY = queue.poll();
				int curX = queue.poll();
				for(int i = 0; i<4; i++) {
					int newY = curY+moveY[i];
					int newX = curX+moveX[i];
					//System.out.println(newY + " " + newX + " " + grid[newY][newX]);
					while(grid[newY][newX] == 'R' || grid[newY][newX] == 'L' || grid[newY][newX] == 'U' || grid[newY][newX] == 'D') {
						if(vis[newY][newX]) {
							break;
						}
						vis[newY][newX] = true;
						if(grid[newY][newX] == 'R') {
							newX++;
						}
						else if(grid[newY][newX] == 'L') {
							newX--;
						}
						else if(grid[newY][newX] == 'U') {
							newY--;
						}
						else if(grid[newY][newX] == 'D') {
							newY++;
						}
						//vis[newY][newX] = true;
					}
					if(!cGrid[newY][newX] && !vis[newY][newX] && grid[newY][newX] != 'W') {
						vis[newY][newX] = true;
						dis[newY][newX] = dis[curY][curX] + 1;
						queue.add(newY);
						queue.add(newX);
					}
				}
			}
		}
		for(int i = 0; i< emptyX.size(); i++) {
			System.out.println(dis[emptyY.get(i)][emptyX.get(i)]);
		}
	}
	static int readInt() throws IOException {
		while (t == null || !t.hasMoreTokens()) {
			t = new StringTokenizer(br.readLine().trim());
		}
		return Integer.parseInt(t.nextToken());
	}
}
