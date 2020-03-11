package game;

import java.awt.Canvas; // allow  to display with our frame
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame; //library to create a window :) 

import Super.Enemy0;
import Super.Player;
import Super.Super;
import key.KeyboardInput;

public class Main extends Canvas implements Runnable {
	// set screen resolution as 800x600 and the scale as 3 :) name of the game will
	// be decided later so let set it random
	public static final int WIDTH = 270;
	public static final int HEIGHT = WIDTH / 14 * 10;
	public static final int SCALE = 4;
	public static final String name = "Scrolling Shooting Game"; // title of the game
	private Thread thread;
	private boolean rungame = false; // boolean to run game the game
	public static Handler handler;
	public static Camera cam;
	public static KeyboardInput key;

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
				System.out.println(frame + " Frame per s " + counter + " update per s");
				frame = 0;
				counter = 0;
			}
		}
		end();
	}

	// initialize a box to be our character (temporary)
	private void init() {
		handler = new Handler();
		handler.addSuper(new Player(300, 615, 64, 64, true, ID.player, handler));
		cam = new Camera();
		key = new KeyboardInput();
		addKeyListener(key);

		// makes a box to be an enemy (temporary)
		handler.addSuper(new Enemy0(500, 615, 55, 55, true, ID.Enemy0, handler));

	}

	// update everything from handler function
	public void update() {
		handler.update();

		for (Super character : handler.player) {
			if (character.getId() == ID.player) {
				cam.updateCam(character);
			}
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
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.translate(cam.getX(), cam.getY());
		handler.render(g);
		g.dispose();
		background.show();
	}

	public static int frameWidth() {
		return WIDTH * SCALE;
	}

	public static int frameHeight() {
		return HEIGHT * SCALE;
	}

	// create dimension which makes max width increase to 2400 and max height
	// increase to 1800 :)
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
