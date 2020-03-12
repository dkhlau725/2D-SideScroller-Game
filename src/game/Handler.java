package game;
/*Anh Tuan
*/

import java.util.Random;

import java.awt.Graphics;

import java.util.LinkedList;

import Super.Enemy0;
import Super.Player;
import Super.Super;
import tile.Tile;
import tile.Wall;
/*Class Handler
*This class used linkedlist to store position of player, object, and enemies. 
*
*/

public class Handler {
	public LinkedList<Super> player = new LinkedList<Super>();
	public LinkedList<Tile> object = new LinkedList<Tile>();
	public LinkedList<Enemy0> enemy0 = new LinkedList<Enemy0>();
	public int plat = 500;

	public Handler() {
		makeLevel();
	}
/* This method render used to update graphic of player, objects, and enemy which used the data stored in the linkedlist.
*It returns nothing
*/
	public void render(Graphics g) {
		for (int a = 0; a < player.size(); a++) {
			Super p = player.get(a);
			p.render(g);

		}
		for (int b = 0; b < object.size(); b++) {
			Tile o = object.get(b);
			o.render(g);
		}

		for (int c = 0; c < enemy0.size(); c++) {
			Enemy0 q = enemy0.get(c);
			q.render(g);
		}
	}
	
/* This method update used to update movement of player, objects, and enemy which used the data stored in the linkedlist.
*It returns nothing
*/
	public void update() {
		for (int i = 0; i < player.size(); i++) {
			Super p = player.get(i);
			p.update();
		}
		for (int j = 0; j < object.size(); j++) {
			Tile o = object.get(j);
			o.update();
		}

		for (int k = 0; k < enemy0.size(); k++) {
			Enemy0 q = enemy0.get(k);
			q.update();
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

	public void addEnemy0(Enemy0 e) {
		enemy0.add(e);
	}

	public void removeEnemy0(Enemy0 e) {
		enemy0.remove(e);
	}
/*This are methods that still in the development stage and will be complete by demo3
*These methods are ideally used to create a platform
*/
	public int getRandomPosition() {
		Random generate = new Random();
		int low = 10;
		int high = 100;
		int result = generate.nextInt(high - low) + low;
		return result;
	}

	public int getRandomSize() {
		Random generate = new Random();
		int low = 64;
		int high = 200;
		int result = generate.nextInt(high - low) + low;
		return result;
	}

	public void makeLevel() {
		for (int i = 0; i < Main.WIDTH * Main.SCALE / 64 + 1; i++) {
			addTile(new Wall(i * 64, Main.HEIGHT * Main.SCALE - 64, 64, 64, true, ID.wall, this));
		}
	}

	public void addPlatform() {
		for (int j = 0; j < Main.WIDTH * Main.SCALE / 64 + 1; j++) {

			addTile(new Wall(j * getRandomPosition(), this.plat - getRandomPosition(), 64, 64, true, ID.wall, this));
			this.plat -= getRandomPosition();
		}
	}

}
