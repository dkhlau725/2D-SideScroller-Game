package game;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.geometry.Dimension2D;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import Super.Enemy0;
import Super.Player;
import Super.Super;
import key.KeyboardInput;

public class Main extends Application {
	
	public static final int WIDTH = 270;
	public static final int HEIGHT = WIDTH / 14 * 10;
	public static final int SCALE = 4;
	public Handler handler;
	public KeyboardInput key;
	public Player player;
	public Canvas canvas;
	public Enemy0 enemy0;
	
	 public void start(Stage stage) {
		  try {	        	
			  Group root = new Group();
		      Scene scene = new Scene(root, frameWidth(), frameHeight(), Color.BLACK);
		      this.canvas = new Canvas(frameWidth(), frameHeight());
		      stage.setScene(scene);
		      root.getChildren().add(canvas);
		      
		      handler = new Handler();
		      
		      this.player = new Player(300, 615, 64, 64, true, ID.player, handler);
		      handler.addSuper(player);
		      
		      this.enemy0 = new Enemy0(500, 615, 55, 55, true, ID.Enemy0, handler);
		      handler.addEnemy0(enemy0);
		      
		      key = new KeyboardInput();
		      canvas.getScene().setOnKeyPressed(event -> key.keyPressed(event, handler));
		      canvas.getScene().setOnKeyReleased(event -> key.keyReleased(event, handler));
		      
		      // create new timeline 
		      //add keyframe of 20ms
		        Timeline gameLoop = new Timeline();
		        gameLoop.setCycleCount(Timeline.INDEFINITE);
		        if(handler.player.size() == 0) {
		        	  System.out.println("tuan");
			    	  gameLoop.stop();
			      }

		      
		        KeyFrame frame = new KeyFrame(new Duration(20), (event) -> this.render());
		        gameLoop.getKeyFrames().add(frame);
		        gameLoop.play();
			  
		      
		      stage.setTitle("scrolling shooting game");
		      stage.show();
		      
		      
		  }
		  catch (Exception e) {
	            e.printStackTrace();
	        }
	 }
	 
	 public static int frameWidth() {
			return WIDTH * SCALE;
		}

	public static int frameHeight() {
			return HEIGHT * SCALE;
		}

	public void render() {
		GraphicsContext context = this.canvas.getGraphicsContext2D();
		context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		if (handler.player.size() != 0) {
		for (int i = 0; i < handler.player.size(); i++) {
			Super play = handler.player.get(i);
			context.setFill(Color.RED);
			context.fillRect(play.getX(), play.getY(), 64, 64);	
			update();
			}
		}
		
		for (int e = 0; e < handler.enemy0.size(); e++) {
			Enemy0 en = handler.enemy0.get(e);
			context.setFill(Color.GREEN);
			context.fillRect(en.getEnemyX(), en.getEnemyY(), 64, 64);
			update();   	
			}
	}
	
	
	public void update() {
        this.handler.update();
	}
	
	 public static void main(String args[]) {
		 launch(args);
	 }
}
