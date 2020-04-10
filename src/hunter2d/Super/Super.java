package hunter2d.Super;

import java.awt.Graphics;
import java.awt.Rectangle;

import hunter2d.game.Handler;
import hunter2d.game.ID;

/**
 * TODO: What is Super?
 * Looks like Super is your representation of an entity/object in your game?
 * It has position (x,y, facing)? dimensions? 
 */
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

	/**
	 * TODO: Describe each parameter
	 * @param x Write here: What is x? 
	 * @param y What is y?
	 * @param WIDTH What does width do?
	 * @param HEIGHT etc..
	 * @param s
	 * @param id
	 * @param handler
	 */
	public Super(int x, int y, int WIDTH, int HEIGHT, boolean s, ID id, Handler handler) {
		this.x = x;
		this.y = y;
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		this.s = s;
		this.id = id;
		this.handler = handler;
	}

	/**
	 * TODO: What would `update` do in general?
	 * Try to summarize/put into a single statement as to what 
	 * update does in classes that extend Super. 
	 */
	public abstract void update();

	/**
	 * TODO: What would `render` do in general?
	 * @param g
	 */
	public abstract void render(Graphics g);

	/**
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * TODO: Describe what this function does
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * TODO: Describe what this function does
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * TODO: Describe what this function does
	 */
	public void death() {
		handler.removeSuper(this);
	}

	/**
	 * TODO: Describe what this function does; what is velocity for?
	 */
	public void setVelocityX(int velocityX) {
		this.velocityX = velocityX;
	}

	/**
	 * 
	 * @return id
	 */
	public ID getId() {
		return id;
	}

	/**
	 * TODO: Describe what this function does
	 */
	public void setVelocityY(int velocityY) {
		this.velocityY = velocityY;
	}

	/**
	 * TODO: Describe what this function does
	 * @return Rectangle TODO: describe the expected object being returned
	 */
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), WIDTH, HEIGHT);
	}

	/**
	 * TODO: Describe what this function does
	 * @return Rectangle TODO: describe the expected object being returned
	 */
	public Rectangle getBoundsUp() {
		return new Rectangle(getX() + 10, getY(), WIDTH - 20, 5);
	}

	/**
	 * TODO: Describe what this function does
	 * @return Rectangle TODO: describe the expected object being returned
	 */
	public Rectangle getBoundsDown() {
		return new Rectangle(getX() + 10, getY() + HEIGHT - 5, WIDTH - 20, 5);
	}

	/**
	 * TODO: Describe what this function does
	 * @return Rectangle TODO: describe the expected object being returned
	 */
	public Rectangle getBoundsLeft() {
		return new Rectangle(getX(), getY() + 10, 5, HEIGHT - 20);
	}

	/**
	 * TODO: Describe what this function does
	 * @return Rectangle TODO: describe the expected object being returned
	 */
	public Rectangle getBoundsRight() {
		return new Rectangle(getX() + WIDTH - 5, getY() + 10, 5, HEIGHT - 20);
	}

	/**
	 * TODO: Describe what this function does
	 * @return Rectangle TODO: describe the expected object being returned
	 */
	public Rectangle bulletBoundsLeft() {
		return new Rectangle(getX(), getY() + 10, 5, HEIGHT);
	}

	/**
	 * TODO: Describe what this function does
	 * @return Rectangle TODO: describe the expected object being returned
	 */
	public Rectangle bulletBoundsRight() {
		return new Rectangle(getX() + WIDTH - 5, getY() + 10, 5, HEIGHT);
	}

	/**
	 * TODO: Describe what this function does
	 */
	public int getWIDTH() {
		return WIDTH;
	}

	/**
	 * TODO: Describe what this function does
	 */
	public void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}
	
	/**
	 * TODO: Describe what this function does
	 */
	public int getHEIGHT() {
		return HEIGHT;
	}

	/**
	 * TODO: Describe what this function does
	 */
	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}

	/**
	 * TODO: Describe what this function does
	 */
	public boolean isS() {
		return s;
	}

	/**
	 * TODO: Describe what this function does
	 */
	public void setS(boolean s) {
		this.s = s;
	}
}
