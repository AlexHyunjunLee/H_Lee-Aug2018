import java.util.Arrays;

/*This class prints out the arrays using various methods in order to perform a mini lab
 * @author Alex Lee
 * @versions November 13, 2018
 */

public class LotsOfCopies {
	public static void main(String[] args) {
		int num = 7;
		String strMain = "APCS";
		int[] arrMain = {1, 2, 3, 4, 5};
		changeMe(num, strMain, arrMain);
		System.out.println("Before");
		System.out.println("x: " + num);
		System.out.println("strMain: " + strMain);
		System.out.println("arrMain: " + Arrays.toString(arrMain));
		System.out.println("After");
		System.out.println("x: " + num);
		System.out.println("strMain: " + strMain);
		System.out.println("arrMain: " + Arrays.toString(arrMain));
		part2WithInts();
		part2WithStrings();
		part2WithArrays();
	}
	public static void changeMe(int x, String str, int[] arr) {
		x = 229886;
		str += str;
		arr[4] = 100;
	}
	public static void part2WithInts() {
		int a = 7;// a = startValue
		int b = a;// b = a
		a = 1;// a = newValue
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
	public static void part2WithStrings() {
		String a = "Hi";// a = startValue
		String b = a;// b = a
		a = "Bye";// a = newValue
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
	public static void part2WithArrays() {
		int[] a = {0, 1, 2};// a = startValue
		int[] b = a;// b = a
		for (int i=0;i<a.length;i++) {
			a[i] = i+1;// a = newValue
		}
		System.out.println("a: " + Arrays.toString(a));
		System.out.println("b: " + Arrays.toString(b));
	}
}
