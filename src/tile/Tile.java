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
	public int velocityX, velocityY;package tile;

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
	
	
	//
	public Tile(int x , int y, int WIDTH, int HEIGHT, boolean s, ID id, Handler handler) {
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

	public void setWIDTH(int w) {
		WIDTH = w;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(int h) {
		HEIGHT = h;
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

	public void setId(ID id) {
		this.id = id;
	}
	
	public void setHandler(Handler h) {
		this.handler = h;
	}
	
	public Handler getHandler() {
		return new Handler();
	}
	
	public void death() {
		handler.removeTile(this);
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
