package lesson15;
import java.util.*;
public class Question2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String s = sc.next();
		int[] freq = new int[26];
		long ans = fact(n);
		for(int i = 0; i < n; i++) {
			if(s.charAt(i) != '*') {
				freq[s.charAt(i)-97]++;
			}
		}
		long answer = 0;
		long fin = 0;
		if(k == 1) {
			for(int i = 0; i < 26; i++) {
				freq[i]++;
				fin = ans;
				for(int j = 0; j < 26; j++) {
					fin = fin/fact(freq[j]);
				}
				answer+= fin;
				freq[i]--;
			}
			System.out.println(answer);
		}
//		else if(k == 2 && n ==2) {
//			System.out.println(676);
//		}
		else if(k == 2) {
			ans /= 2;
			if(ans == 1) {
				System.out.println(676);
			}
			else {
				for(int p = 0; p < 26; p++) {
					freq[p]++;
					for(int i = 0; i < 26; i++) {
						freq[i]++;
						fin = ans;
						for(int j = 0; j < 26; j++) {
							fin = fin/fact(freq[j]);
						}
						if(fin ==3) {
							System.out.println(i);
						}
						if(fin == 0) {
							answer++;
						}
						else {
							answer+= fin;
						}
						freq[i]--;
					}
					freq[p]--;
				}
				System.out.println(answer);
			}
		}
		else {
			fin = ans;
			for(int j = 0; j < 26; j++) {
				fin = fin/fact(freq[j]);
			}
			System.out.println(fin);
		}
	}
	public static long fact(int n) {
		long sol = 1;
		for(int i = 1; i < n+1; i++) {
			sol*=i;
		}
		return sol;
	}
}
