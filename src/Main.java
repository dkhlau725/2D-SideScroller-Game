import java.util.Scanner;

public class Main {
	//decalring private varaible
	private static char[][] board;
	private static char currentPlayerPosition;
	private static char shootbullet;

    public static void main(String args[]){
	//initalizing classes
        Player tuan = new Player("Razeen");
        Bullet tuanBullet = new Bullet("bullet");
	//implementing scanner
        Scanner input = new Scanner(System.in);
        Scanner bulletIn = new Scanner(System.in);
	    
	//varaibles
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
	//Note: the board is just for the demo, so the movements are easier to visilize
	//Actual game will not have a board
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
    	  //getting user input
          System.out.println("Please enter left, right or up");
          command = input.nextLine();
          tuan.move(command);
          System.out.println(tuan);
    	
	  //if user enters left
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
              		//redrawing the board
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
          
	  //if user enters right
          else if (command.equalsIgnoreCase("right")) {
        	  moveY += 1;
		  //redrawing the board
        	  if (moveY >= 0 && moveY < b) {
        		  board[moveX][moveY] = currentPlayerPosition;
              	board = new char[a][b];
              	for (int i = 0; i<a; i++) {
              		for(int j =0;j<b;j++) {
              			board[i][j]='-';
              		}
              	}                                              
              	board[moveX][moveY] = currentPlayerPosition;
              		//redrawing board
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
          
	  //if the user enters up
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
              		//redrawing the board
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
          
	  //if an invalid input is entered
          else {
        	  System.out.println("invalid movement!");
          }
          
	    //if user enters blank input the game exits
    	        while (command != ""){        
		      //getting user input
    	              System.out.println("Please enter left, right or up");
    	              command = input.nextLine();
    	              tuan.move(command);
    	              System.out.println(tuan);
    	        	
		      //when the user enters left
    	              if (command.equalsIgnoreCase("left")) {
    	            	moveY -= 1;
			  //position on board gets updated
			  //checks to see if the move is on the board/screen
    	            	  if (moveY >= 0 && moveY < b) {
    	            		  board[moveX][moveY] = currentPlayerPosition;
    	                    	board = new char[a][b];
    	                  	for (int i = 0; i<a; i++) {
    	                  		for(int j =0;j<b;j++) {
    	                  			board[i][j]='-';
    	                  		}
    	                  	}     
				//updated position
    	                  	board[moveX][moveY] = currentPlayerPosition;
    	                  		//redraw the board
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
			  //when move is out of bounds
    	            	  else {
    	            		  System.out.println("out of bounds!");
    	            		  //moveY += 1;
    	            	  }        	  	
    	              }
    	              
		      //if the user enters right
    	              else if (command.equalsIgnoreCase("right")) {
    	            	  moveY += 1;
			  //checking to see if the move is in the boundries
    	            	  if (moveY >= 0 && moveY < b) {
    	            		  board[moveX][moveY] = currentPlayerPosition;
    	                  	board = new char[a][b];
    	                  	for (int i = 0; i<a; i++) {
    	                  		for(int j =0;j<b;j++) {
    	                  			board[i][j]='-';
    	                  		}
    	                  	}  
				//updated position
    	                  	board[moveX][moveY] = currentPlayerPosition;
    	                  		//redrawing the board
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
			  //if the move is out of bounds 
    	            	  else {
    	            		  System.out.println("out of bounds!");
    	            		  //moveY -= 1;
    	            	  }         	
    	              }
    	              
		      //if the user enters up
    	              else if (command.equalsIgnoreCase("up")) {
    	            	  moveX -= 1;
			  //checking to see if the move is in the boundries
    	            	  if (moveX >= 0 && moveX < b) {
    	            		  board[moveX][moveY] = currentPlayerPosition;
    	                  	board = new char[a][b];
    	                  	for (int i = 0; i<a; i++) {
    	                  		for(int j =0;j<b;j++) {
    	                  			board[i][j]='-';
    	                  		}
    	                  	}                            
				//updated position
    	                  	board[moveX][moveY] = currentPlayerPosition;
    	                  		//redrawing the board
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
			  //the move is out of bounds
    	            	  else {      	
    	            		  System.out.println("out of bounds!");
    	            		  //moveX += 1;
    	            	  }
    	              	
    	              }
		      //if the user enters an invalid input
    	              else {
    	            	  System.out.println("invalid movement!");
    	              }
    	            //bullet class
    	            tuanBullet.setBullet(tuan.getX(), tuan.getY());
    	            
		    //getting user input
    	            System.out.println("please enter shoot to shoot");
    	            bcommand = input.nextLine();
    	            
		    //if the user enters shoot
    	            if (bcommand.equalsIgnoreCase("shoot")) {
			//calls the bullet class 
    	            	tuanBullet.shoot(bcommand, tuan.getX(), tuan.getY());
			//displying results
    	            	System.out.println("bullet position is " + tuanBullet.getBulletList() );
    				
    				
    				}
		    //invalid entery
    	            else {
    	            	System.out.println("that's not how you spell shoot! try again later");
    	            }
    	        }
	        //closing the program
    	        input.close();
    }
}


