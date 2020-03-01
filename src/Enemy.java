
import java.lang.Math;



public class Enemy {

	

    //enemy x,y position

    private int x=4,y=5;

    //enemy1 x,y position
    
    private int x1=2,y1=2;
    
    //enemy2 x,y position
    
    private int x2=1,y2=6;
    

    //bullet that hits the enemy TODO 

    private Bullet bullet;

    

    //private int position;

    

    //health of the enemy

    private int hp = 100;

    //health of enemy1
    
    private int hp1 = 100;
    
    //health of enemy 2
    
    private int hp2 = 100;

    //creating the enemy

    private String enemy;

    

    //number of enemies alive TODO print number of enemies in console

    private int enemies = 1;



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

    public int EnemyHp(int hp) {

        hp = this.hp;

        return hp;

    }
    
    public int Enemy1Hp(int hp) {

        hp = this.hp1;

        return hp;

    }
    
    public int Enemy2Hp(int hp) {

        hp = this.hp2;

        return hp;

    }

    

    //reducing enemy hp each time bullet hits the enemy 

    public void reduceEnemyHp(int by, int hp)

    {

    	// if bullet is on the same y-level as enemy then enemy takes damage 

        if(by == this.y) 

        {

            EnemyHp(hp - 1);

        }

    }

    

    // checks if enemy is dead

    public boolean enemyIsDead()

    {

    	// if no enemies died then return false and nothing happens

    	if (EnemyHp(hp) != 0) {

    		return false;

    

    	// if enemy is dead the amount of enemies left on the level is reduced by 1

    	}else{

    		enemies -= 1;

    		System.out.println("number of enemies alive " + enemies);

    		return true;

    	}

    }

    

    //moves an enemy to a starting position not too close to player spawn point TODO add random movement (left, right)

    public int initialPositionOfEnemy(int x, int y)

    {

    	return this.x & this.y;
    }
    
    public int initialPositionOfEnemy1(int x, int y)

    {

    	return this.x1 & this.y1;
    }
    public int initialPositionOfEnemy2(int x, int y)

    {

    	return this.x2 & this.y2;
    }
    
    
 
    //Moving the enemies (not implemented yet)

    	//for the purpose of demo 1 

    	 /* int max = 7;
          * int min = 4;
    	  *return position = setEnemyPos((int)Math.random() * (max - min + 1) + min,(int) Math.random() * (max - min + 1) + min);
    	  */

    

    

    // creates 1 enemy with 1 health-point at a position (4,2) - used for testing purposes

    public void enemy1() {

    	this.hp = EnemyHp(1);

        initialPositionOfEnemy(4, 2);

        while (enemyIsDead() == false) 

    	{

        	System.out.println("enemy is at " + this.x+","+this.y+"enemy1 hp is" + this.hp);

    	}

    }
    

     // gets x of the enemy (does not do anything yet)

     public int getEnemyX() {

            return x;

        }

     // changes enemy's x position (does not do anything yet)

     public void setEnemyX(int x) {

            this.x = x;

        }

     

     // gets y of the enemy (does not do anything yet)

     public int getEnemyY() {

          return y;

        }

     // changes enemy's y position (does not do anything yet)

     public void setEnemyY(int y) {

            this.y = y;

        }
     public int getEnemy1X() {

         return x1;

     }

  // changes enemy's x position (does not do anything yet)

  public void setEnemy1X(int x) {

         this.x1 = x;

     }

  

  // gets y of the enemy (does not do anything yet)

  public int getEnemy1Y() {

       return y1;

     }

  // changes enemy's y position (does not do anything yet)

  public void setEnemy1Y(int y) {

         this.y1 = y;

     }
  public int getEnemy2X() {

      return x2;

  }

// changes enemy's x position (does not do anything yet)

public void setEnemy2X(int x) {

      this.x2 = x;

  }



// gets y of the enemy (does not do anything yet)

public int getEnemy2Y() {

    return y2;

  }

// changes enemy's y position (does not do anything yet)

public void setEnemy2Y(int y) {

      this.y2 = y;

  }
}
