package Super;

import java.awt.Graphics;

import game.Main;
import graphics.Button;
import game.Handler;
import game.ID;
import tile.Tile;


public class Player extends Super {

	private int frame = 0;
	private int delay = 0;
	public Button[] buttons;

	public Player(int x, int y, int WITDH, int HEIGHT, boolean s, ID id, Handler handler) {
		super(x, y, WITDH, HEIGHT, s, id, handler);
	}

	public void update() {
		x += velocityX;
		y += velocityY;
		if (x <= 0)
			x = 0;
		if (x + WIDTH >= 1080)
			x = 1080 - WIDTH;
		if (y + HEIGHT >= 771)
			y = 771 - HEIGHT;

		// COLLISION DETECTION
		for (int i = 0; i < handler.object.size(); i++) {
			Tile enviro = handler.object.get(i);
			if (enviro.s == false)
				break;
			if (enviro.getID() == ID.tile) {
				if (getBoundsUp().intersects(enviro.getBounds())) {
					setVelocityY(0);

					// JUMP UP COLLISION
					if (jumping == true) {
						jumping = false;
						gravity = 0.0;
						falling = true;
					}
				}
				if (getBoundsDown().intersects(enviro.getBounds())) {
					setVelocityY(0);

					if (falling == true) {
						if (gravity >= 15 && getBoundsDown().intersects(enviro.getBounds())) {
							death();
							Main.death.play();
							handler.player.clear();
							handler.object.clear();
							Main.endGame = true;
						}
						falling = false;
					}
					if (falling == false && jumping == false) {
						gravity = 0.0;
						falling = true;
					}

				}
				if (getBoundsLeft().intersects(enviro.getBounds())) {
					setVelocityX(0);
					x = enviro.getX() + enviro.WIDTH;
				}
				if (getBoundsRight().intersects(enviro.getBounds())) {
					setVelocityX(0);
					x = enviro.getX() - WIDTH;
				}
			}
		}

		// GRAVITY
		if (jumping == true) {
			gravity -= 0.4;
			setVelocityY((int) -gravity);
			if (gravity < 0.0) {
				jumping = false;
				falling = true;
			}
		}
		if (falling == true) {
			jumping = false;
			gravity += 0.1;
			setVelocityY((int) gravity);
		}
		delay++;
		if (delay >= 7) {
			frame++;
			if (frame >= 7) {
				frame = 0;
			}
			delay = 0;
		}

	}

	public void render(Graphics g) {
		g.drawString("SCORE: " + handler.SCORE, getX() - 10, getY() - 5);

		//facing left
		if (facing == 0) {
			g.drawImage(Main.player[frame].getBufferedImage(), x, y, WIDTH, HEIGHT, null);
		}
		// facing right
		else if (facing == 1) {
			g.drawImage(Main.player[frame + 7].getBufferedImage(), x, y, WIDTH, HEIGHT, null);
		}
	}

}
