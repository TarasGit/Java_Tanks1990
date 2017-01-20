package de.ikstaras.Display;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

import javax.swing.JFrame;

import de.ikstaras.IO.Input;

public class Display{
	
	private static JFrame window;
	private static Canvas content;
	private static boolean created = false;
	
	private static BufferedImage image;
	private static Graphics g;
	private static int[] buffer;
	private static int clearColor;
	
	private static BufferStrategy bufferStrategy;
	
	public static void create(int width, int height, String title, int color, int numBuffers){
		
		if(created)
			return;
		
		created = true;
		
		window = new JFrame(title);
		content = new Canvas();
		content.setSize(width, height);
		window.getContentPane().add(content);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		clearColor = color;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		buffer = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		g = image.getGraphics();
		
		((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
		content.createBufferStrategy(numBuffers);
		bufferStrategy = content.getBufferStrategy();
	}
	
	public static void clear(){
		Arrays.fill(buffer, clearColor);
	}
	
	public static void swapBuffers(){
		Graphics g = bufferStrategy.getDrawGraphics();
		g.drawImage(image, 0, 0, null);
		bufferStrategy.show();
	}
	
	public static Graphics2D getGraphics(){
		return (Graphics2D)g;
	}
	
	public static void setInput(Input input){
		window.add(input);
	}
}











