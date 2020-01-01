package ccc16;
import java.util.*;
public class Question2 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int t = sc.nextInt();
		int[] d = new int[t];
		int[] p = new int[t];
		int total = 0;
		for(int  i = 0; i < t; i++) {
			d[i] = sc.nextInt();
		}
		for(int  i = 0; i < t; i++) {
			p[i] = sc.nextInt();
		}
		if(x == 1) {
			Arrays.sort(d);
			Arrays.sort(p);
			for(int  i = 0; i < t; i++) {
				total += Math.max(d[i],p[i]);
			}
		}
		else {
			Arrays.sort(d);
			Arrays.sort(p);
			int y = 0;
			for(int  i = t-1; i >= 0; i--) {
				total += Math.max(d[y],p[i]);
				y++;
			}
		}
		System.out.println(total);
    }
}
