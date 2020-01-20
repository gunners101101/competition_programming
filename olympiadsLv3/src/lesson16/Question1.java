package lesson16;
import java.util.*;
public class Question1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			int open = 0;
			for(int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == '(') {
					open++;
				}
				else if(s.charAt(j) == ')'){
					open--;
				}
				else if(s.charAt(j) == '-') {
					open = -1;
				}
				else if(!Character.isDigit(s.charAt(j))) {
					open = -1;
				}
				if(open < 0) {
					break;
				}
			}
			if(open == 0) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
}
