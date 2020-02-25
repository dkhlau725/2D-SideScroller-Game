import java.util.ArrayList;
//Shooting the bullet
//Desmond and Muhammad and Tuan
public class Bullet {
	private static final int WIDTH = 400;
	private int bx;
	private int by;
	private String space;
	private ArrayList<Integer>bulletList;
	
	
	//constructor
	public Bullet(String space) {
		this.space = space;
		this.bulletList = new ArrayList<Integer>();
	}
	
	public void setBullet(int bx, int by) {
		this.bx = bx;
		this.by = by;
	}
	

	//updating the array, adding x and y for each bullet fired
	//updating x and y depending on where the player is
	public void shoot(String space, int bx, int by) {
		ArrayList<Integer>bullets = new ArrayList<Integer>();

		this.bulletList.add(this.bx);
		this.bulletList.add(this.by);
		System.out.println(this.bx + this.by);
		
		if (this.space.equals("shoot")) {
			int newX = 0;
			for(int bullet : this.bulletList) {
				for(int bulletx = 0; bulletx < bulletList.size(); bulletx++) {
					newX = this.bx+bulletx;
				}
		
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

