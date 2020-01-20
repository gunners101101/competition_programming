package lesson14;
import java.util.*;
public class Question2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int max = sc.nextInt();
		int c = sc.nextInt();
		int[] carts = new int[c];
		int sum = 0;
		
		for(int i = 0; i < c; i++) {
			carts[i] = sc.nextInt();
			sum += carts[i];
			if(i > 3) {
				sum -= carts[i-4];
			}
			if(sum > max) {
				System.out.println(i);
				break;
			}
			else if(i == c-1) {
				System.out.println(i+1);
				break;
			}
		}
	}
}
