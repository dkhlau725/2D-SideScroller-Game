/Tuan
Desmond
	/

import java.util.Scanner;

public class Main {
	private static char[][] board;
	private static char currentPlayerPosition;

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
    	
		board = new char[a][b];
    	currentPlayerPosition = 'M';
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
    		
          System.out.println("Please enter left, right or up");
          command = input.nextLine();
          tuan.move(command);
          System.out.println(tuan);
    	
          if (command.equals("left")) {  	            	
          	moveY -= 1;
          	board[moveX][moveY] = currentPlayerPosition;
          	board = new char[a][b];
        	currentPlayerPosition = 'M';
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
          if (command.equals("right")) {
          	moveY += 1;
          	board[moveX][moveY] = currentPlayerPosition;
        	board = new char[a][b];
        	currentPlayerPosition = 'M';
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
          if (command.equals("up")) {
          	moveX -= 1;        	
          	board[moveX][moveY] = currentPlayerPosition;
        	board = new char[a][b];
        	currentPlayerPosition = 'M';
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
          
    	        while (command != ""){        
    	            System.out.println("Please enter left, right, or up");  
    	            command = input.nextLine();
    	            tuan.move(command);
    	            System.out.println(tuan);
    	            
    	            if (command.equals("left")) {  	            	
    	            	moveY -= 1;
    	            	board[moveX][moveY] = currentPlayerPosition;
    	            	board = new char[a][b];
    	            	currentPlayerPosition = 'M';
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
    	            if (command.equals("right")) {
    	            	moveY += 1;
    	            	board[moveX][moveY] = currentPlayerPosition;
    	            	board = new char[a][b];
    	            	currentPlayerPosition = 'M';
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
    	            if (command.equals("up")) {
    	            	moveX -= 1;
    	            	board[moveX][moveY] = currentPlayerPosition;
    	            	board = new char[a][b];
    	            	currentPlayerPosition = 'M';
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
    	        
    	            tuanBullet.setBullet(tuan.getX(), tuan.getY());
    	            
    	            System.out.println("please enter shoot to shoot");
    	            bcommand = input.nextLine();
    	            tuanBullet.shoot(bcommand, tuan.getX(), tuan.getY());
    				System.out.println("bullet position is " + tuanBullet.getBulletList() );
    	        }
    	        //input.close();
    
    	
    	
    	
    	         
    	
    	      
    	    

    	
    		
    			
    	
    		
    	



//        tuan.setPosition(0,300);
//        tuanBullet.setBullet(tuan.getX() + 5, tuan.getY() - 5);
//        
//
//        System.out.println("Please enter left, right or up");
//        command = input.nextLine();
//        tuan.move(command);
//        System.out.println(tuan);
//       
//       
//
//
//        while (command != ""){        
//            System.out.println("Please enter left, right, or up");  
//            command = input.nextLine();
//            tuan.move(command);
//            System.out.println(tuan);
//            
//            tuanBullet.setBullet(tuan.getX() + 5, tuan.getY() - 5);
//            
//            System.out.println("please enter shoot to shoot");
//            bcommand = input.nextLine();
//            tuanBullet.shoot(bcommand, tuan.getX()+5, tuan.getY()-5);
//			System.out.println("bullet position is " + tuanBullet.getBulletList() );
//        }
//        input.close();
//        
//
//        }
    }
}


