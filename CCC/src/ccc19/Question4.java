package ccc19;
import java.io.*;
import java.util.*;
public class Question4 {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer t;
	public static void main(String args[]) throws IOException{
		int MM = 1000003;
		int n = readInt();
		int k = readInt();
		int[] day = new int[MM], a  = new int[MM], pmx  = new int[MM], smx  = new int[MM];
		long[] dp = new long[MM];
		
		for(int i = 0; i <=n; i++) {
			a[i] = readInt();
			day[i] = (i+k-1)/k;
			if(day[i] != day[i-1]) {
				pmx[i] = a[i];
			}
			else {
				pmx[i] = Math.max(pmx[i-1], a[i]);
			}
		}
		for(int i = n; i >=1; i--) {
			if(day[i] != day[i+1]) {
				smx[i] = a[i];
			}
			else {
				smx[i] = Math.max(smx[i-1], a[i]);
			}
		}
	}
	static int readInt() throws IOException {
		while (t == null || !t.hasMoreTokens()) {
			t = new StringTokenizer(br.readLine().trim());
		}
		return Integer.parseInt(t.nextToken());
	}
}

//test(int days_left, int current_not_included, int current_max, int index)	
//
//return test(2, 3, 0, 0)
//
//return test(2, 2, 2, 1)
//
//include_res = test(2, 1, 5, 2)
//not_indluce = test(1, 3, 0, 2)
//
//return max(test(2, 1, 5, 2), 2 + test(1, 3, 0, 2))
//
//
//if day == 0 and index == max:
//	return current_max
//if day == 0 and index != max:
//	return -1