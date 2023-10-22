package _05_Pixel_Art;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JPanel;

public class GridPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private int windowWidth;
	private int windowHeight;
	private int pixelWidth;
	private int pixelHeight;
	private int rows;
	private int cols;

	// 1. Create a 2D array of pixels. Do not initialize it yet.
	Pixel pixels[][];
	private Color color;

	public GridPanel(int w, int h, int r, int c) {
		this.windowWidth = w;
		this.windowHeight = h;
		this.rows = r;
		this.cols = c;

		this.pixelWidth = windowWidth / cols;
		this.pixelHeight = windowHeight / rows;

		color = Color.BLACK;

		setPreferredSize(new Dimension(windowWidth, windowHeight));

		// 2. Initialize the pixel array using the rows and cols variables.
		pixels = new Pixel[r][c];
		// 3. Iterate through the array and initialize each element to a new pixel.
		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels[i].length; j++) {
				pixels[i][j] = new Pixel(i * pixelWidth, j * pixelHeight);
			}
		}

	}

	public int getWindowWidth() {
		return this.windowWidth;
	}

	public int getWindowHeight() {
		return this.windowHeight;
	}

	public int getRows() {
		return this.rows;
	}

	public int getCols() {
		return this.cols;
	}

	public void setColor(Color c) {
		color = c;
	}

	public void clickPixel(int mouseX, int mouseY) {
		// 5. Use the mouseX and mouseY variables to change the color
		// of the pixel that was clicked. *HINT* Use the pixel's dimensions.
		pixels[mouseX / pixelWidth][mouseY / pixelHeight].color = color;
	}

	@Override
	public void paintComponent(Graphics g) {
		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels[i].length; j++) {
				g.setColor(pixels[i][j].color);
				g.fillRect(pixels[i][j].x, pixels[i][j].y, pixelWidth, pixelHeight);
				g.setColor(color.BLACK);
				g.drawRect(pixels[i][j].x, pixels[i][j].y, pixelWidth, pixelHeight);
			}
		}
	}

	public void load() {
		// 4. Iterate through the array.
		// For every pixel in the list, fill in a rectangle using the pixel's color.
		// Then, use drawRect to add a grid pattern to your display.

		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_05_Pixel_Art/Pixels"));

			String line = br.readLine();
			windowWidth = Integer.parseInt(line);
			line = br.readLine();
			windowHeight = Integer.parseInt(line);
			line = br.readLine();
			cols = Integer.parseInt(line);
			line = br.readLine();
			rows = Integer.parseInt(line);
			pixels = new Pixel[rows][cols];

			for (int i = 0; i < pixels.length; i++) {
				for (int j = 0; j < pixels[i].length; j++) {
					pixels[i][j] = new Pixel(i * pixelWidth, j * pixelHeight);
					line = br.readLine();
					String[] values = line.split(" ");
					int X = Integer.parseInt(values[0]);
					int Y = Integer.parseInt(values[1]);
					int R = Integer.parseInt(values[2]);
					int G = Integer.parseInt(values[3]);
					int B = Integer.parseInt(values[4]);
					Color c = new Color(R, G, B);

					pixels[i][j].color = c;
				}
			}
			
		
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
