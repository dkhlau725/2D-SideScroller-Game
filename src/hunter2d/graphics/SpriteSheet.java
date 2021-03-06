package hunter2d.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private BufferedImage sheet;

	public SpriteSheet(String path) {
		try {
			sheet = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getSprite(int spriteX, int spriteY) {
		return sheet.getSubimage(spriteX * 32 - 32, spriteY * 32 - 32, 32, 32);
	}
}
