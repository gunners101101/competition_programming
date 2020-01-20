package Test;
import java.util.*;

public class Question3 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		long[] c = new long[n];
		for(int i = 0; i < n; i++) {
			c[i] = sc.nextInt();
		}
		for(int t = 0; t < q; t++) {
			int cur = sc.nextInt();
			int left = 0;
			int right = cur;
			for(int i = 0; i < cur-1; i++) {
				if(i+cur< n && (c[right] < c[i+cur] || c[right] == c[i+cur])) {
					right = i+cur;
				}
				if(c[left] < c[i]) {
					left = i;
				}	
			}
			
			System.out.println(left+1 + " " + (right + 1));
		}
	}
}
