import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Game extends JPanel implements Runnable{
	private BufferedImage back;
//	private Sound p;
	
	public Game() {
		back=null;
		//p = new Sound();
		//p.playmusic("mario.wav");
		
	}
	
	
	public void run() {
		try {
			while(true) {
				Thread.currentThread().sleep(5);
				repaint();
			}
		}
		catch(Exception e) {}
	}
	
	public void paint (Graphics g)
	{
		Graphics2D twoDgraph = (Graphics2D)g;
	//take a snap shop of the current screen and same it as an image
	//that is the exact same width and height as the current screen
		if (back==null) {
			back =(BufferedImage) (createImage(getWidth(), getHeight()));
				}

	//create a graphics reference to the back ground image
	//we will draw all changes on the background image
		Graphics g2d = back.createGraphics();
		
		//this clears the old image, like an EtchASketch. If you see the old image when we learn motion, you deleted this line.
		g2d.clearRect(0, 0, getSize().width, getSize().height); 
		
		
		//START CODING GRAPHICS HERE
		
		
		//creates a new color
		Color mynewcolor = new Color(139,53,153);
		//sets the new color. Think of the computer picking up a pen
		g2d.setColor(mynewcolor);
		createHouse(g2d, 200, 200);
		createHouse(g2d, 450, 200);
		//sets a new font
		
		
		//This line tells the program to draw everything above. If you delete this, nothing will show up.
		twoDgraph.drawImage(back, 0, 0, null);
	}
	
	public void createHouse(Graphics g2d,int x, int y) {
		
		Polygon house = new Polygon();
		house.addPoint(x, y);
		house.addPoint(x+100, y+100);
		house.addPoint(x+100, y+200);
		house.addPoint(x-100, y+200);
		house.addPoint(x-100, y+100);
		
		g2d.fillPolygon(house);
	}
	
	
	}


