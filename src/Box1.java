
public class Box1 {
	private String pic;
	private int x;
	private int y;
	private int width;
	private int height;
	private int dx;
	private int dy;
	private boolean movert;
	private boolean movedn;
	
public Box1(){
		
		x=30;
		y=20;
		width=25;
		movert=false;
		movedn=false;
		dx=0;
		dy=0;
	}
	
	public Box1(String s, int x1, int y1, int w, int h, int dx1, int dy1) {
		pic=s;
		x=x1;
		y=y1;
		width=w;
		height=h;
		dx=dx1;
		dy=dy1;
		movert=true;
		movedn=true;
	}
	public String getPic() {
		return pic;
	}
	public void setX(int c) {
		x=c;
	}
	public void setY(int c) {
		y=c;
	}
	public void setDx(int c) {
		dx=c;
	}
	public void setDy(int c) {
		dy=c;
	}
	public int getW() {
		return width;
	}
	public int getH() {
		return height;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getDX() {
		return dx;
	}
	public int getDY() {
		return dy;
	}
	public void clearDX() {
		dx = 0;
	}
	public void clearDY() {
		dy = 0;
	}

public void bounce1(int w1, int h1) {
	this.x+=this.dx;
	this.y+=this.dy;
	if(this.x+this.width>w1) {
		this.dx*=-1;
		this.x=w1-this.width;
	}
	if(this.x<0) {
		this.dx*=-1;
		this.x=0;
	}
	if(this.y+this.height>h1) {
		this.dy*=-1;
		this.y=h1-this.height;
	}
	if(this.y<0) { 
		this.dy*=-1;
		this.y=0;
	}
	}
	public void move(int w1, int h1) {
		x+=dx;
		y+=dy;
		if(x+width>w1)
			x=w1-width;
		if(x<0)
			x=0;
		if(y+height>h1)
			y=h1-height;
		if(y<0)
			y=0;
	}
	public boolean Collision(Box1 b)	{
		return getX()+getW()>=b.getX()&&getX()<=b.getX()+b.getW()&&
				getY()+getH()>=b.getY()&&getY()<=b.getY()+b.getH();
	}

	public void setPic(String string) {
		pic = string;
		
	}
}
