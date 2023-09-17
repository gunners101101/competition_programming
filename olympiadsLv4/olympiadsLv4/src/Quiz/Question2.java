package Quiz;
import java.util.*;
public class Question2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int s = sc.nextInt();
		Numbers[] value = new Numbers[s];
		for(int i = 0; i < s; i++) {
			value[i] = new Numbers(sc.nextInt());
		}
		Arrays.sort(value);
		int ans = 0;
		int v = 0;
		int cur = 0;
		for(int i = s-1; i >= 0; i--) {
			if(v + Math.abs(cur-value[i].p) <= t) {
				v += Math.abs(cur-value[i].p);
				cur = value[i].p;
				ans++;
			}
			else {
				System.out.println(ans);
				break;
			}
		}
	}
	static class Numbers implements Comparable<Numbers>{
		int p;
		Numbers(int p0){p = p0;}
		public int compareTo(Numbers a)  { 
	        return Integer.compare(Math.abs(a.p), Math.abs(p)); 
	    } 
	}
}
