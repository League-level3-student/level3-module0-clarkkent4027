package _05_Pixel_Art;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorSelectionPanel extends JPanel implements MouseListener, ChangeListener, ActionListener {
	private static final long serialVersionUID = 1L;

	public static final int MAX_COLOR = 256;

	private JSlider rSlider;
	private JSlider gSlider;
	private JSlider bSlider;
	private JButton button;

	private Color color;

	private int r = 0;
	private int g = 0;
	private int b = 0;

	private JLabel colorLabel;
	private BufferedImage colorImage;
	Pixel[][] pix;
	GridPanel G;

	public ColorSelectionPanel(GridPanel GP) {
		rSlider = new JSlider(JSlider.VERTICAL);
		gSlider = new JSlider(JSlider.VERTICAL);
		bSlider = new JSlider(JSlider.VERTICAL);
		button = new JButton("SAVE");

		rSlider.setMinimum(0);
		rSlider.setMaximum(MAX_COLOR - 1);
		rSlider.setValue(0);
		gSlider.setMinimum(0);
		gSlider.setMaximum(MAX_COLOR - 1);
		gSlider.setValue(0);
		bSlider.setMinimum(0);
		bSlider.setMaximum(MAX_COLOR - 1);
		bSlider.setValue(0);

		rSlider.addChangeListener(this);
		gSlider.addChangeListener(this);
		bSlider.addChangeListener(this);
		button.addActionListener(this);

		addMouseListener(this);
		this.pix = GP.pixels;
		this.G = GP;
		colorLabel = new JLabel();
		colorImage = new BufferedImage(MAX_COLOR, MAX_COLOR, BufferedImage.TYPE_INT_RGB);
		color = new Color(r, g, b);
		for (int i = 0; i < MAX_COLOR; i++) {
			for (int j = 0; j < MAX_COLOR; j++) {
				colorImage.setRGB(j, i, color.getRGB());
			}
		}

		colorLabel.setIcon(new ImageIcon(colorImage));
		add(colorLabel);

		add(new JLabel("red"));
		add(rSlider);
		add(new JLabel("green"));
		add(gSlider);
		add(new JLabel("blue"));
		add(bSlider);
		add(button);
	}

	public Color getSelectedColor() {
		return color;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider s = (JSlider) e.getSource();
		if (s == rSlider) {
			r = s.getValue();
		} else if (s == gSlider) {
			g = s.getValue();
		} else if (s == bSlider) {
			b = s.getValue();
		}

		color = new Color(r, g, b);

		for (int i = 0; i < MAX_COLOR; i++) {
			for (int j = 0; j < MAX_COLOR; j++) {
				colorImage.setRGB(j, i, color.getRGB());
			}
		}

		colorLabel.setIcon(new ImageIcon(colorImage));
		add(colorLabel);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == button) {

			try {
				FileWriter fw = new FileWriter("src/_05_Pixel_Art/Pixels");
				fw.write(G.getWindowWidth() );
				fw.write(G.getWindowHeight() );
				fw.write(G.getCols() );
				fw.write(G.getRows() );
				for (int i = 0; i < this.pix.length; i++) {
					for (int j = 0; j < this.pix[i].length; j++) {
						fw.write(this.pix[i][j].toString());
						System.out.println("\nX: "+ this.pix[i][j].x + "\nY: "+this.pix[i][j].y+ "\nRED: "+this.pix[i][j].color.getRed()+ "\nGREEN: "+this.pix[i][j].color.getGreen()+ "\nBLUE: "+this.pix[i][j].color.getBlue()+"\n");
					}
				}
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
