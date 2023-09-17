package trie;
import java.util.*;
public class Question1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int numbOfMeals = sc.nextInt();
		int[] mealPrices = new int[numbOfMeals];
		for(int i = 0; i < numbOfMeals; i++) {
			mealPrices[i] = sc.nextInt();
		}
		int menuPrice = sc.nextInt();
		int[] menuItems = new int[4];
		for(int i = 0; i < 4; i++) {
			menuItems[i] = sc.nextInt();
		}
		int items = sc.nextInt();
		int[] itemOnTray = new int[items];
		int[] freq = new int[4];
		int itemChecked = 0;
		for(int i = 0; i < items;i++) {
			itemOnTray[i] = sc.nextInt();
			for(int j = 0; j < 4; j++) {
				if(itemOnTray[i] == menuItems[j]) {
					freq[j]++;
					itemChecked++;
					break;
				}
			}
		}
		int min = freq[0];
		for(int i = 1; i < 4; i++) {
			min = Math.min(min, freq[i]);
		}
		int cost = min*menuPrice;
		
	}
}
