package Super;
/*Anh tuan, Desmond, Razeen
*/

import java.awt.Color;
import java.awt.Graphics;

import game.Handler;
import game.ID;
import tile.Tile;

	/*****************************
 * class Bullet
 * 
 * This class represents movement of the bullet 
 * This class using the following libraries: abcd
 */
public class Bullet extends Super {
	
	public Bullet(int x, int y, int WIDTH, int HEIGHT, ID id, boolean s, Handler handler, int facing) {
		super(x, y, WIDTH, HEIGHT, s, id, handler);
	/*This method using if statements to check the facing direction of the player then implements the direction of bullets
	*if facing = 0 then the player is facing to the left which means the bullet will go from the player's position to x=0
	*if facing = 1 then the player is facing to the right which means the bullet will go from the player's position to x= width
	*the velocity of the bullet is set |x| = 8
	*return nothing
	*/

		switch (facing) {
		case 0:
			setVelocityX(-8);
			break;
		case 1:
			setVelocityX(8);
			break;
		}
	}
	/*This method update the movement of the bullets vertically and horizontally by adding or subtracting velocityX or velocityY
	*Loop through all the object in the linkedlist object. If the bullet is solid and if the bullet het the environment, the bullet get destroyed
	*if the player jumping or falling, the bullet direction will be changed accordingly to the position of the player
	* Loop through the linked list object again and heck if the bullet hit the enemy. If it does, destroy the enemy.
	*return nothing
	*/

	@Override
	public void update() {
		x += velocityX;
		y += velocityY;

		for (int i = 0; i < handler.object.size(); i++) {
			Tile t = handler.object.get(i);

			if (t.isS()) { 
				if (getBoundsLeft().intersects(t.getBounds()) || getBoundsRight().intersects(t.getBounds())) { // if the
																												// bullet
																												// hits
																												// boundry
					death(); 
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
			if (s.getId() == ID.Enemy0) {
				if (getBounds().intersects(s.getBounds())) {
					death();
					s.death();
				}
			}
		}

	}

	/* Create a sample bullet before implement real image
	*return nothing
		*/
	@Override
	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

}
