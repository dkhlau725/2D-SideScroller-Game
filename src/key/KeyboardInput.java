package key;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Super.Bullet;
import Super.Super;
import game.ID;
import game.Main;
import game.Handler;
import tile.Tile;

public class KeyboardInput implements KeyListener {
	private boolean Fire;	//varabile to make bullet shoot one at a time
	

	//check what key is pressed
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < Main.handler.player.size(); i++) {
			Super player = Main.handler.player.get(i);
			if (player.getId() == ID.player) {
				switch (key) {
				case KeyEvent.VK_W:
					player.setVelocityY(0);
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
				}
			}
		}
	}
	//check what key is pressed and what happends
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		for (int i = 0; i < Main.handler.player.size(); i++) {
			Super s = Main.handler.player.get(i);
			if (s.getId() == ID.player) {
				switch (key) {
				case KeyEvent.VK_W:	//when the player jumps
					
					Main.handler.addPlatform();	//platforms appear
					
					for (int a = 0; a < Main.handler.object.size(); a++) {
						Tile o = Main.handler.object.get(a);
						if (o.isS()) {
							if (s.getBoundsDown().intersects(s.getBounds())) { //checking the bounds
								if (s.jumping == false) {
									s.jumping = true;
									s.falling = false;
									s.gravity = 10.0;

								}
							}

						}

					}
					break;
				case KeyEvent.VK_A:	//movine left 
					s.setVelocityX(-5);
					s.facing = 0;
					break;
				case KeyEvent.VK_D:	//moving right
					s.setVelocityX(5);
					s.facing = 1;
					break;
				case KeyEvent.VK_SPACE:	//shooting
					System.out.println("nooooooo");
					System.out.println(s.facing);
					if (true == !Fire) {	//making one bullet shoot per press of space
						switch (s.facing) {
						case 0: // facing left
							// check the boolean true
							//make bullet appear	
							Main.handler.addSuper(new Bullet(s.getX() - 30, s.getY() + 12, 24, 24, ID.bullet, false,
									Main.handler, s.facing));
							keyReleased(e);
							Fire = true;

							break;
						case 1: // facing right
							//make bullet appear
							Main.handler.addSuper(new Bullet(s.getX() + s.getWIDTH(), s.getY() + 12, 24, 24, ID.bullet,
									false, Main.handler, s.facing));
							keyReleased(e);
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
