package ccc17;
import java.util.*;
public class Question2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int[] tides = new int[m];
		for(int i = 0; i < m; i++) {
			tides[i] = sc.nextInt();
		}
		Arrays.sort(tides);
		int l = m/2;
		if(m%2 != 0) {
			l += 1;
		}
		for(int i = 0; i < l; i++) {
			System.out.print(tides[l-1-i] + " ");
			if(i+l < m) {
				System.out.print(tides[i+l] + " ");
			}
		}
	}
}
