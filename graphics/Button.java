package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import game.Main;

public class Button {

	public int x;
	public int y;
	public int WIDTH;
	public int HEIGHT;
	public String label;

	public Button(int x, int y, int WIDTH, int HEIGHT, String label) {
		super();
		this.x = x;
		this.y = y;
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		this.label = label;
	}

	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("Courier", Font.BOLD, 30));

		FontMetrics alignment = g.getFontMetrics();
		int alignX = (getWIDTH() - alignment.stringWidth(getLabel())) / 2;
		int alignY = (alignment.getAscent() + (getHEIGHT() - (alignment.getAscent() + alignment.getDescent())) / 2);
		g.drawString(getLabel(), getX() + alignX, getY() + alignY);
	}

	public void clickEvent() {
		if (getLabel().toLowerCase().contains("start")) {
			Main.playingGame = true;
			Main.music.play();
		} else if (getLabel().toLowerCase().contains("quit")) {
			System.exit(0);
		}
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
