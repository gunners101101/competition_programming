package ccc19;
import java.util.*;
public class Question2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int cur = sc.nextInt()*2;
			for(int j = 2; j < cur; j++) {
				if(checkPrime(j) && checkPrime(cur-j)) {
					System.out.println(j + " " + (cur-j));
					break;
				}
			}
		}
	}
	public static boolean checkPrime(int n) {
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
}	
