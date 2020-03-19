package key;

import javafx.scene.input.KeyEvent;
import Super.Bullet;
import Super.Super;
import game.ID;
import game.Main;
import game.Handler;
import tile.Tile;

public class KeyboardInput {
	private boolean Fire;

	public void keyReleased(KeyEvent e, Handler handler) {
		String key = e.getCode().toString();
		
		for (int i = 0; i < handler.player.size(); i++) {
			Super player = handler.player.get(i);
			if (player.getId() == ID.player) {
				switch (key) {
				case "W":
					player.setVelocityY(0);
					break;
				case "A":
					player.setVelocityX(0);
					break;
				case "D":
					player.setVelocityX(0);
					break;
				case "SPACE":
					Fire = false;
					break;
				}
			}
		}
	}

	public void keyPressed(KeyEvent e, Handler handler) {
		
		String key = e.getCode().toString();
		
		System.out.println(handler.player.size());
		
		for (int i = 0; i < handler.player.size(); i++) {
			Super s = handler.player.get(i);
			System.out.println(key);
			if (s.getId() == ID.player) {
				switch (key) {
				case "W":
					
				//	handler.addPlatform();
					
					for (int a = 0; a < handler.object.size(); a++) {
						Tile o = handler.object.get(a);
						if (o.isS()) {
							if (s.getBoundsDown().intersects(s.getBounds())) {
								if (s.jumping == false) {
									s.jumping = true;
									s.falling = false;
									s.gravity = 10.0;

								}
							}

						}

					}
					break;
				case "A":
					s.setVelocityX(-5);
					s.facing = 0;
					break;
				case "D":
					s.setVelocityX(5);
					s.facing = 1;
					break;
				case "SPACE":
					System.out.println("nooooooo");
					System.out.println(s.facing);
					if (true == !Fire) {
						switch (s.facing) {
						case 0: // facing left
							// check the boolean true

							handler.addSuper(new Bullet(s.getX() - 30, s.getY() + 12, 24, 24, ID.bullet, false,
									handler, s.facing));
							keyReleased(e, handler);
							Fire = true;

							break;
						case 1: // facing right

							handler.addSuper(new Bullet(s.getX() + s.getWIDTH(), s.getY() + 12, 24, 24, ID.bullet,
									false, handler, s.facing));
							keyReleased(e, handler);
							Fire = true;
							break;
						}
					}
				}
			}
		}

	}

	public void keyTyped(KeyEvent e) {
		// wtf
	}

}
