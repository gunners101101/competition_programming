package finalTest;
import java.util.*;
public class Question1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = 1500;
		for(int i = 0; i < 141; i++) {
			n -= sc.nextInt();
			System.out.println(n);
		}
	}
}
