package Test;
import java.util.*;
public class Question1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
		long y = sc.nextLong();
		long z = sc.nextLong();
		long ans;
		if(x%z == 0) {
			ans = y/z - ((x/z)-1);	
		}
		else {
			ans = y/z - x/z;
		}
		System.out.println(ans);
	}
}
