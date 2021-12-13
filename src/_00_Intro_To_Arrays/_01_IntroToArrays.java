package _00_Intro_To_Arrays;

import java.util.Random;

public class _01_IntroToArrays {
	public static void main(String[] args) {
		// 1. declare and Initialize an array 5 Strings
		String[] friends = new String[5];

		friends[0] = "Ashay";
		friends[1] = "Arshia";
		friends[2] = "Gavin";
		friends[3] = "Nikhil";
		friends[4] = "Mr. Dave";

		// 2. print the third element in the array
		// System.out.println(friends[2]);

		// 3. set the third element to a different value
		friends[2] = "GavinB";
		// 4. print the third element again
		// System.out.println(friends[2]);
		// 5. use a for loop to set all the elements in the array to a string
		// of your choice
		for (int i = 0; i < friends.length; i++) {
			String amigos = friends[i];
		}
		// 6. use a for loop to print all the values in the array
		// BE SURE TO USE THE ARRAY'S length VARIABLE
		for (int j = 0; j < friends.length; j++) {
			// System.out.println(friends[j]);
		}
		// 7. make an array of 50 integers
		int[] ints = new int[50];
		// 8. use a for loop to make every value of the integer array a random
		// number
		Random Randy = new Random();
		for (int i = 0; i < ints.length; i++) {

			ints[i] = Randy.nextInt(10000);
		}
		// 9. without printing the entire array, print only the smallest number
		// on the array
		int smallestnum = ints[0];
		for (int l = 0; l < ints.length; l++) {
			if (ints[l] < smallestnum) {
				smallestnum = ints[l];
			}

		}
		// System.out.println(smallestnum);
		// 10 print the entire array to see if step 8 was correct
		for (int c = 0; c < ints.length; c++) {
			// System.out.println(ints[c]);
		}
		// 11. print the largest number in the array.
		int largestnum = ints[0];
		for (int s = 0; s < ints.length; s++) {
			if (ints[s] > largestnum) {
				largestnum = ints[s];
			}

		}
	//	System.out.println(largestnum);
		for (int d = 0; d < ints.length; d++) {
		//	System.out.println(ints[d]);
		}
		// 12. print only the last element in the array
		System.out.println(ints[49]);
	}
}
