package lesson25;
import java.util.*;
public class Question1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] list = new int[n];
		for(int i = 0; i < n; i++) {
			list[i] = sc.nextInt();
		}
		for(int i = 0; i < q; i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int max = list[l-1];
			for(int j = l; j < r; j++) {
				if(max < list[j]) {
					max = list[j];
				}
			}
			System.out.println(max);
		}
	}
}
