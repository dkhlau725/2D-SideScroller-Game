package tile;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.Handler;
import game.ID;

public abstract class Tile {
	public int x;
	public int y;
	public int WIDTH;
	public int HEIGHT;
	public boolean s;
	public int velocityX, velocityY;
	public ID id;
	public Handler handler;
	
	
	
	public Tile(int x , int y, int WIDTH, int HEIGHT, boolean s, ID id, Handler handler) {
		this.x = x;
		this.y = y;
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		this.s = s;
		this.id = id;
		this.handler = handler;
		
	}
	
	public ID getID() {
		return id;
	}
	public abstract void update();

	
	public abstract void render(Graphics g);
	
	public void death() {
		handler.removeTile(this);
	}
	
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

	public boolean isS() {
		return s;
	}

	public void setS(boolean s) {
		this.s = s;
	}

	public void setVelocityX(int velocityX) {
		this.velocityX = velocityX;
	}

	public void setVelocityY(int velocityY) {
		this.velocityY = velocityY;
	}

	public Rectangle getBounds(){
		return new Rectangle(getX(), getY(), WIDTH, HEIGHT);
	}
	
}
