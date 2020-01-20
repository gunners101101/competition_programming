package lesson14;
import java.util.*;
public class Question3 {
	static int r,c;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0; i < r; i++) {
			String s = "";
			for(int j = 0; j < c; j++) {
				s += sc.nextInt() + "";
			}
			int size = list.size();
			list.add(s);
			for(int l = 0; l < size; l++) {
				String a = list.get(0);
				list.remove(0);
				list.add(compare(a, s));
			}
		}
		Set<String> set = new HashSet<>();
		for(int i = 0; i < list.size(); i++) {
			set.add(list.get(i));
		}
		System.out.println(set.size());
	}
	public static String compare(String s1, String s2) {
		String ans = "";
		for(int i = 0; i < c; i++) {
			if(s1.charAt(i) == s2.charAt(i)) {
				ans += "0";
			}
			else {
				ans += "1";
			}
		}
		return ans;
	}
	
}
