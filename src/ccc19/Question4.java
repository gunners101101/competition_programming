package ccc19;
import java.io.*;
import java.util.*;
public class Question4 {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer t;
	static int attractions = 0;
	static int max_toVisit = 0;
	static int[] score;
	static Map<String, Integer> map = new HashMap<>();
	public static void main(String args[]) throws IOException{
		//Scanner sc = new Scanner(System.in);
		attractions = readInt();
		max_toVisit = readInt();
		
		score = new int[attractions];
		for(int i = 0; i< attractions; i++) {
			score[i] = readInt();
		}
		System.out.println(sol((int)(Math.ceil((float)attractions/max_toVisit)), max_toVisit, 0, 0));
	}
	static int sol(int days_left, int current_not_included, int current_max, int index) {
//		System.out.println(days_left + " " + current_not_included + " " + current_max + " " + index);
		
		if (attractions - index > days_left * max_toVisit) {
			return Integer.MIN_VALUE;
		}
		if (days_left == 0) {
			if (index == attractions) {
				return 0;
			}
			else {
				return Integer.MIN_VALUE;
			}
		}
		if (current_not_included == 0) {
			if (index == attractions) {
				return current_max;
			}
			else {
				return Integer.MIN_VALUE;
			}
		}
		if (index > attractions - 1) {
			return 0;
		}
		
		int case_1 = -1;
		if (map.containsKey(days_left + "_" + (current_not_included-1)  + "_" + Math.max(current_max, score[index])  + "_" + (index+1))) {
			case_1 = map.get(days_left + "_" + (current_not_included-1)  + "_" + Math.max(current_max, score[index])  + "_" + (index+1));
		}
		else {
			case_1 = sol(days_left, current_not_included-1, Math.max(current_max, score[index]), index+1);
		}
		
		int case_2 = -1;
		if (map.containsKey((days_left - 1) + "_" + (max_toVisit - 1) + "_" + score[index] + "_" + (index+1))) {
			case_2 = current_max + map.get((days_left - 1) + "_" + (max_toVisit - 1) + "_" + score[index] + "_" + (index+1));
		}
		else {
			case_2 = current_max + sol(days_left - 1, max_toVisit - 1, score[index], index+1);
		}
//		System.out.println(case_1 + " " + case_2);
//		System.out.println("");
		
		map.put(days_left + "_" + current_not_included + "_" + current_max + "_" + index, Math.max(
				case_1,
				case_2
		));
		return Math.max(
				case_1,
				case_2
		);
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