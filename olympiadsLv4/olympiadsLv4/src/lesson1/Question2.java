package lesson1;
import java.util.*;
public class Question2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int m = 1;
		int a = 1;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < t; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			if(a > 0) {
				a--;
			}
			else if(list.contains(s)) {
				list.remove(Integer.valueOf(s));
			}
			else {
				System.out.println(s + " " + e);
				m++;
			}
			list.add(e);
		}
		System.out.println(m);
	}
}
