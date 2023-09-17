package rewiewDP;
import java.util.*;
public class Question3 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int H = sc.nextInt();
		int[][] dp = new int[2][5002];
		for(int i = 0; i < n; i++) {
			int cur  = 1;
			int pre = 0;
			int g = sc.nextInt();
			int h = sc.nextInt();
			int q = sc.nextInt();
			int t = sc.nextInt();
			for(int j=h; j <=H; j++) {
				dp[cur][j] = dp[pre][j-h] + g;
			}
			for(int j=h+t; j <= H; j++) {
				dp[cur][j] = Math.max(dp[cur][j], dp[cur][j-t]+q);
			}
			for(int j = 1; j <= H; j++) {
				dp[cur][j] = Math.max(dp[cur][j], dp[pre][j]);
			}
			int temp = pre;
			pre = cur;
			cur = temp;
		}
		System.out.println();
	}
}
