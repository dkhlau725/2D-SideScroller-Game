public class Player{
    // decalring private varabiles
    private int x;
    private int y;
    private String name;
    private String input;
   
    //constructor
    public Player(String name){
        this.name = name;
    }

    //setting x and y position
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;    

    }
	
    //setting the input 
    public void setInput (String input){
        this.input = input;
    }

    //movements
    public void move(String input){
	
	//if the user goes up
        if(input.equals("up")) {
	    //updated coordinates
            this.setPosition(this.x, this.y - 1);
            
        }
	//if the user goes right
        else if(input.equals("right")){
	    //updated coordinates
            this.setPosition(this.x+1,this.y);
            
        }
	//if the user goes left
        else if (input.equals("left")){
	    //updated coordinates
            this.setPosition(this.x-1, this.y);

        }
    }
    

    //displays resulting coordinat
    public String toString(){
        return new String(this.name + " is at " + this.x+","+this.y);
    }

	//setters and getters
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
