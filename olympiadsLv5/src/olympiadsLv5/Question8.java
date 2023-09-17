package olympiadsLv5;
import java.util.*;
public class Question8 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			if(i > 0) {
				if(a[i-1] > a[i]) {
					cnt++;
					if(cnt > 1) {
						System.out.println("NO");
					}
					int swap = a[i];
					a[i] = a[i-1];
					a[i-1] = swap;
				}
			}
		}
	}
}
