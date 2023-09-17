package lesson2;
import java.util.*;
public class Question6 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int a[] = new int[5003];
		int cnt[] = new int[2000006];
		long[][] psa = new long[5003][5003];
		for(int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}
		for(int i = n-1; i >= 1; i--) {
			for(int k = i+1; k <= n; k++) {
				int val = -(a[i]+a[k]) + 1000003;
				if(val >= 0 && val < 2000006) {
					psa[i][k] = cnt[val];
				}
				cnt[a[k] + 1000003]++;
			}
			for(int k = i+1; k <= n; k++) {
				cnt[a[k] + 1000003]--;
			}
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				psa[i][j] += psa[i-1][j] + psa[i][j-1] - psa[i-1][j-1];
			}
		}
		for(int i = 1; i <=q; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println(psa[y][y] - psa[x-1][y] - psa[y][x-1] + psa[x-1][x-1]);
		}
	}
}
