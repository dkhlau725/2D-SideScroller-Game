package tile;

import java.awt.Color;
import java.awt.Graphics;

import game.Handler;
import game.ID;

public class Wall extends Tile{

	public Wall(int x, int y, int WIDTH, int HEIGHT, boolean s, ID id, Handler handler) {
		super(x, y, WIDTH, HEIGHT, s, id, handler);	
	}

	public void update() {		
	}

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, WIDTH, HEIGHT);		
	}	
}
