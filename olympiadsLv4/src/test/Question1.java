package test;
import java.util.*;
public class Question1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		Map<Character, Character> map1 = new HashMap<>();
		Map<Character, Character> map2 = new HashMap<>();
		boolean flag = true;
		for(int i = 0; i < a.length(); i++) {
			if(map1.containsKey(a.charAt(i)) && map1.get(a.charAt(i)) != b.charAt(i)) {
				flag = false;
				break;
			}
			else {
				map1.put(a.charAt(i), b.charAt(i));
			}
			if(map2.containsKey(b.charAt(i)) && map2.get(b.charAt(i)) != a.charAt(i)) {
				flag = false;
				break;
			}
			else {
				map2.put(b.charAt(i), a.charAt(i));
			}
		}
		if(flag) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	}
}
