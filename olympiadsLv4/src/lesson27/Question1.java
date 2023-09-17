package lesson27;
import java.util.*;
public class Question1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] val = new int[n+1]; 
		int[] dp = new int[n+1];
		for(int i = 1; i <= n; i++) {
			val[i] = sc.nextInt();
		}
		
		dp[1] = val[1];
		dp[2] = (int)(val[1] + val[2] - 0.25*Math.min(val[1], val[2]));
		
		for(int i = 3; i <= n; i++) {
			int min = val[i]+dp[i-1];
			min = Math.min(min, (int)(val[i] + val[i-1] - 0.25*Math.min(val[i], val[i-1]) + dp[i-2]));
			min = Math.min(min, (int)(val[i] + val[i-1] + val[i-2] - 0.5*Math.min(Math.min(val[i], val[i-1]),  val[i-2]) + dp[i-3]));
			//System.out.println(min);
			dp[i] = min;
		}
		System.out.println(dp[n]);
	}
}
