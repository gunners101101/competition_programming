package lesson15;
import java.util.*;
public class Question1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String p1 = sc.nextLine();
		String p2 = sc.nextLine();
		int x = sc.nextInt();
		String pos = "";
		for(int i = 0; i  < 10; i+= 2) {
			if(p1.charAt(i) > 64 && p1.charAt(i+1) > 64 && p1.charAt(i) < 91 && p1.charAt(i+1) < 91) {
				pos+= p1.charAt(i);
			}
			else if(p2.charAt(i) > 64 && p2.charAt(i+1) > 64 && p2.charAt(i) < 91 && p2.charAt(i+1) < 91) {
				pos+= p2.charAt(i);
			}
			else if(p1.charAt(i) < p1.charAt(i+1) || p2.charAt(i) < p2.charAt(i+1) || p1.charAt(i) > p1.charAt(i+1) || p2.charAt(i) > p2.charAt(i+1)){
				pos += p1.charAt(i) + "" + p1.charAt(i+1);
			}
			else {
				pos+= p1.charAt(i);
			}
		}
		for(int i = 0; i < x; i++) {
			String s = sc.next();
			boolean flag = true;
			for(int j = 0; j < s.length(); j++) {
				if(!pos.contains(""+s.charAt(j))) {
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println("Possible baby.");
			}
			else {
				System.out.println("Not their baby!");
			}
		}
		
	}
}
