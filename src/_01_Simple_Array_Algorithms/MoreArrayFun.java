package _01_Simple_Array_Algorithms;

import java.util.Random;

public class MoreArrayFun {
	// 1. Create a main method to test the other methods you write.

	public static void main(String[] args) {
		// String[] array = { "Pongo", "Perdita", "Lucky", "Penny", "Patch" };
		// testArray(array);

		// String[] arr = { "Dispy", "Laa-laa","Po", "Tinky-winky"};
		// testReverse(arr);

		// String[] arrays = { "You are", "ugly", "cool", "and gross!", "and so
		// awesome!" };
		// testOdds(arrays);

		String[] a = { "I am", "very", "cool beans", "and", "funny", "too" };
		testArray(a);
	}

	// 2. Write a method that takes an array of Strings and prints all the Strings
	// in the array.

	public static void testArray(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	// 3. Write a method that takes an array of Strings and prints all the Strings
	// in the array
	// in reverse order.
	public static void testReverse(String[] arr) {
		for (int i = 3; i < arr.length; i--) {
			System.out.println(arr[i]);
		}
	}

	// 4. Write a method that takes an array of Strings and prints every other
	// String in the array.
	public static void testOdds(String[] arrays) {
		for (int i = 0; i < arrays.length; i++, i++) {
			System.out.println(arrays[i]);
		}
	}

	// 5. Write a method that takes an array of Strings and prints all the Strings
	// in the array
	// in a completely random order. Almost every run of the program should result
	// in a different order.
	static void testRandom(String[] a) {
		String[] array2 = new String[a.length];
		int Counter = 0;
		Random ran = new Random();
		while (Counter < a.length) {
			String Aname = a[ran.nextInt(a.length)];
			boolean Found = false;
			for (int i = 0; i < Counter; i++) {
				if (Aname.equals(array2[i])) {
					Found = true;
					break;
				}
			}
			if (Found == false) {
				System.out.println(Aname);
				array2[Counter] = Aname;
				Counter = Counter + 1;
			}
		}

	}
}
