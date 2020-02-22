
public class Enemy {
	
    //enemy x position
    private int x;

    //enemy y position
    private int y;

    //bullet that hits the enemy
    //private Bullet bullet;

    //health of the enemy
    private int hp;

    //creating the enemy
    private String enemy;
    
    //number of enemies alive TODO print number of enemies in console
    public int enemies = 2;

    public Enemy(String enemy) {
    	this.enemy = enemy;
    }
    
   
    //setting an enemy's position on the map
    public void setEnemyPos(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("the enemies position is"+ ""+ x+ ""+ y);
    }
    
    //setting the enemy's health to 100
    public int setEnemyHp(int hp) {
        hp = this.hp;
        hp = 100;
        return hp;
    }
    
    //reducing enemy hp by 25 each time bullet hits the enemy
    public void reduceEnemyHp(int bx, int by, int hp)
    {
        if(bx == this.x && by == this.y) 
        {
            setEnemyHp(hp - 25);
        }
    }
    
    public void enemy1() {
    	hp = setEnemyHp(50);
    	System.out.println("enemy1 hp is" + this.hp);
    }
    //constantly moves enemies in small squares while they are alive (hp != 0) TODO switch to random movement
    public void moveEnemy() 
    {
        while (setEnemyHp(hp) != 0) 
        {
        setEnemyPos(x+5, y);
        setEnemyPos(x,y-5);
        setEnemyPos(x-5, y);
        setEnemyPos(x,y+5);
        }
    }
     public String toString()
         {
            return new String(this.enemy + " is at " + this.x+","+this.y);
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
