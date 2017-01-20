package de.ikstaras.Game;

import java.awt.image.BufferedImage;

public class SpriteSheet{
	
	private BufferedImage image;
	private int scale;
	private int spriteInWidth;
	
	public SpriteSheet(BufferedImage image, int scale){
		this.image = image;
		this.scale = scale;
		this.spriteInWidth = image.getWidth() / scale;
	}
	
	public BufferedImage getSprite(int index){
		
		index = index % scale;
		
		int x = index % spriteInWidth * scale;
		int y = index / spriteInWidth * scale;
		
		return image.getSubimage(x, y, image.getWidth() * scale, image.getHeight() * scale);
	}
}