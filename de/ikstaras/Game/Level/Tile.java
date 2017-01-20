package de.ikstaras.Game.Level;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Tile{
	
	private BufferedImage image;
	private TileType type;
	private int scale;
	
	public Tile(TileType type, BufferedImage image, int scale){
		this.image = image;
		this.type = type;
		this.scale = scale;
	}
	
	public void render(Graphics2D g, int x, int y){
		g.drawImage(image, x, y, image.getWidth() * scale, image.getHeight() * scale, null);
	}
}