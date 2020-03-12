package tile;
/*Anh Tuan
*/
import java.awt.Graphics;
import java.awt.Rectangle;

import game.Handler;
import game.ID;
/*class Tile
*This class used to represent all the categories related to the objects
*It contains the following variables: the coordinates x,y of the object, Screen coordinates WIDTH/HEIGHT, beoolean s to chechk the solidity;
*ID the check ID of the object, and handler to append the information in the linkedlist to update it.
*/


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
		setX(x);
		setY(y);
		setWIDTH(WIDTH);
		setHEIGHT(HEIGHT);
		setS(s);
		setId(id);
		setHandler(handler);	
	}
	/*This method update used to update the position of the object
	* It returns nothing
	*/
	
	public abstract void update();
	/*This method render used to update the graphic of the object
	* It returns nothing
	*/
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

	
