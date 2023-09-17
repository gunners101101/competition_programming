package lesson26;
import java.util.*;
public class Question1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		double slope[] = new double[2];
		double b [] = new double[2];
		for(int i = 0; i < 2; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			slope[i] = ((y1-y2)*1.0)/(x1-x2);
			b[i] = y1 - slope[i] * x1;
		}
		if(slope[0] == slope[1] && b[0] == b[1]) {
			System.out.println("coincident");
		}
		else if(slope[0] == slope[1]) {
			System.out.println("parallel");
		}
		else {
			double x = Math.round(((b[1]-b[0])/(slope[0] - slope[1]))*1000000)/1000000;
			double y = 0;
			if(slope[1] == Double.NEGATIVE_INFINITY) {
				y = Math.round((slope[0]*x + b[0])*1000000)*1.0/1000000;
			}
			else {
				y = Math.round((slope[1]*x + b[1])*1000000)*1.0/1000000;
			}
			
			System.out.format("%.6f", x);
			System.out.print(" ");
			System.out.format("%.6f", y);
		}
	}
}