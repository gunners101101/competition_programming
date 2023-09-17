package ccc18;
import java.util.*;
public class Question2 {
	static int length;
    static int[][] data;
    static int[][] tempData;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		length = sc.nextInt();
		data = new int[length][length];
		tempData = new int[length][length];
    	int numb;
		for(int i = 0; i < length; i++) {
    		for(int j = 0; j < length; j++) {
    			numb = sc.nextInt();
    			data[i][j] = numb;
				tempData[i][j] = numb;
    		}
    	}
		while(true) {
    		boolean correctData = validate();
    		if(correctData) {
    			break;
    			}    			else {
				rotate();
    		}
    	}
    	printData();
    }
    public static void rotate() {
		int k = 0;
		for(int j = 0; j < length; j++) {
			int l = 0;
			for(int i = length - 1; i > -1; i--){
				tempData[k][l] = data[i][j];
				l++;
			}
			k++;
		}
		for(int i = 0; i < length; i++){
			for(int j = 0; j < length; j++) {
				data[i][j] = tempData[i][j];
			}
		}	
	}
	public static void printData() {
		for(int i = 0; i < length; i++){
			for(int j = 0; j < length; j++) {
				System.out.print(data[i][j] + "  ");
			}
			System.out.println();
		}
	}
	public static boolean validate() {

		for(int i = 0; i < length; i++){
			for(int j = 0; j < length-1; j++) {
				if(data[i][j] > data[i][j+1]) {
					return false;
				}
				if(data[j][i] > data[j+1][i]) {
					return false;
				}
			}
		}
		return true;
	}
}
