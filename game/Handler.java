package game;

import java.util.Random;
import java.awt.Graphics;
import java.util.ArrayList;

import Super.Enemy;
import Super.Player;
import Super.Spikes;
import Super.Super;
import tile.Tile;

//this class use to update the movement of the character and background of the map using array list to store value
public class Handler {
	public ArrayList<Super> player = new ArrayList<Super>();
	public ArrayList<Tile> object = new ArrayList<Tile>();
	public int plat = 100;
	public int platMax = -1000;
	public int SCORE = 0;
	public int NEWSCORE = 0;

	public int counter = 0;
	
	public Handler() {
		makeLevel();
	}

	public void render(Graphics g) {

		for (int b = 0; b < object.size(); b++) {
			Tile o = object.get(b);
			o.render(g);
		}
		
		for (int a = 0; a < player.size(); a++) {
			Super p = player.get(a);
			p.render(g);
		}

	}

	public void update() {
		for (int i = 0; i < player.size(); i++) {
			Super p = player.get(i);
			p.update();
		}
		
		for (int j = 0; j < object.size(); j++) {
			Tile o = object.get(j);
			o.update();
		}

		if (NEWSCORE > SCORE) {
			SCORE = NEWSCORE;
		}
	}

	public void addSuper(Super p) {
		player.add(p);
	}

	public void removeSuper(Super p) {
		player.remove(p);
	}

	public void addTile(Tile o) {
		object.add(o);
	}

	public void removeTile(Tile o) {
		object.remove(o);
	}

	public int getRandomPositionX() {
		Random generate = new Random();
		int result = generate.nextInt(200);
		return result;

	}

	public int getRandomPositionY() {
		Random generate = new Random();
		int result = generate.nextInt(3);
		if (result % 2 == 0) {
			return 225;
		} else if (result % 2 == 1) {
			return 200;
		}
		return 0;
	}

	public int getRandomSize() {
		Random generate = new Random();
		int result = generate.nextInt(150) + 100;
		return result;
	}

	public void makeLevel() {

		// FLOOR
		for (int i = 0; i < Main.WIDTH * Main.SCALE / 64 + 1; i++) {
			addSuper(new Spikes(i * 64, 1100, 64, 64, true, ID.tile, this));
		}

		addSuper(new Player(300, 615, 64, 64, true, ID.player, this));
		addSuper(new Enemy(700, 615, 55, 55, true, ID.Enemy, this));

		for (int i = 0; i < Main.WIDTH * Main.SCALE / 64 + 1; i++) {
			addTile(new Tile(i * 64, Main.HEIGHT * Main.SCALE - 64, 64, 64, true, ID.tile, this));
		}
		for (int i = 12; i < Main.WIDTH * Main.SCALE / 64 + 1; i++) {
			addTile(new Tile(i * 64, 500, 64, 64, true, ID.tile, this));
			addTile(new Tile(i * 64, 100, 64, 64, true, ID.tile, this));
		}
		for (int i = 0; i < 7; i++) {
			addTile(new Tile(i * 64, 300, 64, 64, true, ID.tile, this));
		}
	}

	public void deleteLevel() {
		player.clear();
		object.clear();
	}

	public void addPlatform() {

		int randomY = getRandomPositionY();
		int randomX = getRandomPositionX();

		addTile(new Tile(0, this.plat - randomY, getRandomSize(), 64, true, ID.tile, this));
		addSuper(new Enemy(0 + randomX, this.plat - randomY - 70, 55, 55, true, ID.Enemy, this));

		
		addTile(new Tile(Main.frameWidth() - 200 - randomX, this.plat - randomY, Main.frameWidth() - getRandomSize(),
				64, true, ID.tile, this));
		addSuper(new Enemy(Main.frameWidth() - 200 + randomX, this.plat - randomY - 70, 55, 55, true, ID.Enemy, this));

		addTile(new Tile(Main.frameWidth() / 2 - 150, this.plat - randomY + 125, getRandomSize(), 64, true, ID.tile,
				this));

		this.plat -= randomY;
		counter+=4;
		System.out.println("counter=" + counter);
	}

}
