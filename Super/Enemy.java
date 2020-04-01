//created and edited by Mohamed & Vladimir

package Super;

import game.Main;
import tile.Tile;
import java.awt.Graphics;
import game.Handler;
import game.ID;
import Super.Player;

public class Enemy extends Super {

	private int velX = -3;
	private int velY = 1;
	private int frame = 0;
	private int delay = 0;
	Player player;

	public Enemy(int x, int y, int WIDTH, int HEIGHT, boolean s, ID id, Handler handler) {
		super(x, y, WIDTH, HEIGHT, s, id, handler);
	}

	public void update() {
		x += velX;
		y += velY;

		if (x <= 0) {
			setVelX(2);
			facing = 1;
		}

		if (x + WIDTH >= 1080) {
			setVelX(-2);
			facing = 0;
		}

		// checking collision and out of bounds
		for (int i = 0; i < handler.object.size(); i++) {
			Tile enviro = handler.object.get(i);
			if (enviro.s == false)
				break;
			if (enviro.getID() == ID.tile) {
				if (getBoundsUp().intersects(enviro.getBounds())) {
					setVelY(0);
				}

				if (getBoundsDown().intersects(enviro.getBounds())) {
					setVelY(0);
				}

				if (getBoundsLeft().intersects(enviro.getBounds())) {
					setVelX(2);
					facing = 1;
					x = enviro.getX() + enviro.WIDTH;
				}

				if (getBoundsRight().intersects(enviro.getBounds())) {
					setVelX(-2);
					facing = 0;
					x = enviro.getX() - WIDTH;
				}
			}
			// if enemy collides with player remove player
			for (int k = 0; k < handler.player.size(); k++) {
				Super play = handler.player.get(k);
				if (play.s == false)
					break;
				if (play.getId() == ID.player) {
					if (getBounds().intersects(play.getBounds())) {
						play.death();
						Main.death.play();
						handler.player.clear();
						handler.object.clear();
						Main.endGame = true;
					}

				}
			}
		}
		delay++;
		if (delay >= 3) {
			frame++;
			if (frame >= 7) {
				frame = 0;
			}
			delay = 0;
		}

	}

	// color and shape of the enemy
	public void render(Graphics g) {
		if (this.facing == 0) {
			g.drawImage(Main.enemy[frame + 7].getBufferedImage(), x, y, WIDTH, HEIGHT, null);
		}
		// facing right
		else if (this.facing == 1) {
			g.drawImage(Main.enemy[frame].getBufferedImage(), x, y, WIDTH, HEIGHT, null);
		}
	}

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

}
