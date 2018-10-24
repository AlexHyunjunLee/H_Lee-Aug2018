/*This class prints out the hourglass using symbols
 * @author Alex Lee
 * @versions October 19, 2018
 */
public class Hourglass {
	public static void main(String[] args) {
		printBase();
		printTopMiddle();
		printMiddle();
		printBottomMiddle();
		printBase();
	}
	public static void printBase() {
		System.out.print("|");
		for (int i=0;i<10;i++) {
			System.out.print("\"");
		}
		System.out.println("|");
	}
	public static void printMiddle() {
		System.out.println("     ||");
	}
	public static void printTopMiddle() {
		for (int i=4;i>=1;i--) {
			int j = 0;
			for (int h=i;h<=4;h++) {
				System.out.print(" ");
			}
			System.out.print("\\");
			while (j<i) {
				System.out.print("::");
				j++;
			}
			System.out.println("/");
		}
	}
	public static void printBottomMiddle() {
		for (int i=1;i<=4;i++) {
			int j = 0;
			for (int h=i;h<=4;h++) {
				System.out.print(" ");
			}
			System.out.print("/");
			while (j<i) {
				System.out.print("::");
				j++;
			}
			System.out.println("\\");
		}
	}
}














