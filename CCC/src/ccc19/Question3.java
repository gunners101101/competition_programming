package ccc19;
import java.util.*;
public class Question3 {
	static int[] X_row = new int[3];
	static int[] X_col = new int[3];
	static int[][] grid = new int[3][3];
	static int numb_x = 0;
	static boolean xGrid[][] = new boolean[3][3];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				String cur = sc.next();
				if(cur.equals("X")) {
					numb_x++;
					xGrid[row][col] = true;
					X_row[row]++;
					X_col[col]++;
				}
				else {
					grid[row][col] = Integer.parseInt(cur);
				}
			}
		}
		while(numb_x > 0){
			if(solveSingleX()) {
				break;
			}
		}
		if(numb_x == 4) {
			if(X_col[1] == 0) {
				if(!xGrid[0][0]) {
					grid[1][0] = grid[1][1] - (grid[0][1] - grid[0][0]);
					X_col[0]--;
					X_row[1]--;
					xGrid[1][0] = false;
				}
				else if(!xGrid[1][0]) {
					grid[0][0] = grid[0][1] - (grid[1][1] - grid[1][0]);
					X_col[0]--;
					X_row[0]--;
					xGrid[0][0] = false;
				}
				else {
					grid[0][0] = grid[0][1] - (grid[2][1] - grid[2][0]);
					X_col[0]--;
					X_row[0]--;
					xGrid[0][0] = false;
				}
			}
			else if(X_col[0] == 0) {
				if(!xGrid[0][1]) {
					grid[1][1] = grid[1][0] + (grid[0][1] - grid[0][0]);
					X_col[1]--;
					X_row[1]--;
					xGrid[1][1] = false;
				}
				else if(!xGrid[1][1]) {
					grid[0][1] = grid[0][0] + (grid[1][1] - grid[1][0]);
					X_col[1]--;
					X_row[0]--;
					xGrid[0][1] = false;
				}
				else {
					grid[0][1] = grid[0][0] + grid[2][1] - grid[2][0];
					X_col[1]--;
					X_row[0]--;
					xGrid[0][1] = false;
				}
			}
			else {
				if(!xGrid[0][1]) {
					grid[1][1] = grid[1][2] - (grid[0][2] - grid[0][1]);
					X_col[1]--;
					X_row[1]--;
					xGrid[1][1] = false;
				}
				else if(!xGrid[1][1]) {
					grid[0][1] = grid[0][2] - (grid[1][2] - grid[1][1]);
					X_col[1]--;
					X_row[0]--;
					xGrid[0][1] = false;
				}
				else {
					grid[0][1] = grid[0][2] - (grid[2][2] - grid[2][1]);
					X_col[1]--;
					X_row[0]--;
					xGrid[0][1] = false;
				}
			}
			numb_x--;
			while(numb_x > 0){
				solveSingleX();
			}
		}
		else if(numb_x == 6) {
			if(!xGrid[1][0] && !xGrid[0][0] && !xGrid[2][0]) {
				grid[0][1] = grid[0][2] = grid[0][0]; 
				grid[1][1] = grid[1][2] = grid[1][0]; 
				grid[2][1] = grid[2][2] = grid[2][0]; 
				numb_x = 0;
				xGrid = new boolean[3][3];
				X_row = new int[3];
				X_col = new int[3];
			}
			else if(!xGrid[1][2] && !xGrid[0][2] && !xGrid[2][2]) {
				grid[0][1] = grid[0][0] = grid[0][2]; 
				grid[1][1] = grid[1][0] = grid[1][2]; 
				grid[2][1] = grid[2][0] = grid[2][2];
				numb_x = 0;
				xGrid = new boolean[3][3];
				X_row = new int[3];
				X_col = new int[3];
			}
			else if(!xGrid[1][1]) {
				if(!xGrid[1][0]) {
					grid[0][0] = grid[2][0] = grid[1][0];
					grid[0][1] = grid[2][1] = grid[1][1];
					grid[0][2] = grid[2][2] = grid[1][2];
					numb_x = 0;
					xGrid = new boolean[3][3];
					X_row = new int[3];
					X_col = new int[3];
				}
				else if(!xGrid[0][1]){
					grid[0][0] = grid[0][2] = grid[0][1];
					grid[1][0] = grid[1][2] = grid[1][1];
					grid[2][0] = grid[2][2] = grid[2][1];
					numb_x = 0;
					xGrid = new boolean[3][3];
					X_row = new int[3];
					X_col = new int[3];
				}
				else if(!xGrid[0][0]) {
					grid[0][1] = grid[1][1];
					xGrid[0][1] = false;
					X_row[0]--;
					X_col[1]--;
					numb_x--;
				}
				else {
					grid[1][0] = grid[1][1];
					xGrid[1][0] = false;
					X_row[1]--;
					X_col[0]--;
					numb_x--;
				}
			}
			else if(!xGrid[0][1]){
				if(!xGrid[0][0]) {
					grid[1][0] = grid[2][0] = grid[0][0];
					grid[1][1] = grid[2][1] = grid[0][1];
					grid[1][2] = grid[2][2] = grid[0][2];
					numb_x = 0;
					xGrid = new boolean[3][3];
					X_row = new int[3];
					X_col = new int[3];
				}
				else {
					grid[1][1] = grid[0][1];
					xGrid[1][1] = false;
					X_row[1]--;
					X_col[1]--;
					numb_x--;
				}
			}
			else{
				if(!xGrid[2][0]) {
					grid[1][0] = grid[0][0] = grid[2][0];
					grid[1][1] = grid[0][1] = grid[2][1];
					grid[1][2] = grid[0][2] = grid[2][2];
					numb_x = 0;
					xGrid = new boolean[3][3];
					X_row = new int[3];
					X_col = new int[3];
				}
				else {
					grid[1][1] = grid[2][1];
					xGrid[1][1] = false;
					X_row[1]--;
					X_col[1]--;
					numb_x--;
				}
			}
			while(numb_x > 0){
				solveSingleX();
			}
		}
		else if(numb_x == 7) {
			for(int row = 0; row < 3; row++) {
				for(int col = 0; col < 3; col++) {
					if(!xGrid[row][col]) {
						for(int j = 0; j < 3; j++) {
							grid[row][j] = grid[row][col];
							xGrid[row][j] = false;
							X_row[row]--;
							X_col[j]--;
						}
						X_col[col]++;
						break;
					}
				}
			}
			numb_x = 3;
			while(numb_x > 0){
				solveSingleX();
			}
		}
		else if(numb_x == 8){
			boolean flag = false;
			for(int row = 0; row < 3; row++) {
				for(int col = 0; col < 3; col++) {
					if(!xGrid[row][col]) {
						flag = true;
						for(int i = 0; i < 3; i++) {
							for(int j = 0; j < 3; j++) {
								grid[i][j] = grid[row][col];
							}
						}
						break;
					}
				}
				if(flag) {
					break;
				}
			}
		}
		else if(numb_x == 9){
			grid = new int[3][3];
		}
		for(int i = 0; i < 3; i++) {
			System.out.println(grid[i][0] + " " + grid[i][1] + " " + grid[i][2]);
		}
