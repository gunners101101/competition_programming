package test;
import java.util.*;
public class Question2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String pat = sc.nextLine();
		int p = 0;
		int t = 0;
		int h = 1;
		int ans = 0;
		for(int i = 0; i < pat.length()-1; i++) {
			h = (h*52)%31;
		}
		for (int i = 0; i < pat.length(); i++)  { 
            p = (52*p + pat.charAt(i))%31; 
            t = (52*t + s.charAt(i))%31; 
        } 
		for (int i = 0; i <= s.length() - pat.length(); i++) { 
            if ( p == t ) { 
            	int c = 0;
                for (int j = 0; j < pat.length(); j++) { 
                    if (s.charAt(i+j) != pat.charAt(j)) { 
                        break; 
                    }
                    c++;
                } 
                if (c == pat.length()) {
                   ans++;
                }
            } 
            if ( i < s.length()-pat.length()) { 
                t = (52*(t - s.charAt(i)*h) + s.charAt(i+pat.length()))%31; 
                if (t < 0) { 
                	t = (t + 31);
                }
            } 
        }
		System.out.println(ans);
	}
}
