import java.util.Arrays;

public class ArraysLab3 {
	public static void main(String[] args) {
		int[] a1 = {5, 10, 15, 20, 25, 30, 35, 40};
		int[] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		int[] sumArr = ArraysLab3.sum(a1, a2);
		int appendNum = 200;
		int[] appendArr = ArraysLab3.append(a1, appendNum);
		int removeIdx = 5;
		int[] removeArr = ArraysLab3.remove(a2, removeIdx);
		int sumOfEvens = ArraysLab3.sumEven(appendArr);
		ArraysLab3.rotateRight(a1);
		System.out.println(Arrays.toString(sumArr));
		System.out.println(Arrays.toString(appendArr));
		System.out.println(Arrays.toString(removeArr));
		System.out.println(sumOfEvens);
		System.out.println(Arrays.toString(a1));
	}
	
	public static int[] sum(int[] arr1, int[] arr2) {
		int[] newArray = new int[arr1.length];
		for (int i=0;i<newArray.length;i++) {
			newArray[i] = (arr1[i]+arr2[i]);
		}
		return newArray;
	}
	
	public static int[] append(int[] arr, int num) {
		int[] newArray = new int[arr.length+1];
		for (int i=0;i<newArray.length-1;i++) {
			newArray[i] = (arr[i]);
		}
		newArray[newArray.length-1] = num;
		return newArray;
	}
	
	public static int[] remove(int[] arr, int idx) {
		int[] newArray = new int[arr.length-1];
		for (int i=0;i<idx;i++) {
			newArray[i] = (arr[i]);
		}
		for (int i=idx;i<newArray.length;i++) {
			newArray[i] = (arr[i+1]);
		}	
		return newArray;
	}
	
	public static int sumEven(int[] arr) {
		int sumOfEvens = 0;
		for (int i=0;i<arr.length-1;i++) {
			if (arr[i]%2==0) {
				sumOfEvens += arr[i];
			}
		}
		return sumOfEvens;
	}
	
	public static void rotateRight(int[] arr) {
		int lastDigit = arr[0];
		for (int i=0;i<arr.length-1;i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length-1] = lastDigit;
	}
}
