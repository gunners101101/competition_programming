package lesson15;
import java.util.*;
public class Test {
	public static void main(String args[]) {
		Set<String> set = new HashSet<>();
		char[] ans = new char[3];
		int[] index1 = {1, 2, 0};
		int[] index2 = {2, 0, 1};
		for(int t = 0; t < 3; t++) {
			ans = new char[3];
			ans[t] = 'b';
			for(int i = 0; i < 26; i++) {
				ans[index1[t]] = (char)(i+97);
				for(int j = 0; j < 26; j++) {
					ans[index2[t]] = (char)(j+97);
					System.out.println(ans[0]+ "" + ans[1]+ "" + ans[2]);
					set.add(ans[0] + "" + ans[1] + "" + ans[2]);
				}
			}
		}
		System.out.println(set.size());
	}
}
