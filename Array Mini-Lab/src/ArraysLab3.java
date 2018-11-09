
public class ArraysLab3 {
	public static void main(String[] args) {
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
	
	public static void rotateRight(int[] arr1, int[] arr2) {
		
	}
}
