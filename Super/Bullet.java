package Super;

import java.awt.Color;
import java.awt.Graphics;

import game.Handler;
import game.ID;
import game.Main;
//import jdk.internal.org.objectweb.asm.Handle;
import tile.Tile;

public class Bullet extends Super {

	public Bullet(int x, int y, int WIDTH, int HEIGHT, ID id, boolean s, Handler handler, int facing) {
		super(x, y, WIDTH, HEIGHT, s, id, handler);

		switch (facing) {
		case 0:
			setVelocityX(-8);
			break;
		case 1:
			setVelocityX(8);
			break;
		}
	}

	public void update() {
		x += velocityX;
		y += velocityY;

		for (int i = 0; i < handler.object.size(); i++) {
			Tile t = handler.object.get(i);

			if (t.isS()) { // if the tile is solid
				if (bulletBoundsLeft().intersects(t.getBounds()) || bulletBoundsRight().intersects(t.getBounds())) { // if the														// bullet
																												// hits																								// boundry
					death(); // bullet gets destroyed
				}
				if (getBoundsDown().intersects(t.getBounds())) {
					jumping = true;
					falling = false;
					gravity = 4.0;
				} else if (!falling && !jumping) {
					falling = true;
					gravity = 1.0;
				}
			}

		}

		if (jumping) {
			gravity -= 0.31;
			setVelocityY((int) -gravity);
			if (gravity <= 0.5) {
				jumping = false;
				falling = true;
			}
			if (falling) {
				gravity += 0.31;
				setVelocityY((int) gravity);
			}

		}

		for (int i = 0; i < handler.player.size(); i++) {
			Super s = handler.player.get(i);
			if (s.getId() == ID.Enemy) {
				if (getBounds().intersects(s.getBounds())) {
					handler.NEWSCORE += 1;
					death();
					s.death();
					Main.bird.play();
				}
			}
		}

	}
	// }

	// }

	public void render(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

}
