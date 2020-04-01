package Super;

import java.awt.Graphics;

import game.Handler;
import game.ID;
import game.Main;
import tile.Tile;

public class Spikes extends Super {

	public int velocityY = -1;

	public Spikes(int x, int y, int WIDTH, int HEIGHT, boolean s, ID id, Handler handler) {
		super(x, y, WIDTH, HEIGHT, s, id, handler);
	}

	public void update() {
		if (handler.SCORE < 10) {
			y += velocityY;
		} else if (handler.SCORE < 15) {
			setVelocityY(-2);
			y += velocityY;
		} else if (handler.NEWSCORE < 20) {
			setVelocityY(-3);
			y += velocityY;
		} else {
			setVelocityY(-4);
			y += velocityY;
		}

		for (int i = 0; i < handler.object.size(); i++) {
			Tile enviro = handler.object.get(i);
			if (enviro.s == false)
				break;
			if (enviro.getID() == ID.tile) {
				if (getBounds().intersects(enviro.getBounds())) {
					enviro.destroy();
					Main.spikes.play();
				}
			}
		}

		for (int j = 0; j < handler.player.size(); j++) {
			Super play = handler.player.get(j);
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
			} else if (play.getId() == ID.Enemy) {
				if (getBounds().intersects(play.getBounds())) {
					play.death();
					Main.bird.play();
				}
			}
		}
	}

	public void render(Graphics g) {
		g.drawImage(Main.spike.getBufferedImage(), x, y, WIDTH, HEIGHT, null);
	}

	public int getVelocityY() {
		return velocityY;
	}

	public void setVelocityY(int velocityY) {
		this.velocityY = velocityY;
	}
}
