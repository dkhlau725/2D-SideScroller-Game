import java.util.Scanner;

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
          	board[moveX][moveY] = currentPlayerPosition;
        	board[enemyXpos][enemyYpos] = currentEnemyPosition;
        	board[enemy1Xpos][enemy1Ypos] = currentEnemyPosition;
        	board[enemy2Xpos][enemy2Ypos] = currentEnemyPosition;
        	
        	
          	board = new char[a][b];
        	currentPlayerPosition = 'M';
        	currentEnemyPosition = 'E';
        	for (int i = 0; i<a; i++) {
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
          }
          if (command.equals("right")) {
          	moveY += 1;
          	board[moveX][moveY] = currentPlayerPosition;
        	board[enemyXpos][enemyYpos] = currentEnemyPosition;
        	board[enemy1Xpos][enemy1Ypos] = currentEnemyPosition;
        	board[enemy2Xpos][enemy2Ypos] = currentEnemyPosition;
        	
        	
        	board = new char[a][b];
        	currentPlayerPosition = 'M';
        	currentEnemyPosition = 'E';
        	for (int i = 0; i<a; i++) {
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
          }
          if (command.equals("up")) {
          	moveX -= 1;        	
          	board[moveX][moveY] = currentPlayerPosition;
        	board[enemyXpos][enemyYpos] = currentEnemyPosition;
        	board[enemy1Xpos][enemy1Ypos] = currentEnemyPosition;
        	board[enemy2Xpos][enemy2Ypos] = currentEnemyPosition;
        	board = new char[a][b];
        	currentPlayerPosition = 'M';
        	currentEnemyPosition = 'E';
        	for (int i = 0; i<a; i++) {
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
          }
          
    	        while (command != ""){        
    	            System.out.println("Please enter left, right, or up");  
    	            command = input.nextLine();
    	            tuan.move(command);
    	            System.out.println(tuan);
    	            
    	            if (command.equals("left")) {  	            	
    	            	moveY -= 1;
    	            	board[moveX][moveY] = currentPlayerPosition;
    	            	board[enemyXpos][enemyYpos] = currentEnemyPosition;
    	            	board[enemy1Xpos][enemy1Ypos] = currentEnemyPosition;
    	            	board[enemy2Xpos][enemy2Ypos] = currentEnemyPosition;
    	            	board = new char[a][b];
    	            	currentPlayerPosition = 'M';
    	            	currentEnemyPosition = 'E';
    	            	for (int i = 0; i<a; i++) {
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
    	            }
    	            if (command.equals("right")) {
    	            	moveY += 1;
    	            	board[moveX][moveY] = currentPlayerPosition;
    	            	board[enemyXpos][enemyYpos] = currentEnemyPosition;
    	            	board[enemy1Xpos][enemy1Ypos] = currentEnemyPosition;
    	            	board[enemy2Xpos][enemy2Ypos] = currentEnemyPosition;
    	            	board = new char[a][b];
    	            	currentPlayerPosition = 'M';
    	            	currentEnemyPosition = 'E';
    	            	for (int i = 0; i<a; i++) {
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
    	            }
    	            if (command.equals("up")) {
    	            	moveX -= 1;
    	            	board[moveX][moveY] = currentPlayerPosition;
    	            	board[enemyXpos][enemyYpos] = currentEnemyPosition;
    	            	board[enemy1Xpos][enemy1Ypos] = currentEnemyPosition;
    	            	board[enemy2Xpos][enemy2Ypos] = currentEnemyPosition;
    	            	board = new char[a][b];
    	            	currentPlayerPosition = 'M';
    	            	currentEnemyPosition = 'E';
    	            	for (int i = 0; i<a; i++) {
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
    	            }
    	        
    	            tuanBullet.setBullet(tuan.getX(), tuan.getY());
    	            
    	            System.out.println("please enter shoot to shoot");
    	            bcommand = input.nextLine();
    	            tuanBullet.shoot(bcommand, tuan.getX(), tuan.getY());
    				System.out.println("bullet position is " + tuanBullet.getBulletList() );
    	        }
    	        //input.close();
    
    	
    	
    	
    	         
    	
    	      
    	    

    	
    		
    			
    	
    		
    	




    }
}
