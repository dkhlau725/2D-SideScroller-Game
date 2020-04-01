package graphics;

import java.awt.image.BufferedImage;

public class Sprite {

	public SpriteSheet sheet;
	public BufferedImage image;

	public Sprite(SpriteSheet sheet, int spriteX, int spriteY) {
		image = sheet.getSprite(spriteX, spriteY);
	}

	public BufferedImage getBufferedImage() {
		return image;
	}
}
