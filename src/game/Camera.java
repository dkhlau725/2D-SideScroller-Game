package game;
/* Desmond
*/
import Super.Super;
/*Class Camera
* This class used to create a camera that follows the player while it moves around the platform. Since we only implement the game
*vertically so we only update variable Y. 
*/
public class Camera {

	public int x;
	public int y;
	
	public void updateCam(Super player) {
		setY(-player.getY() + Main.HEIGHT*2);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	
}
