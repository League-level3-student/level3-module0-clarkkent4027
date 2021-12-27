package _00_Intro_To_Arrays;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class _02_RobotRace {
	// 1. make a main method
	public static void main(String[] args) {

		// 2. create an array of 5 robots.
		Robot[] racers = new Robot[4];
		{
			// 3. use a for loop to initialize the robots.
			for (int i = 0; i < racers.length; i++) {
				racers[i] = new Robot();
			}
			// 4. make each robot start at the bottom of the screen, side by side, facing up
			racers[0].moveTo(100, 550);
			racers[1].moveTo(250, 550);
			racers[2].moveTo(400, 550);
			racers[3].moveTo(550, 550);

			// 5. use another for loop to iterate through the array and make each robot move
			// a random amount less than 50.
			Random Randy = new Random();

			racers[0].setSpeed(10);
			racers[1].setSpeed(10);
			racers[2].setSpeed(10);
			racers[3].setSpeed(10);

			// 6. use a while loop to repeat step 5 until a robot has reached the top of the
			// screen.
			int winner = 0;
			boolean b = true;
			while (b == true) {
				for (int i = 0; i < racers.length; i++) {
					racers[i].move(Randy.nextInt(50));
					if (racers[i].getY() < 50) {
						b = false;
						winner = i;
						break;
					}
				}

			}
			// 7. declare that robot the winner and throw it a party!
			JOptionPane.showMessageDialog(null, "YAY!!! Bot " + winner + " won!!!");

			// 8. try different races with different amounts of robots.

			// 9. make the robots race around a circular track.

		}
	}
}
