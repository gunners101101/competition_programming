package lesson1;
import java.util.*;
public class countingSubsequence {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int t = sc.nextInt();
			int[] numb = new int[t+1];
			int[] psa = new int[t+1];
			for(int j = 1; j < t; j++) {
				numb[j] = sc.nextInt();
				psa[j] = psa[j-1] + numb[j];
				
			}
			
		}
	}
}
