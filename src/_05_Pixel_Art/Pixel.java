package _05_Pixel_Art;

import java.awt.Color;

public class Pixel{
    public int x;
    public int y;
    public Color color;

    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
        color = Color.WHITE;
    }
    
    public String toString()
    {
    	return this.x + " " + this.y + " " +this.color.getRed() + " " + this.color.getGreen() + " " + this.color.getBlue() + "\n";
    }
}
