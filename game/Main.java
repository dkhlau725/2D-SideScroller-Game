package game;

import java.awt.Canvas; // allow  to display with our frame
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame; //library to create a window :) 

import Super.Enemy;
import Super.Player;
import Super.Super;
import graphics.Menu;
import graphics.Sprite;
import graphics.SpriteSheet;
import key.KeyboardInput;
import key.MouseInput;

public class Main extends Canvas implements Runnable {
	// set screen resolution as 800x600 and the scale as 3 :) name of the game will
	// be decided later so let set it random
	public static final int WIDTH = 270;
	public static final int HEIGHT = WIDTH / 14 * 10;
	public static final int SCALE = 4;
	public static final String name = "Scrolling Shooting Game"; // title of the game
	private Thread thread;
	public static boolean rungame = false; // boolean to run game the game
	public static Handler handler;
	public static Camera cam;
	public static KeyboardInput key;
	public static MouseInput mouse;
	public static Menu menu;
	public static Player playerObj;
	
	public static SpriteSheet sheet;
	public static Sprite platform;
	public static Sprite spike;
	public static Sprite player[] = new Sprite[14];
	public static Sprite enemy[] = new Sprite[14];
		
	public static BufferedImage backgroundImage;
	
	public static boolean playingGame = false;
	public static boolean endGame = false;
	public static int endGameTime;
	public static int countDown = 5;
	
	public static Sound jump;
	public static Sound bird;
	public static Sound gunshot;
	public static Sound death;
	public static Sound spikes;
	public static Sound music;

	
	// start the game
	private synchronized void start() {
		System.out.println("the game has been started");
		if (rungame)
			return;
		rungame = true;
		thread = new Thread(this, "Thread");
		thread.start();
	}

	// end the game
	private synchronized void end() {
		if (rungame = false) {
			return;
		}
		// using try and catch to get error when closing the game
		try {
			thread.join();
		} catch (InterruptedException error) {
			error.printStackTrace();
		}
	}

	// RUN THE GAME
	public void run() {
		init();
		requestFocus();
		System.out.println("the game is running");
		long previoustime = System.nanoTime(); // begin time in nanosec
		long time = System.currentTimeMillis();// current time
		double delta = 0.0; // different time to update
		int frame = 0; // counter to update background
		int update = 0;
		double ns = 1000000000.0 / 60.0;
		int counter = 0; // counter for update

		// if the game is running, update activities of the game and background
		while (rungame = true) {
			long currenttime = System.nanoTime();
			delta = delta + (currenttime - previoustime) / (ns);
			previoustime = currenttime;
			while (delta >= 1) {
				update();
				counter++;
				delta--;
			}
			render();
			frame++;
			if (System.currentTimeMillis() - time > 1000) {
				time += 1000;
				frame = 0;
				counter = 0;
			}
		}
		end();
	}

	// initialize a box to be our character (temporary)
	private void init() {
		handler = new Handler();
		menu = new Menu();
		playerObj = new Player(300, 615, 64, 64, true, ID.player, handler);
		cam = new Camera();
		mouse = new MouseInput();
		key = new KeyboardInput();
		addKeyListener(key);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		
		sheet = new SpriteSheet("/spritesheet.png");
		platform = new Sprite(sheet,1,2);
		spike = new Sprite(sheet,2,2);
		
		for (int i = 0; i < player.length; i++) {
			player[i] = new Sprite(sheet, i+1, 3);
		}
		
		for (int j = 0; j < enemy.length; j++) {
			enemy[j] = new Sprite(sheet, j+1, 1);
		}
		
		try {
			backgroundImage = ImageIO.read(getClass().getResource("/background.png"));
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
		jump = new Sound("/jump.wav");
		gunshot = new Sound("/gunshot.wav");
		bird = new Sound("/bird.wav");
		death = new Sound("/death.wav");
		spikes = new Sound("/spike.wav");
		music = new Sound("/music.wav");
	}

	// update everything from handler function
	public void update() {
		if (playingGame == true) {
			handler.update();
		}

		for (Super character : handler.player) {
			if (character.getId() == ID.player) {
				cam.updateCam(character);
			}
		}
		
		if (endGame == true) {
			endGameTime ++;
			if (endGameTime == 60 || endGameTime == 120 || endGameTime == 180 || endGameTime == 240 || endGameTime == 300) {
				countDown--;
			}
		}
		if (endGameTime >= 300) {
			endGameTime = 0;
			countDown = 5;
			handler.deleteLevel();
			handler.makeLevel();
			handler.NEWSCORE = 0;
			handler.SCORE = 0;
			handler.plat = 100;
			endGame = false;
			music.play();
		}
	}
	
	
	// update background and graphic
	public void render() {
		BufferStrategy background = getBufferStrategy();
		if (background == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = background.getDrawGraphics();	
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.RED);
		g.setFont(new Font("Courier", Font.BOLD, 20));
		
		if (endGame == true) {
			g.setColor(Color.BLACK);
			g.setFont(new Font("Courier", Font.BOLD, 40));
			g.drawString("GAME OVER!", frameWidth()/2 - 120, frameHeight()/2 - 100);
			g.drawString("FINAL SCORE: " + handler.SCORE, frameWidth()/2 - 170, frameHeight()/2);
			
			g.setColor(Color.MAGENTA);
			g.setFont(new Font("Courier", Font.BOLD, 20));
			g.drawString("NEW GAME IN..." + countDown, frameWidth()/2 - 100, frameHeight()/2 + 150);
			
			if (handler.SCORE <= 5) {
				g.setColor(Color.RED);
				g.setFont(new Font("Courier", Font.BOLD, 30));
				g.drawString("YOU SUCK!", frameWidth()/2 - 85, frameHeight()/2 + 100);
			}
			else if (handler.SCORE > 5 && handler.SCORE <= 10) {
				g.setColor(Color.ORANGE);
				g.setFont(new Font("Courier", Font.BOLD, 30));
				g.drawString("NOT BAD!", frameWidth()/2 - 75, frameHeight()/2 + 100);
			}
			else {
				g.setColor(Color.GREEN);
				g.setFont(new Font("Courier", Font.BOLD, 30));
				g.drawString("PRETTY GOOD!", frameWidth()/2 - 110, frameHeight()/2 + 100);
			}
		}
		if (playingGame == true) {
			g.translate(cam.getX(), cam.getY());
			handler.render(g);
		}
		else if (playingGame == false) {
			menu.render(g);
		}
		g.dispose();
		background.show();
	}

	public static int frameWidth() {
		return WIDTH * SCALE;
	}

	public static int frameHeight() {
		return HEIGHT * SCALE;
	}
	

	public Main() {
		Dimension size = new Dimension(frameWidth(), frameHeight());
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
	}

	// main function to start/exit the window on click
	public static void main(String args[]) {
		Main game = new Main();
		JFrame frame = new JFrame(name);
		frame.add(game);
		frame.pack();
		frame.setResizable(false); // can't change the default game window
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		game.start();
		
	}

}
