package de.ikstaras.ResourceLoader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceLoader{
	
	public static BufferedImage loadImage(String title){
		
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(new File(title));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}