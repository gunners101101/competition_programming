package ccc16;
import java.util.*;
public class Question1 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		String phrase1 = sc.nextLine();
		String phrase2 = sc.nextLine();
		int aster = 0;
		boolean check = true;

		for(int i = 0; i < phrase2.length(); i++) {
			if(phrase2.charAt(i) == '*') {
				aster++;
			}
		}
		for(int i = 0; i < phrase1.length(); i++) {
			if(phrase2.indexOf(phrase1.charAt(i)) > -1) {
				phrase2 = phrase2.substring(0, phrase2.indexOf(phrase1.charAt(i))) + phrase2.substring(phrase2.indexOf(phrase1.charAt(i))+1);
			}
			else if(aster < 1){
				check = false;
			}
			else {
				aster--;
			}
		}
		if(check) {
			System.out.println("A");
		}
		else {
			System.out.println("N");
		}

    }
}
