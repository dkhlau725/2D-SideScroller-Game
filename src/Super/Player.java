package Super;
import game.Main;
import tile.Tile;

import java.awt.Color;
import java.awt.Graphics;

import game.Handler;
import game.ID;

public class Player extends Super {



	public Player(int x, int y, int WITDH, int HEIGHT,boolean s, ID id, Handler handler) {
		super(x, y, WITDH, HEIGHT, s, id, handler);		
	}

	public void update() {
		x+= velocityX;
		y+= velocityY;
		if(x <= 0) x=0;
	//	if (y <=0) y=0;
		if (x + WIDTH >= 1080) x= 1080-WIDTH;
		if(y + HEIGHT >= 771) y = 771-HEIGHT;
		
		//COLLISION DETECTION
		for (Tile enviro : handler.object) {
			if(enviro.s == false) break;
			if(enviro.getID() == ID.wall) {
				if(getBoundsUp().intersects(enviro.getBounds())) {
					setVelocityY(0);
					
					//JUMP UP COLLISION
					if(jumping == true) {
						jumping = false;
						gravity = 0.0;
						falling = true;
					}
				}			
				if(getBoundsDown().intersects(enviro.getBounds())) {
					setVelocityY(0);
				//	System.out.println("falling is " + falling);
					if (falling == true) {
						falling = false;
						//jumping = false;
					}
					if(falling == false && jumping == false) {
							gravity = 0.0;
							falling = true;
						}
					
				}
				if(getBoundsLeft().intersects(enviro.getBounds())) {
					setVelocityX(0);
					x = enviro.getX() + enviro.WIDTH;
				}
				if(getBoundsRight().intersects(enviro.getBounds())) {
					setVelocityX(0);
					x = enviro.getX() - enviro.WIDTH;
				}
			}
		}	
		
		//GRAVITY
		if(jumping == true) {
			gravity -= 0.2;
			setVelocityY((int)-gravity);
			if (gravity < 0.0) {
				jumping = false;
				falling = true;
			}
		}
		if(falling == true) {
			jumping = false;
			gravity += 0.1;
			setVelocityY((int)gravity);
					
		}
		
	}

	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, WIDTH, HEIGHT);		
	}

}
