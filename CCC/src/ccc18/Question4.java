package ccc18;
import java.util.*;
public class Question4 {
	static Map<Integer, Long> map = new HashMap<>();
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fun(n));
	}
	static long fun(int n) {
		if(n == 1) {
			return 1;
		}
		long sum = 0;
		for(int i = 2; i <= n/3; i++) {
			if(!map.containsKey(n/i)) {
				long s = fun(n/i);
				map.put(n/i, s);
				sum+= s;
			}
			else {
				sum += map.get(n/i);
			}
		}
		return sum;
	}
}
