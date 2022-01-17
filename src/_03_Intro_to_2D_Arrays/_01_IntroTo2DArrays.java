package _03_Intro_to_2D_Arrays;

public class _01_IntroTo2DArrays {

	public static void main(String[] args) {
		// 1. declare a 2D array of integers with 3, 1D arrays that each hold
		// 3 integers
		int[][] MyFirst2dArray = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		// 2. use two for loops to set all the elements in the 2D array to
		// a different integer
		// BE SURE TO USE THE ARRAY'S length VARIABLE
		for (int i = 0; i < MyFirst2dArray.length; i++) {
			for (int j = 0; j < MyFirst2dArray[i].length; j++) {
				MyFirst2dArray[i][j] = 10;
			}
		}
		// 3. print the third element from the second 1D array (2DArray[1][2])
		System.out.println(MyFirst2dArray[1][2]);
		// 4. set the third element from the second 1D array to a different
		// value
		MyFirst2dArray[1][2] = 1;
		// 5. print the element again and verify the value has changed
		System.out.println(MyFirst2dArray[1][2]);
	}
}
