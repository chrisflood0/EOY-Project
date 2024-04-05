/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Game extends JPanel implements Runnable, KeyListener{
	private BufferedImage back;
	private Sound p;
	private Sound l;
	private int key;
	private int gs;
	private int gds;
	private int zx;
	private int kx;
	private int gscore;
	private int gscorex;
	private int kscore;
	private int kscorex;
	private Box1 r1;//Blue Goalie
	private Box1 r2;//Red Ball
	private Box1 r3;//White Goal
	private Box1 r4;//Grass
	private Box1 r5;//zlatan
	
	public Game() {
		back=null;
		p = new Sound();
		l = new Sound();
		new Thread(this).start();
		this.addKeyListener(this);
		r1=new Box1("sony.png",250,260,50,50,0,0);
		r2=new Box1("ball.png",500,260,20,20,0,0);
		r3=new Box1("net.png",175,85,50,375,0,0);
		r4=new Box1("field.jpg",0,0,800,600,0,0);
		r5=new Box1("zlatann.png",1000,110,185,180,0,0);
		//455
		//r1=new Box();
		//r2=new Box(400,300,70,90,2,1);
		key=-1;
		gscore=0;
		kscore = 0;
		gscorex=1;
		kscorex=1;
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
		//sets the new color. Think of the computer picking up a pen
		/*
		g2d.setColor(Color.BLUE);
		g2d.fillRect(r1.getX(),r1.getY() ,r1.getW(), r1.getH());
		g2d.setColor(Color.RED);
		g2d.fillRect(r2.getX(),r2.getY(), r2.getW(), r2.getH());
		g2d.setColor(Color.white);
		g2d.fillRect(r3.getX(),r3.getY(), r3.getW(), r3.getH());
		*/
/*
		kx=400;
		zx=-300;
		g2d.drawImage(new ImageIcon(r4.getPic()).getImage(),r4.getX(),r4.getY(),r4.getW(),r4.getH(),this);
		g2d.drawImage(new ImageIcon(r1.getPic()).getImage(),r1.getX(),r1.getY(),r1.getW(),r1.getH(),this);
		g2d.drawImage(new ImageIcon(r2.getPic()).getImage(),r2.getX(),r2.getY(),r2.getW(),r2.getH(),this);
		g2d.drawImage(new ImageIcon(r5.getPic()).getImage(),r5.getX(),r5.getY(),r5.getW(),r5.getH(),this);
		g2d.drawImage(new ImageIcon(r3.getPic()).getImage(),r3.getX(),r3.getY(),r3.getW(),r3.getH(),this);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font ("Impact", Font.PLAIN, 36));
		g2d.drawString("Goalie Blocks: "+String.valueOf(gscore), 50, 50);
		g2d.drawString("Striker Score: "+String.valueOf(kscore), kx, 50);
		g2d.drawString("Zlatan's Score: "+String.valueOf(kscore), zx, 50);
		//400
		g2d.setColor(Color.red);
		g2d.setFont(new Font ("chiller", Font.BOLD, 100));
		if (kscore>= 15 ) {
			///l.playmusic("loss.wav");
			g2d.drawString("You LOSE",235, 300);
		}
		g2d.setColor(Color.green);
		g2d.setFont(new Font ("Impact", Font.PLAIN, 100));
		if (gscore>= 10 && kscore<15) {
			g2d.drawString("You WIN",235, 300);
		}
		move(getSize().width, getSize().height);
		if(r2.Collision(r3))
		{
			resetBall();
			kscore+=kscorex;
		}
		if(r2.Collision(r1)) {
			resetBall();
			gscore+=gscorex;
			p.playmusic("clapzz.wav");
		}
		
		// create an open rectangle	
		// create a filled Rect		
		//This line tells the program to draw everything above. If you delete this, nothing will show up.
		twoDgraph.drawImage(back, 0, 0, null);
	}
	public void move(int w,int h) {
		r1.move(w,h);
		r2.move(w,h);
	}
	public void keyTyped(KeyEvent e) {
		
	}
	public void keyPressed(KeyEvent e) {
		key=e.getKeyCode();

		if(key==74) {//cheatcode
			gscorex++;
		}
		if(key==75) {//cheatcodekicker
			r5.setX(455);
			//kx=-400;
			//zx=400;
			kscorex++;
			//else {
				//kx=400;
				//zx=-300;
			//;}
		}
		gs=-3;
		gds=3;
		//if(key==66) {
			//clap();
		//}
		if(key==38)//up
			r1.setDy(gs);
		if(key==40)//down
			r1.setDy(gds);
		//if(key==37)//left
			//r1.setDx(-3);
		//if(key==39)//right
		//	r1.setDx(3);
		if(key==32) {//Space
			p.playmusic("ballkick.wav");
			double dy=5*Math.random()-2.5;
			resetBall();
			r2.setDx(-3);
			r2.setDy((int)dy);
		}
		if(key==86) {//resetscore
			gscore=0;
			kscore=0;
		}
		if(key==67){//resetgoalie
			resetGoalie();
		}
		if(key==49){//topshot
			p.playmusic("ballkick.wav");
			r2.setDx(-3);
			r2.setDy(-2);
		}
		if(key==50) {//upshot
			p.playmusic("ballkick.wav");
			r2.setDx(-3);
			r2.setDy(-1);
		}
		if(key==51) {//downshot
			p.playmusic("ballkick.wav");
			r2.setDx(-3);
			r2.setDy(1);
		}
		if(key==52) {//botttomshot
			p.playmusic("ballkick.wav");
			r2.setDx(-3);
			r2.setDy(2);
		}
		if(key==53) {//middleshot
			p.playmusic("ballkick.wav");
			r2.setDx(-3);
			r2.setDy(0);	
		}
	}
	public void keyReleased(KeyEvent e) {
		key=e.getKeyCode();
		if(key==38)
			r1.clearDY();
		if(key==40)
			r1.clearDY();
		//if(key==37)
			//r1.clearDX();
		//if(key==39)
			//r1.clearDX();
	}
	public void resetBall() {
		r2.setDx(0);
		r2.setDy(0);
		r2.setX(500);
		r2.setY(260);
	}
	public void resetGoalie() {
		r1.setDx(0);
		r1.setDy(0);
		r1.setX(250);
		r1.setY(260);
	}
	public void zlatan() {
		
	}
	public void clap() {
		var sound=true;
		if (gscore == 10 && sound) {
			  p.playmusic("mario.wav");
			  sound=false;
			}
	}
////}
*/