package de.ikstaras.Game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Sprite{
	
	private SpriteSheet sheet;
	private int scale;
	
	public Sprite(SpriteSheet sheet, int scale){
		this.sheet  = sheet;
		this.scale = scale;
	}
	
	public void render(Graphics2D g, int x, int y){
		BufferedImage image = sheet.getSprite(0);
		g.drawImage(image, x, y, image.getWidth() * scale, image.getHeight() * scale, null);
	}
}