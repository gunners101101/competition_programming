package lesson14;
import java.util.*;

public class Question1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String maxName = "";
		int max = 0;
		String maxName2 = "";
		int max2 = 0;
		int n = sc.nextInt()-1;
		if(n > -1) {
			maxName = sc.next();
			max = 2*sc.nextInt() + 3*sc.nextInt() + sc.nextInt();
			for(int i = 0; i < n; i++) {
				String name = sc.next();
				int total = 2*sc.nextInt() + 3*sc.nextInt() + sc.nextInt();
				if(total > max || (total == max && maxName.compareTo(name) > 0)) {
					maxName2 = maxName;
					max2 = max;
					maxName = name;
					max = total;
				}
				else if(total > max2 || (total == max2 && maxName2.compareTo(name) > 0)) {
					maxName2 = name;
					max2 = total;
				}
			}
		}
		if(n == 0) {
			System.out.println(maxName);
		}
		else {
			System.out.println(maxName);
			System.out.println(maxName2);
		}
	}
}
