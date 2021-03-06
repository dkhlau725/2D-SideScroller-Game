package hunter2d.key;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import hunter2d.Super.Bullet;
import hunter2d.Super.Super;
import hunter2d.game.ID;
import hunter2d.game.Main;
import hunter2d.tile.Tile;

public class KeyboardInput implements KeyListener {
	private boolean Fire;
	private boolean hold;
	public int counter=0;

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < Main.handler.player.size(); i++) {
			Super player = Main.handler.player.get(i);
			if (player.getId() == ID.player) {
				switch (key) {
				case KeyEvent.VK_W:
					player.setVelocityY(0);
					hold = false;
					break;
				case KeyEvent.VK_A:
					player.setVelocityX(0);
					break;
				case KeyEvent.VK_D:
					player.setVelocityX(0);
					break;
				case KeyEvent.VK_SPACE:
					Fire = false;
					break;
				case KeyEvent.VK_ESCAPE:
					System.out.println("g");
					break;
				}

			}
		}
	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		for (int i = 0; i < Main.handler.player.size(); i++) {
			Super s = Main.handler.player.get(i);
			if (s.getId() == ID.player) {

				switch (key) {

				case KeyEvent.VK_W:
					counter++;
					//System.out.println(counter);
					if (true == !hold) {
					
						if (counter % 2==0) {
							Main.handler.addPlatform();
						}
						
						for (int a = 0; a < Main.handler.object.size(); a++) {
							Tile o = Main.handler.object.get(a);

							if (o.isS()) {
								if (s.getBoundsDown().intersects(s.getBounds())) {
									if (s.jumping == false) {
										s.jumping = true;
										s.falling = false;
										s.gravity = 10.0;

										Main.jump.play();
									}
								}
							}
						}
						hold = true;
					}
					break;

				case KeyEvent.VK_A:
					s.setVelocityX(-5);
					s.facing = 0;
					break;

				case KeyEvent.VK_D:
					s.setVelocityX(5);
					s.facing = 1;
					break;

				case KeyEvent.VK_SPACE:
					if (true == !Fire) {
						switch (s.facing) {

						// facing left
						case 0:
							Main.handler.addSuper(new Bullet(s.getX() - 15, s.getY() + 28, 24, 10, ID.bullet, false,
									Main.handler, s.facing));
							keyReleased(e);
							Fire = true;
							Main.gunshot.play();
							break;

						// facing right
						case 1:
							Main.handler.addSuper(new Bullet(s.getX() + s.getWIDTH() - 20, s.getY() + 28, 24, 10,
									ID.bullet, false, Main.handler, s.facing));
							keyReleased(e);
							Fire = true;
							Main.gunshot.play();
							break;
						}
					}
					break;

				case KeyEvent.VK_ESCAPE:
					if (Main.playingGame == true) {
						Main.handler.deleteLevel();
						Main.handler.makeLevel();
						Main.handler.NEWSCORE = 0;
						Main.handler.SCORE = 0;
						Main.handler.plat = 100;
					}
					break;
				}
			}
		}
	}

	public void keyTyped(KeyEvent e) {
		// nothing here
	}

}
