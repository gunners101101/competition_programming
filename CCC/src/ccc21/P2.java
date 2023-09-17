package ccc21;

import java.io.*;
import java.util.*;

public class P2 {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer t;
	public static void main(String args[]) throws Exception{
		int m = readInt();
		int n = readInt();
		int c = readInt();
		boolean[] rowcanvas = new boolean[m];
		Operation[] op = new Operation[c];
		int colgold = 0;
		int rowChanges = 0;
		for(int i = 0; i < c; i++) {
			op[i] = new Operation(readString(), readInt()-1);
			if(op[i].d.equals("R")) {
				rowChanges++;
			}
		}
		Arrays.sort(op);
		for(int i = 0; i < rowChanges; i++) {
				if(rowcanvas[op[i].n]) {
					rowcanvas[op[i].n] = false;
					colgold--;
				}
				else {
					rowcanvas[op[i].n] = true;
					colgold++;
				}
		}
		//System.out.println(colgold);
		int[] rowGold = new int[n];
		for(int i = 0; i < n; i++) {
			rowGold[i] = colgold;
		}
		
		for(int i = rowChanges; i < c; i++) {
			//System.out.println(op[i].d);
			rowGold[op[i].n] = m-rowGold[op[i].n];
		}
		int totalgold = 0;
		for(int i = 0; i < n; i++) {
			totalgold += rowGold[i];
		//	System.out.print(rowGold[i]);
		}
		System.out.println(totalgold);
	}
	static String readString() throws IOException {
		while (t == null || !t.hasMoreTokens()) {
			t = new StringTokenizer(br.readLine().trim());
		}
		return t.nextToken();
	}
	static int readInt() throws IOException {
		while (t == null || !t.hasMoreTokens()) {
			t = new StringTokenizer(br.readLine().trim());
		}
		return Integer.parseInt(t.nextToken());
	}
	static class Operation implements Comparable<Operation>{
		String d;
		int n;
		Operation(String d0, int n0){d = d0; n = n0;}
		public int compareTo(Operation x) {
			if(d.equals("R")) {
				return -1;
			}
			else if(x.d.equals("R")){
				return 1;
			}
			else {
				return 0;
			}
		}
	}
}
