import java.util.ArrayList;

public class Bullet {
	private static final int WIDTH = 600;
	private int bx;
	private int by;
	private String space;
	private ArrayList<Integer>bulletList;
	
	public Bullet(String space) {
		this.space = space;
		this.bulletList = new ArrayList<Integer>();
	}
	
	public void setBullet(int bx, int by) {
		this.bx = bx;
		this.by = by;
	}
	
	public ArrayList<Integer>getBullet(){
		ArrayList<Integer>bullets = new ArrayList<Integer>();
		
		if (this.space.equals("shoot")) {
			bullets.add(bx,by);
		}
		
	}
	
	public void shoot(String space) {
		if(space.equals("shoot")) {			
			this.setBullet(this.bx, this.by);
			int newX = 0;
			for(int b = this.bx; b < WIDTH; b+=10) {
				newX = this.bx+b;
				this.setBullet(newX, this.by);
			}
			
			
			System.out.println("bullet position is " + newX + " " + this.by);
		}
	}

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
	
	

}
