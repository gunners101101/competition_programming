package ccc17;
import java.util.*;
public class Question5 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int stations = sc.nextInt();
		int subwayLines = sc.nextInt();
		int number_ofActions = sc.nextInt();
		int[] nexDest = new int[stations];
		int[] prevDest = new int[subwayLines+1];
		int[] numb_people = new int[stations];
		Arrays.fill(prevDest, -1);
		for(int i = 0; i < stations; i++) {
			int line = sc.nextInt();
			if(prevDest[line] > -1) {
				nexDest[prevDest[line]] = i;
			}
			prevDest[line] = i;
		}
		for(int i = 1; i <= subwayLines; i++) {
			nexDest[prevDest[i]] = 0;
		}
		for(int i = 0; i < stations; i++) {
		//	station
		}
		
	}
}
