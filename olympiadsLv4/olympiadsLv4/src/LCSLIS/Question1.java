package LCSLIS;
import java.util.*;
public class Question1 {
	static int mod;
	public static void main(String argsp[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int b[] = new int[n];
		int max = 0;
		for(int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
			max = Math.max(max, b[i]);
		}
		int ans = 0;
		for(int i = 1; i <= max; i++) {
			int cnt = 0;
			for(int j = 1; j <= n; j++) {
				cnt+= b[j]/i;
			}
			if(cnt < k/2) {
				break;
			}
			else {
				ans = Math.max(ans, i*k/2);
				continue;
			}
			
		}
	}
}
