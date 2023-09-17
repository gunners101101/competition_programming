package ccc19;
import java.util.*;
public class Question1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int[][] grid = {{1, 2}, {3, 4}};
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'H') {
				int swap = grid[0][0];
				grid[0][0] = grid[1][0];
				grid[1][0] = swap;
				
				swap = grid[0][1];
				grid[0][1] = grid[1][1];
				grid[1][1] = swap;
			}
			else {
				int swap = grid[0][0];
				grid[0][0] = grid[0][1];
				grid[0][1] = swap;
				
				swap = grid[1][1];
				grid[1][1] = grid[1][0];
				grid[1][0] = swap;
			}
		}
		for(int i = 0; i < 2; i++) {
			System.out.println(grid[i][0] + " " + grid[i][1]);
		}
	}
}
