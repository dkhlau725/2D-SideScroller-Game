//created and edited by Mohamed & Vladimir

package Super;

import game.Main;
import tile.Tile;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import game.Handler;
import game.ID;
import Super.Player;

/*this type of enemy just runs towards the player 
* and damages them upon collision 
* 
* more enemy types will be implemented in demo 3, example: an enemy that shoots a player
*/

public class Enemy0 extends Super {

	private int velX = -2;
	private int velY = 1;
	Player player;

	// might need to add other variables

	public Enemy0(int x, int y, int WIDTH, int HEIGHT, boolean s, ID id, Handler handler) {
		super(x, y, WIDTH, HEIGHT, s, id, handler);
	}
	
	//this method updates the position of the enemy 
	// and checks if its on the screen
	public void update() {
		x += velX;
		y += velY;

		if (x <= 0)
			x = 0;
		if (x + WIDTH >= 1080)
			x = 1080 - WIDTH;
		if (y + HEIGHT >= 771)
			y = 771 - HEIGHT;

		// checking collision and out of bounds
		for (Tile enviro : handler.object) {
			if (enviro.s == false)
				break;
			if (enviro.getId() == ID.wall) {
				if (getBoundsUp().intersects(enviro.getBounds())) {
					setVelY(0);
				}

				if (getBoundsDown().intersects(enviro.getBounds())) {
					setVelY(0);
				}

				if (getBoundsLeft().intersects(enviro.getBounds())) {
					setVelX(0);
					x = enviro.getX() + enviro.WIDTH;
				}

				if (getBoundsRight().intersects(enviro.getBounds())) {
					setVelX(0);
					x = enviro.getX() - enviro.WIDTH;
				}
			}
			// if enemy collides with player remove player
			for (Super play : handler.player) {
				// moveTowardsPlayer();
				if (play.s == false)
					break;
				if (play.getId() == ID.player) {
					if (getBounds().intersects(play.getBounds())) {
						play.death();
						break;
					}

				}
			}
		}

	}

	// color and shape of the enemy
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, WIDTH, HEIGHT);

	}

	// method which determines the distance between player and enemy
	public int distanceToPlayer() {
		int a;
		int x = getEnemyX();
		int y = player.getX();
		a = (int) (Math.sqrt(x ^ 2 + y ^ 2));
		return a;

	}

	// test
	/*
	 * public void b() { System.out.println("distance is" + distanceToPlayer()); }
	 */

	// x coordinate of an enemy spawn
	/*
	 * public int xSpawn() { return 0; }
	 */

	// moves an enemy a left to right until the player is spotted
	public void move() {
		// so far the enemy is set to move between 2 points
		if (x == 500) {
			setVelX(2);
		}
		if (x == 900) {
			setVelX(-2);
		}
	}

	/*
	 * if distanceToPlayer is less than 50 and enemy is on the same y-level as
	 * player then an enemy will go in the direction of the player
	 */
	public void moveLeft() {
		setVelX(-5);
	}

	public void moveRight() {
		setVelX(5);
	}

	public void moveTowardsPlayer() {
		int ey = getEnemyY();
		int py = player.getY();
		int a = distanceToPlayer();
		int ex = getEnemyX();
		int px = player.getX();
		if (ey == py) {
			if (a < 150) {
				while (ex > px) {
					moveLeft();
				}
				while (ex < px) {
					moveRight();
				}
			}
		}

	}

	// this method activates when enemy collides with player and reduces player's HP
	// by 1
	// not necessary anymore
	/*
	 * public void enemyHitPlayer() { }
	 */

	public int getEnemyX() {
		return x;
	}

	public void setEnemyX(int x) {
		this.x = x;
	}

	public int getEnemyY() {
		return y;

	}

	public void setEnemyY(int y) {
		this.y = y;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	// will be used to check if enemy died and if yes then removes it from game
	/*
	 * public void enemyDied() { handler.removeSuper(); }
	 */

}
