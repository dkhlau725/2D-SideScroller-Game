package key;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import game.Main;
import graphics.Button;

public class MouseInput implements MouseListener, MouseMotionListener {

	public int mouseX;
	public int mouseY;
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		for (int i = 0; i < Main.menu.buttons.length; i++) {
			Button button = Main.menu.buttons[i];
			
			if (mouseX >= button.getX() && mouseY >= button.getY() && mouseX <= button.getX() + button.getWIDTH() && mouseY <= button.getY() + button.getHEIGHT()) {
				button.clickEvent();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}



}
