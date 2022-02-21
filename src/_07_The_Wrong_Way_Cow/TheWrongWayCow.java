/*
 * https://www.codewars.com/kata/the-wrong-way-cow
 * 
 * Task
 * Given a field of cows find which one is the Wrong-Way Cow and return her
 * position.
 * 
 * Notes:
 * 
 * There are always at least 3 cows in a herd
 * There is only 1 Wrong-Way Cow!
 * Fields are rectangular
 * The cow position is zero-based [col,row] of her head (i.e. the letter c)
 * Examples
 * Ex1
 * 
 * cow.cow.cow.cow.cow
 * cow.cow.cow.cow.cow
 * cow.woc.cow.cow.cow
 * cow.cow.cow.cow.cow
 * Answer: [6,2]
 * 
 * Ex2
 * 
 * c..........
 * o...c......
 * w...o.c....
 * ....w.o....
 * ......w.cow
 * Answer: [8,4]
 * 
 * Notes
 * The test cases will NOT test any situations where there are "imaginary" cows,
 * so your solution does not need to worry about such things!
 * 
 * To explain - Yes, I recognize that there are certain configurations where an
 * "imaginary" cow may appear that in fact is just made of three other "real" cows.
 * 
 * In the following field you can see there are 4 real cows (3 are facing south and
 * 1 is facing north). There are also 2 imaginary cows (facing east and west).
 * 
 * ...w...
 * ..cow..
 * .woco..
 * .ow.c..
 * .c.....
*/

package _07_The_Wrong_Way_Cow;

public class TheWrongWayCow {

	public static int[] findWrongWayCow(final char[][] field) {
		// Fill in the code to return the [col, row] coordinate position of the
		// head (letter 'c') of the wrong way cow!
		int rightway = 0;
		int leftway = 0;
		int upway = 0;
		int downway = 0;
		int[] rightc = { 0, 0 };
		int[] leftc = { 0, 0 };
		int[] upc = { 0, 0 };
		int[] downc = { 0, 0 };
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j] == 'c') {
					if (field.length - 2 > i && field[i + 1][j] == 'o' && field[i + 2][j] == 'w') {
						rightway = rightway + 1;
						rightc[0] = j;
						rightc[1] = i;
					}
					if (i >= 2 && field[i - 1][j] == 'o' && field[i - 2][j] == 'w') {
						leftway = leftway + 1;
						leftc[0] = j;
						leftc[1] = i;
					}
					if (field[i].length - 2 > j && field[i][j + 1] == 'o' && field[i][j + 2] == 'w') {
						downway = downway + 1;
						downc[0] = j;
						downc[1] = i;
					}
					if (j >= 2 && field[i][j - 1] == 'o' && field[i][j - 2] == 'w') {
						upway = upway + 1;
						upc[0] = j;
						upc[1] = i;
					}
				}
			}
		}
		if (rightway == 1) {
			return rightc;
		} else if (leftway == 1) {
			return leftc;
		} else if (downway == 1) {
			return downc;
		} else {
			return upc;
		}

	}
}
