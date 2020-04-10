package hunter2d.graphics;

import java.awt.Graphics;

import hunter2d.game.Main;

public class Menu {

	public Button[] buttons;

	public Menu() {
		buttons = new Button[2];

		buttons[0] = new Button(Main.frameWidth() / 2 - 45, 250, 100, 100, "START GAME");
		buttons[1] = new Button(Main.frameWidth() / 2 - 45, 400, 100, 100, "QUIT GAME");
	}

	public void render(Graphics g) {
		g.drawImage(Main.backgroundImage, 0, 0, Main.frameWidth(), Main.frameHeight(), null);

		for (int i = 0; i < buttons.length; i++) {
			buttons[i].render(g);
		}
	}
}
