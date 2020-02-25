import java.util.Scanner;

public class Main {
	private static char[][] board;
	private static char currentPlayerPosition;
	private static char shootbullet;

    public static void main(String args[]){
        Player tuan = new Player("Razeen");
        Bullet tuanBullet = new Bullet("bullet");
        Scanner input = new Scanner(System.in);
        Scanner bulletIn = new Scanner(System.in);
        String command = "";
        String bcommand = "";          
    	int a = 6;
    	int b = 8;
    	int moveX = 5;
    	int moveY = 0;
    	currentPlayerPosition = 'M';
    	shootbullet = '>';
    	
    	//CREATE INITIAL BOARD
		board = new char[a][b];
    	for (int i = 0; i<a; i++) {
    		for(int j =0;j<b;j++) {
    			board[i][j]='-';
    		}
    	}  
    	//ADD PLAYER
    	board[moveX][moveY] = currentPlayerPosition;
    	
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
    	
          if (command.equalsIgnoreCase("left")) {
        	moveY -= 1;
        	  if (moveY >= 0 && moveY < b) {
        		  board[moveX][moveY] = currentPlayerPosition;
                	board = new char[a][b];
              	for (int i = 0; i<a; i++) {
              		for(int j =0;j<b;j++) {
              			board[i][j]='-';
              		}
              	}                                              
              	board[moveX][moveY] = currentPlayerPosition;
              	
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
        		  System.out.println("out of bounds!");
        		  //moveY += 1;
        	  }        	  	
          }
          
          else if (command.equalsIgnoreCase("right")) {
        	  moveY += 1;
        	  if (moveY >= 0 && moveY < b) {
        		  board[moveX][moveY] = currentPlayerPosition;
              	board = new char[a][b];
              	for (int i = 0; i<a; i++) {
              		for(int j =0;j<b;j++) {
              			board[i][j]='-';
              		}
              	}                                              
              	board[moveX][moveY] = currentPlayerPosition;
              	
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
        		  System.out.println("out of bounds!");
        		  //moveY -= 1;
        	  }         	
          }
          
          else if (command.equalsIgnoreCase("up")) {
        	  moveX -= 1;
        	  if (moveX >= 0 && moveX < b) {
        		  board[moveX][moveY] = currentPlayerPosition;
              	board = new char[a][b];
              	for (int i = 0; i<a; i++) {
              		for(int j =0;j<b;j++) {
              			board[i][j]='-';
              		}
              	}                                              
              	board[moveX][moveY] = currentPlayerPosition;
              	
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
        		  System.out.println("out of bounds!");
        		  //moveX += 1;
        	  }
          	
          }
          
          else {
        	  System.out.println("invalid movement!");
          }
          
    	        while (command != ""){        
    	        	  System.out.println("Please enter left, right or up");
    	              command = input.nextLine();
    	              tuan.move(command);
    	              System.out.println(tuan);
    	        	
    	              if (command.equalsIgnoreCase("left")) {
    	            	moveY -= 1;
    	            	  if (moveY >= 0 && moveY < b) {
    	            		  board[moveX][moveY] = currentPlayerPosition;
    	                    	board = new char[a][b];
    	                  	for (int i = 0; i<a; i++) {
    	                  		for(int j =0;j<b;j++) {
    	                  			board[i][j]='-';
    	                  		}
    	                  	}                                              
    	                  	board[moveX][moveY] = currentPlayerPosition;
    	                  	
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
    	            		  System.out.println("out of bounds!");
    	            		  //moveY += 1;
    	            	  }        	  	
    	              }
    	              
    	              else if (command.equalsIgnoreCase("right")) {
    	            	  moveY += 1;
    	            	  if (moveY >= 0 && moveY < b) {
    	            		  board[moveX][moveY] = currentPlayerPosition;
    	                  	board = new char[a][b];
    	                  	for (int i = 0; i<a; i++) {
    	                  		for(int j =0;j<b;j++) {
    	                  			board[i][j]='-';
    	                  		}
    	                  	}                                              
    	                  	board[moveX][moveY] = currentPlayerPosition;
    	                  	
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
    	            		  System.out.println("out of bounds!");
    	            		  //moveY -= 1;
    	            	  }         	
    	              }
    	              
    	              else if (command.equalsIgnoreCase("up")) {
    	            	  moveX -= 1;
    	            	  if (moveX >= 0 && moveX < b) {
    	            		  board[moveX][moveY] = currentPlayerPosition;
    	                  	board = new char[a][b];
    	                  	for (int i = 0; i<a; i++) {
    	                  		for(int j =0;j<b;j++) {
    	                  			board[i][j]='-';
    	                  		}
    	                  	}                                              
    	                  	board[moveX][moveY] = currentPlayerPosition;
    	                  	
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
    	            		  System.out.println("out of bounds!");
    	            		  //moveX += 1;
    	            	  }
    	              	
    	              }
    	              else {
    	            	  System.out.println("invalid movement!");
    	              }
    	              
    	            tuanBullet.setBullet(tuan.getX(), tuan.getY());
    	            
    	            System.out.println("please enter shoot to shoot");
    	            bcommand = input.nextLine();
    	            
    	            if (bcommand.equalsIgnoreCase("shoot")) {
    	            	tuanBullet.shoot(bcommand, tuan.getX(), tuan.getY());
    	            	System.out.println("bullet position is " + tuanBullet.getBulletList() );
    				
    				
//    	            	for (int bullet = moveY; bullet < b; bullet++) {
//    	            		board[moveX][bullet] = shootbullet;
//    	            		board = new char[a][b];
//    	                  	for (int i = 0; i<a; i++) {
//    	                  		for(int j =0;j<b;j++) {
//    	                  			board[i][j]='-';
//    	                  	}
//    	                  	}                 
//    	                  	board[moveX][moveY] = currentPlayerPosition;
//    	                  	board[moveX][bullet] = shootbullet;
//    	                  	
//    	                  		System.out.println("---------------------------------");
//    	                  		for (int i=0;i<a;i++) {
//    	                  			System.out.print("| ");    			
//    	                  			for (int j = 0; j<b;j++) {
//    	                  				System.out.print(board[i][j]+ " | ");
//    	                  			}   			
//    	                  			System.out.println();
//    	                  			System.out.println("---------------------------------");
//    	                  		}
//    	            	}
    				}
    	            else {
    	            	System.out.println("that's not how you spell shoot! try again later");
    	            }
    	        }
    	        input.close();
    }
}


