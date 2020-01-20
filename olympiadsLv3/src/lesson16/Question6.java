package lesson16;
import java.util.*;

import lesson16.Question4.edge;
public class Question6 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		boolean[] rooms = new boolean[10];
		int col = sc.nextInt();
		int row = sc.nextInt();
		int startX = 0, startY =0;
		int[][] school = new int[row][col];
		for(int i = 0; i < row; i++) {
			String s = sc.next();
			for(int j = 0; j < col; j++) {
				if(s.charAt(j) == '1') {
					startY = i;
					startX = j;
				}
				if(s.charAt(j) == '#') {
					school[i][j] = -1;
				}
				else {
					school[i][j] = s.charAt(j)-'0';
				}
			}
		}
		boolean[][] vis = new boolean[row][col]; 
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(startY);
		queue.add(startX);
		vis[startY][startX] = true;
		rooms[1] = true;
		int moveX[] = {1, -1, 0, 0};
		int moveY[] = {0, 0, 1, -1};
		while(!queue.isEmpty()) {
			int curY = queue.poll();
			int curX = queue.poll();
			for(int i = 0; i < 4; i++) {
				int newX = curX+moveX[i];
				int newY = curY+moveY[i];
				if(newY < row && newX < col && newY >= 0 && newX >= 0 && !vis[newY][newX] && school[newY][newX] != -1) {
					vis[newY][newX] = true;
					queue.add(newY);
					queue.add(newX);
					if(school[newY][newX] > 0) {
						if(school[newY][newX] != 31) {
							rooms[school[newY][newX]] = true;
						}
					}
				}
			}
		}
		for(int i = 1; i < 10; i++) {
			if(rooms[i]) {
				System.out.print(i + " ");
			}
		}
	}
}
