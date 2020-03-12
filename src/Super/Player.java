package Super;

import game.Main;
import tile.Tile;

import java.awt.Color;
import java.awt.Graphics;

import game.Handler;
import game.ID;

/* Class player
*This class represents the movement of the player
* This class uses these following libraries abcd 
*/

public class Player extends Super {

	public Player(int x, int y, int WITDH, int HEIGHT, boolean s, ID id, Handler handler) {
		super(x, y, WITDH, HEIGHT, s, id, handler);
	}
	/*This method update the movement of the player and create the bounce to restrict the player not to get out of the screen.
	*This also check the collision between players and evironment by looping through the environment data inside the object linkedlist
	and check the ID if it is a wall or not. If it is a wall, it's going to get the intersection and avoid player to jump through it.
	*Then it also implements the gravity of the player. Using boolean for jumping and falling to check the position of the player.
	* If the player is jumping, set the update gravity to -0.2, else set the update gravity to +0.1.
	*/
	@Override
	public void update() {
		x += velocityX;
		y += velocityY;
		if (x <= 0)
			x = 0;

		if (x + WIDTH >= 1080)
			x = 1080 - WIDTH;
		if (y + HEIGHT >= 771)
			y = 771 - HEIGHT;


		for (Tile enviro : handler.object) {
			if (enviro.s == false)
				break;
			if (enviro.getId() == ID.wall) {
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
					// System.out.println("falling is " + falling);
					if (falling == true) {
						falling = false;
						// jumping = false;
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
					x = enviro.getX() - enviro.WIDTH;
				}
			}
		}

		// Gravity
		if (jumping == true) {
			gravity -= 0.2;
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

	}
	/*this method is used to create a box that represents the player before impletment the image
	*/
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

}
