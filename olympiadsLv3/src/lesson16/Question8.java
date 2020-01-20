package lesson16;
import java.util.*;
public class Question8 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int t = 0; t < cases; t++) {
			int rows = sc.nextInt();
			int cols = sc.nextInt();
			int pr = rows- sc.nextInt();
			int pc = cols- sc.nextInt();
			int kr = rows- sc.nextInt();
			int kc = cols - sc.nextInt();
			int[][] board = new int[rows][cols];
			for(int i = 0; i < rows; i++) {
				Arrays.fill(board[i], -1);
			}
			board[kr][kc] = 0;
			boolean kwin = false;
			boolean stalemate = false; 
			int staleMoves = -1;
			int moves = 0;
			ArrayList<Point> knightCords = new ArrayList<>();
			knightCords.add(new Point(kr, kc));
			pr--;
			moves++;
			for(Point p : knightCords) {
				board[p.r-2][p.c-1] = board[p.r][p.c]+1;
				board[p.r-2][p.c+1] = board[p.r][p.c]+1;
				board[p.r+2][p.c-1] = board[p.r][p.c]+1;
				board[p.r+2][p.c+1] = board[p.r][p.c]+1;
				board[p.r-1][p.c-2] = board[p.r][p.c]+1;
				board[p.r+1][p.c-2] = board[p.r][p.c]+1;
				board[p.r-1][p.c+2] = board[p.r][p.c]+1;
				board[p.r+1][p.c+2] = board[p.r][p.c]+1;
				if(board[pr][pc] == moves) {
					kwin = true;
					System.out.println(moves);
					break;
				}
				else if(board[pr-1][pc] == moves && staleMoves == -1){
					stalemate = true;
					staleMoves = moves;
				}
			}
			if(!kwin) {
				if(stalemate) {
					System.out.println(staleMoves);
				}
				else {
					System.out.println(moves);
				}
			}
		}
	}
	static class Point{
		int r,c;
		Point(int r0, int c0){r = r0; c = c0;}
	}
}
