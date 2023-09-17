package ccc21;

import java.util.Scanner;

public class P1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] length = new int[n+1];
		for(int i = 0; i < n+1; i++) {
			length[i] = sc.nextInt();
		}
		int[] width = new int[n];
		for(int i = 0; i < n; i++) {
			width[i] = sc.nextInt();
		}
		double ans = 0;
		for(int i = 0; i < n; i++) {
			ans += Math.min(length[i], length[i+1])*width[i] + Math.abs(length[i]-length[i+1])*width[i]*1.0/2;
		}
		System.out.println(ans);
	}
}