//		
	}
	public static void getCol(int col) {
		if(xGrid[0][col]) {
			xGrid[0][col] = false;
			grid[0][col] = 2*grid[1][col] -grid[2][col];
			X_row[0]--;
			X_col[col]--;
		}
		else if(xGrid[1][col]) {
			xGrid[1][col] = false;
			grid[1][col] = (grid[0][col] + grid[2][col])/2;
			X_row[1]--;
			X_col[col]--;
		}
		else {
			xGrid[2][col] = false;
			grid[2][col] = 2*grid[1][col] - grid[0][col];
			X_row[2]--;
			X_col[col]--;
		}
	}
	public static void getRow(int row) {
		if(xGrid[row][0]) {
			xGrid[row][0] = false;
			grid[row][0] = 2*grid[row][1] - grid[row][2];
			X_row[row]--;
			X_col[0]--;
		}
		else if(xGrid[row][1]) {
			xGrid[row][1] = false;
			grid[row][1] = (grid[row][0] + grid[row][2])/2;
			X_row[row]--;
			X_col[1]--;
		}
		else {
			xGrid[row][2] = false;
			grid[row][2] = 2*grid[row][1] - grid[row][0];
			X_row[row]--;
			X_col[2]--;
		}
	}
	static boolean solveSingleX() {
		boolean flag = true;
		for(int cur = 0; cur < 3; cur++) {
			if(X_col[cur] == 1) {
				getCol(cur);
				flag = false;
				numb_x--;
			}
			if(X_row[cur] == 1) {
				flag = false;
				getRow(cur);
				numb_x--;
			}
		}
		return flag;
	}
}
