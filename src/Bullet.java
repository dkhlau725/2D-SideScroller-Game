import java.util.ArrayList;
//Shooting the bullet
//Desmond and Muhammad and Tuan
public class Bullet {
	//private variables 
	private static final int WIDTH = 400;
	private int bx;
	private int by;
	private String space;
	//array list to store bullets fired
	private ArrayList<Integer>bulletList;
	
	
	//constructor
	public Bullet(String space) {
		this.space = space;
		this.bulletList = new ArrayList<Integer>();
	}
	
	//sets the inital position of the bullet 
	public void setBullet(int bx, int by) {
		this.bx = bx;
		this.by = by;
	}
	

	//updating the array, adding x and y for each bullet fired
	//updating x and y depending on where the player is
	public void shoot(String space, int bx, int by) {
		ArrayList<Integer>bullets = new ArrayList<Integer>();
		
		//adding original bullet position to the array
		this.bulletList.add(this.bx);
		this.bulletList.add(this.by);
		
		//printing the bullet coordinates
		System.out.println(this.bx + this.by);
		
		//if the user shoots a bullet
		if (this.space.equals("shoot")) {
			int newX = 0;
			//loops thru the bullet array
			for(int bullet : this.bulletList) {
				//updates the coordinates of the bullets, newX is the new coordinate of the bullet
				for(int bulletx = 0; bulletx < bulletList.size(); bulletx++) {
					newX = this.bx+bulletx;
				}
			//adding new coordinates to the array
			bullets.add(newX,this.by);
				}
			
			}
			
				
			}
		

	
	//Getters and Setters
	public int getbX() {
		return bx;
	}
	public void setbX(int bx) {
		this.bx = bx;
	}
	public int getbY() {
		return by;
	}
	public void setbY(int by) {
		this.by = by;
	}

	public ArrayList<Integer> getBulletList() {
		return bulletList;
	}

	public void setBulletList(ArrayList<Integer> bulletList) {
		this.bulletList = bulletList;
	}
}

