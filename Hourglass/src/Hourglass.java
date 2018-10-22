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
		printBottomMiddle2();
	}
	public static void printBase() {
		System.out.print("|");
		for (int i=0;i<10;i++) {
			System.out.print("\"");
		}
		System.out.println("|");
	}
	public static void printTopMiddle() {
		System.out.print(" \\");
		for (int i=0;i<8;i++) {
			System.out.print(":");
		}
		System.out.println("/");
		System.out.print("  \\");
		for (int i=0;i<6;i++) {
			System.out.print(":");
		}
		System.out.println("/");
		System.out.print("   \\");
		for (int i=0;i<4;i++) {
			System.out.print(":");
		}
		System.out.println("/");
		System.out.print("    \\");
		for (int i=0;i<2;i++) {
			System.out.print(":");
		}
		System.out.println("/");
	}
	public static void printMiddle() {
		System.out.println("     ||");
	}
	public static void printBottomMiddle() {
		System.out.print("    /");
		for (int i=0;i<2;i++) {
			System.out.print(":");
		}
		System.out.println("\\");
		System.out.print("   /");
		for (int i=0;i<4;i++) {
			System.out.print(":");
		}
		System.out.println("\\");
		System.out.print("  /");
		for (int i=0;i<6;i++) {
			System.out.print(":");
		}
		System.out.println("\\");
		System.out.print(" /");
		for (int i=0;i<8;i++) {
			System.out.print(":");
		}
		System.out.println("\\");
	}
	public static void printBottomMiddle2() {
		for (int i=2;i<=8;i+=2) {
			int j = 0;
			int h = i+1;
			while (h>i) {
				System.out.print("");
				h--;
			}
			System.out.print("/");
			while (j<i) {
				System.out.print(":");
				j++;
			}
			System.out.println("\\");
		}
	}
}
















