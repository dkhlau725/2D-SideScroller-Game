import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static char[][] board;
	private static char currentPlayerPosition;
	private static char currentEnemyPosition;

    public static void main(String args[]){
        Player tuan = new Player("Razeen");
        Bullet tuanBullet = new Bullet("bullet");
        Scanner input = new Scanner(System.in);
        Scanner bulletIn = new Scanner(System.in);
        Enemy enemy = new Enemy("enemy0");
        Enemy enemy1 = new Enemy("enemy1");
        Enemy enemy2 = new Enemy("enemy2");
        String command = "";
        String bcommand = "";          
    	int a = 6;
    	int b = 8;
    	int moveX = 5;
    	int moveY = 0;
    	int enemyXpos = enemy.getEnemyX();
    	int enemyYpos = enemy.getEnemyY();
    	int enemy1Xpos = enemy1.getEnemy1X();
    	int enemy1Ypos = enemy1.getEnemy1Y();
    	int enemy2Xpos = enemy.getEnemy2X();
    	int enemy2Ypos = enemy.getEnemy2Y();
    	Main test = new Main();
    	
    	List<Integer> enemyMovesX = new ArrayList<>(); 
    	enemyMovesX.add(enemyXpos);
    	enemyMovesX.add(enemyXpos + 1);
    	enemyMovesX.add(enemyXpos - 1);
    	
     	List<Integer> enemyMovesY = new ArrayList<>(); 
     	enemyMovesY.add(enemyYpos);
    	enemyMovesY.add(enemyYpos + 1);
    	enemyMovesY.add(enemyYpos - 1);
    	
     	List<Integer> enemy1MovesX = new ArrayList<>();
       	enemy1MovesX.add(enemy1Xpos);
    	enemy1MovesX.add(enemy1Xpos + 1);
    	enemy1MovesX.add(enemy1Xpos - 1);
    	
     	List<Integer> enemy1MovesY = new ArrayList<>(); 
       	enemy1MovesY.add(enemy1Ypos);
    	enemy1MovesY.add(enemy1Ypos + 1);
    	enemy1MovesY.add(enemy1Ypos - 1);
    	
     	List<Integer> enemy2MovesX = new ArrayList<>();
       	enemy2MovesX.add(enemy2Xpos);
    	enemy2MovesX.add(enemy2Xpos + 1);
    	enemy2MovesX.add(enemy2Xpos - 1);
    	
     	List<Integer> enemy2MovesY = new ArrayList<>(); 
       	enemy2MovesY.add(enemy2Ypos);
    	enemy2MovesY.add(enemy2Ypos + 1);
    	enemy2MovesY.add(enemy2Ypos - 1);
    	
    	
    	
		board = new char[a][b];
    	currentPlayerPosition = 'M';
    	currentEnemyPosition = 'E';
    	for(int i = 0; i<a; i++) {
    		for(int j =0;j<b;j++) {
    			board[i][j]='-';
    		}
    	}                                              
    	board[moveX][moveY] = currentPlayerPosition;
    	board[enemyXpos][enemyYpos] = currentEnemyPosition;
    	board[enemy1Xpos][enemy1Ypos] = currentEnemyPosition;
    	board[enemy2Xpos][enemy2Ypos] = currentEnemyPosition;
  
    	
    		System.out.println("---------------------------------");
    		for (int i=0;i<a;i++) {
    			System.out.print("| ");    			
    			for (int j = 0; j<b;j++) {
    				System.out.print(board[i][j]+ " | ");
    			}   			
    			System.out.println();
    			System.out.println("---------------------------------");
    		}
    		
          System.out.println("Please enter left, right or up");
          command = input.nextLine();
          tuan.move(command);
          System.out.println(tuan);
    	
          if (command.equals("left")) {  	
        	  moveY -= 1;
          		if (moveY >=0 && moveY < 8) {
		          	board[moveX][moveY] = currentPlayerPosition;
		        	board[test.getRandomElement(enemyMovesX)][test.getRandomElement(enemyMovesY)] = currentEnemyPosition;
		        	board[test.getRandomElement(enemy1MovesX)][test.getRandomElement(enemy1MovesY)] = currentEnemyPosition;
		        	board[test.getRandomElement(enemy2MovesX)][test.getRandomElement(enemy2MovesY)] = currentEnemyPosition;
		        	
		          	board = new char[a][b];
		        	currentPlayerPosition = 'M';
		        	currentEnemyPosition = 'E';
		        	for (int i = 0; i<a; i++) {
		        		for(int j =0;j<b;j++) {
		        			board[i][j]='-';
		        		}
		        	}                                              
		        	board[moveX][moveY] = currentPlayerPosition;
		        	board[test.getRandomElement(enemyMovesX)][test.getRandomElement(enemyMovesY)] = currentEnemyPosition;
		        	board[test.getRandomElement(enemy1MovesX)][test.getRandomElement(enemy1MovesY)] = currentEnemyPosition;
		        	board[test.getRandomElement(enemy2MovesX)][test.getRandomElement(enemy2MovesY)] = currentEnemyPosition;
		        	
		        		System.out.println("---------------------------------");
		        		for (int i=0;i<a;i++) {
		        			System.out.print("| ");    			
		        			for (int j = 0; j<b;j++) {
		        				System.out.print(board[i][j]+ " | ");
		        			}   			
		        			System.out.println();
		        			System.out.println("---------------------------------");
		        		}
          		}
            else {
          	  System.out.println("out of bounds");
          }
        
          }
          
          if (command.equals("right")) {        	
//        	  System.out.println(enemyMoves);
//        	  System.out.println(enemy1Moves);
//        	  System.out.println(enemy2Moves);
        	  
        		  moveY += 1;
        	 if (moveY >=0 && moveY < 8) {
        		  board[moveX][moveY] = currentPlayerPosition;
        		  try {
		        	board[test.getRandomElement(enemyMovesX)][test.getRandomElement(enemyMovesY)] = currentEnemyPosition;
		        	board[test.getRandomElement(enemy1MovesX)][test.getRandomElement(enemy1MovesY)] = currentEnemyPosition;
		        	board[test.getRandomElement(enemy2MovesX)][test.getRandomElement(enemy2MovesY)] = currentEnemyPosition;
        		  }
        		 catch(Exception g){
        			 System.out.println("enemy off");
        		 }
        		  board = new char[a][b];
        		  currentPlayerPosition = 'M';
        		  currentEnemyPosition = 'E';
        		  for (int i = 0; i<a; i++) {
        			  for(int j =0;j<b;j++) {
        				  board[i][j]='-';
        			  	}
        		  }                                              
        		  board[moveX][moveY] = currentPlayerPosition;
        		  try {
		        	board[test.getRandomElement(enemyMovesX)][test.getRandomElement(enemyMovesY)] = currentEnemyPosition;
		        	board[test.getRandomElement(enemy1MovesX)][test.getRandomElement(enemy1MovesY)] = currentEnemyPosition;
		        	board[test.getRandomElement(enemy2MovesX)][test.getRandomElement(enemy2MovesY)] = currentEnemyPosition;
        		  }
         		 catch(Exception g){
        			 System.out.println("enemy off");
        		 }
        		  System.out.println("---------------------------------");
        		  for (int i=0;i<a;i++) {
        			System.out.print("| ");    			
        			for (int j = 0; j<b;j++) {
        				System.out.print(board[i][j]+ " | ");
        				}   			
        			System.out.println();
        			System.out.println("---------------------------------");
        		  	}
        	  	}
        	  else {
        		  System.out.println("out of bounds");
        	  }
          }
          
          if (command.equals("up")) {
          	moveX -= 1;      
          	if (moveX >=0 && moveX < 6) {
	          	board[moveX][moveY] = currentPlayerPosition;
	          	try {
	        	board[test.getRandomElement(enemyMovesX)][test.getRandomElement(enemyMovesY)] = currentEnemyPosition;
	        	board[test.getRandomElement(enemy1MovesX)][test.getRandomElement(enemy1MovesY)] = currentEnemyPosition;
	        	board[test.getRandomElement(enemy2MovesX)][test.getRandomElement(enemy2MovesY)] = currentEnemyPosition;
	          	}
       		 catch(Exception g){
    			 System.out.println("enemy off");
    		 }
	        	board = new char[a][b];
	        	currentPlayerPosition = 'M';
	        	currentEnemyPosition = 'E';
	        	for (int i = 0; i<a; i++) {
	        		for(int j =0;j<b;j++) {
	        			board[i][j]='-';
	        		}
	        	}     
	        	try {
	        	board[moveX][moveY] = currentPlayerPosition;
	        	board[test.getRandomElement(enemyMovesX)][test.getRandomElement(enemyMovesY)] = currentEnemyPosition;
	        	board[test.getRandomElement(enemy1MovesX)][test.getRandomElement(enemy1MovesY)] = currentEnemyPosition;
	        	board[test.getRandomElement(enemy2MovesX)][test.getRandomElement(enemy2MovesY)] = currentEnemyPosition;
	          	}
	       		 catch(Exception g){
	    			 System.out.println("enemy off");
	    		 }
	        		System.out.println("---------------------------------");
	        		for (int i=0;i<a;i++) {
	        			System.out.print("| ");    			
	        			for (int j = 0; j<b;j++) {
	        				System.out.print(board[i][j]+ " | ");
	        			}   			
	        			System.out.println();
	        			System.out.println("---------------------------------");
	        		}
          	}
          	else {
          		System.out.println("out of bounds");
          		
          	}
          }
          
    	        while (command != ""){        
    	            System.out.println("Please enter left, right, or up");  
    	            command = input.nextLine();
    	            tuan.move(command);
    	            System.out.println(tuan);
    	            
    	            if (command.equals("left")) {  	 	            	
    	            	moveY -= 1;
    	            	if(moveY >= 0 && moveY < 8) {
    	            	board[moveX][moveY] = currentPlayerPosition;
    	            	try {
    		        	board[test.getRandomElement(enemyMovesX)][test.getRandomElement(enemyMovesY)] = currentEnemyPosition;
    		        	board[test.getRandomElement(enemy1MovesX)][test.getRandomElement(enemy1MovesY)] = currentEnemyPosition;
    		        	board[test.getRandomElement(enemy2MovesX)][test.getRandomElement(enemy2MovesY)] = currentEnemyPosition;
    	              	}
    	          		 catch(Exception g){
    	       			 System.out.println("enemy off");
    	       		 }
    	            	board = new char[a][b];
    	            	currentPlayerPosition = 'M';
    	            	currentEnemyPosition = 'E';
    	            	for (int i = 0; i<a; i++) {
    	            		for(int j =0;j<b;j++) {
    	            			board[i][j]='-';
    	            	}
    	            	}                                              
    	            	board[moveX][moveY] = currentPlayerPosition;
    	            	try {
    		        	board[test.getRandomElement(enemyMovesX)][test.getRandomElement(enemyMovesY)] = currentEnemyPosition;
    		        	board[test.getRandomElement(enemy1MovesX)][test.getRandomElement(enemy1MovesY)] = currentEnemyPosition;
    		        	board[test.getRandomElement(enemy2MovesX)][test.getRandomElement(enemy2MovesY)] = currentEnemyPosition;
    	              	}
    	          		 catch(Exception g){
    	       			 System.out.println("enemy off");
    	       		 }
    	            		System.out.println("---------------------------------");
    	            		for (int i=0;i<a;i++) {
    	            			System.out.print("| ");    			
    	            			for (int j = 0; j<b;j++) {
    	            				System.out.print(board[i][j]+ " | ");
    	            			}   			
    	            			System.out.println();
    	            			System.out.println("---------------------------------");
    	            		}
    	            	}
    	            	else {
    	            		System.out.println("out of bounds");
    	            	}
    	            }
    	            
    	            if (command.equals("right")) {
    	            	moveY += 1;
    	            	if (moveY >= 0 && moveY < 8) {
    	            	board[moveX][moveY] = currentPlayerPosition;
    	            	try {
    		        	board[test.getRandomElement(enemyMovesX)][test.getRandomElement(enemyMovesY)] = currentEnemyPosition;
    		        	board[test.getRandomElement(enemy1MovesX)][test.getRandomElement(enemy1MovesY)] = currentEnemyPosition;
    		        	board[test.getRandomElement(enemy2MovesX)][test.getRandomElement(enemy2MovesY)] = currentEnemyPosition;
    	              	}
    	          		 catch(Exception g){
    	       			 System.out.println("enemy off");
    	       		 }
    	            	board = new char[a][b];
    	            	currentPlayerPosition = 'M';
    	            	currentEnemyPosition = 'E';
    	            	for (int i = 0; i<a; i++) {
    	            		for(int j =0;j<b;j++) {
    	            			board[i][j]='-';
    	            	}
    	            	}                                              
    	            	board[moveX][moveY] = currentPlayerPosition;
    	            	try {
    		        	board[test.getRandomElement(enemyMovesX)][test.getRandomElement(enemyMovesY)] = currentEnemyPosition;
    		        	board[test.getRandomElement(enemy1MovesX)][test.getRandomElement(enemy1MovesY)] = currentEnemyPosition;
    		        	board[test.getRandomElement(enemy2MovesX)][test.getRandomElement(enemy2MovesY)] = currentEnemyPosition;
    	              	}
    	          		 catch(Exception g){
    	       			 System.out.println("enemy off");
    	       		 }
    	            		System.out.println("---------------------------------");
    	            		for (int i=0;i<a;i++) {
    	            			System.out.print("| ");    			
    	            			for (int j = 0; j<b;j++) {
    	            				System.out.print(board[i][j]+ " | ");
    	            			}   			
    	            			System.out.println();
    	            			System.out.println("---------------------------------");
    	            		}
    	            	}
    	            	else {
    	            		System.out.println("out of bounds");
    	            	}
    	            
    	            }
    	            if (command.equals("up")) {
    	            	moveX -= 1;
    	            	if(moveX >= 0 && moveX < 6) {
    	            	board[moveX][moveY] = currentPlayerPosition;
    	            	try {
    		        	board[test.getRandomElement(enemyMovesX)][test.getRandomElement(enemyMovesY)] = currentEnemyPosition;
    		        	board[test.getRandomElement(enemy1MovesX)][test.getRandomElement(enemy1MovesY)] = currentEnemyPosition;
    		        	board[test.getRandomElement(enemy2MovesX)][test.getRandomElement(enemy2MovesY)] = currentEnemyPosition;
    	              	}
    	          		 catch(Exception g){
    	       			 System.out.println("enemy off");
    	       		 }
    	            	board = new char[a][b];
    	            	currentPlayerPosition = 'M';
    	            	currentEnemyPosition = 'E';
    	            	for (int i = 0; i<a; i++) {
    	            		for(int j =0;j<b;j++) {
    	            			board[i][j]='-';
    	            	}
    	            	}                                              
    	            	board[moveX][moveY] = currentPlayerPosition;
    	            	try {
    		        	board[test.getRandomElement(enemyMovesX)][test.getRandomElement(enemyMovesY)] = currentEnemyPosition;
    		        	board[test.getRandomElement(enemy1MovesX)][test.getRandomElement(enemy1MovesY)] = currentEnemyPosition;
    		        	board[test.getRandomElement(enemy2MovesX)][test.getRandomElement(enemy2MovesY)] = currentEnemyPosition;
    	              	}
    	          		 catch(Exception g){
    	       			 System.out.println("enemy off");
    	       		 }
    	            		System.out.println("---------------------------------");
    	            		for (int i=0;i<a;i++) {
    	            			System.out.print("| ");    			
    	            			for (int j = 0; j<b;j++) {
    	            				System.out.print(board[i][j]+ " | ");
    	            			}   			
    	            			System.out.println();
    	            			System.out.println("---------------------------------");
    	            		}
    	            	}
    	            	else {
    	            		System.out.println("out of bounds");
    	            	}
    	            }
    	        
    	            tuanBullet.setBullet(tuan.getX(), tuan.getY());
    	            
    	            System.out.println("please enter shoot to shoot");
    	            bcommand = input.nextLine();
    	            if (bcommand.equals("shoot")) {
    	            tuanBullet.shoot(bcommand, tuan.getX(), tuan.getY());
    				System.out.println("bullet position is " + tuanBullet.getBulletList() );
    	            }
    	            else {
    	            	System.out.println("u no shoot");
    	            }
    	        }
    	        //input.close();


    }
    
	public int getRandomElement(List<Integer> list) 
    { 
        Random rand = new Random(); 
        return list.get(rand.nextInt(list.size())); 
    } 

}

