package lesson26;
import java.util.*;
public class QUESTION2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int ans = 0;
		
		while(b >= a) {
			b /= 2;
			System.out.println(b);
			ans+=b;
		}
		System.out.println(ans);
	}
}
