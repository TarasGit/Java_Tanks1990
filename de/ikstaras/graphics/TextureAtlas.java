package de.ikstaras.graphics;

import java.awt.image.BufferedImage;

import de.ikstaras.ResourceLoader.ResourceLoader;

public class TextureAtlas{
	
	public static final String PATH = "res/";
	
	private BufferedImage image;
	
	public TextureAtlas(String title){
		image = ResourceLoader.loadImage(PATH + title);
	}
	
	public BufferedImage cut(int x, int y, int w, int h){
		return image.getSubimage(x, y, w, h);
	}
	
}