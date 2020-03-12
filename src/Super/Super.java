package Super;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.Handler;
import game.ID;

public abstract class Super {
	public int x;
	public int y;
	public int WIDTH;
	public int HEIGHT;
	public int velocityX;
	public int velocityY;
	public ID id;
	public Handler handler;
	public int facing;
	public boolean jumping = false;
	public boolean s = false;
	public boolean falling = true;
	public double gravity = 0.0;

	public Super(int x, int y, int WIDTH, int HEIGHT, boolean s, ID id, Handler handler) {
		setX(x);
		setY(y);
		setWIDTH(WIDTH);
		setHEIGHT(HEIGHT);
		setS(s);
		setId(id);
		setHandler(handler);
		
	}

	public abstract void update();

	public abstract void render(Graphics g);
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public boolean isS() {
		return s;
	}

	public void setS(boolean s) {
		this.s = s;
	}
	
	public ID getId() {		
		return id;
	}
	
	public void setId(ID i) {
		this.id = i;
	}
	
	public void setHandler(Handler h) {
		this.handler = h;
	}
	
	public Handler getHandler() {
		return new Handler();
	}
	
	public void death() {
		handler.removeSuper(this);
	}

	public void setVelocityX(int velocityX) {
		this.velocityX = velocityX;
	}
	
	public void setVelocityY(int velocityY) {
		this.velocityY = velocityY;
	}

	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), WIDTH, HEIGHT);
	}

	public Rectangle getBoundsUp() {
		return new Rectangle(getX() + 10, getY(), WIDTH - 20, 5);
	}

	public Rectangle getBoundsDown() {
		return new Rectangle(getX() + 10, getY() + HEIGHT - 5, WIDTH - 20, 5);
	}

	public Rectangle getBoundsLeft() {
		return new Rectangle(getX(), getY() + 10, 5, HEIGHT - 20);
	}

	public Rectangle getBoundsRight() {
		return new Rectangle(getX() + WIDTH - 5, getY() + 10, 5, HEIGHT - 20);
	}


}
