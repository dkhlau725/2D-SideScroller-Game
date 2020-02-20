public class Player{
    private int x;
    private int y;
    private String name;
    private String input;

    public Player(String name){
        this.name = name;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;    

    }
    public void setInput (String input){
        this.input = input;
    }

    public void move(String input){

        if(input.equals("up")) {
            this.setPosition(this.x, this.y - 50);
        }
        else if(input.equals("right")){
            this.setPosition(this.x+50,this.y);
        }
        else if (input.equals("left")){
            this.setPosition(this.x-50, this.y);

        }
    }
    

    public String toString(){
        return new String(this.name + " is at " + this.x+","+this.y);
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
