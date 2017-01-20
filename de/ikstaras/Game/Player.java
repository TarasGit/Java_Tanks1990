package de.ikstaras.Game;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import de.ikstaras.IO.Input;
import de.ikstaras.graphics.TextureAtlas;


public class Player extends Entity{

	public static int SPRITE = 16;
	
	private Map<Heading,Sprite> tileMap;
	private Heading heading;
	private int scale;
	private int speed;
	
	public Player(int x, int y, TextureAtlas atlas, int scale, int speed){
		super(EntityType.Player, x,y);
		
		heading = Heading.NORTH;
		tileMap = new HashMap<Heading, Sprite>();
		this.scale = scale;
		this.speed = speed;
		
		for(Heading h : Heading.values()){
			SpriteSheet sheet = new SpriteSheet(atlas.cut(h.x, h.y, h.w, h.h), scale);
			Sprite sprite = new Sprite(sheet, scale);
			tileMap.put(h, sprite);
		}
	}

	private enum Heading{
		NORTH(0 * SPRITE, 0 * SPRITE, SPRITE, SPRITE),
		SOUTH(5 * SPRITE, 0 * SPRITE, SPRITE, SPRITE), 
		WEST(3 * SPRITE, 0 * SPRITE, SPRITE, SPRITE),
		EAST(7 * SPRITE, 0 * SPRITE, SPRITE, SPRITE);
		
		private int x,y,w,h;
		
		private Heading(int x, int y, int w, int h){
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}
	}
	
	
	@Override
	protected void render(Graphics2D g) {
		tileMap.get(heading).render(g, x, y);
	}

	@Override
	protected void update(Input input) {
		int tempX = x;
		int tempY = y;
		
		if(input.getKeyCode(KeyEvent.VK_UP)){
			tempY -= speed;
			heading = Heading.NORTH;
		}
		if(input.getKeyCode(KeyEvent.VK_DOWN)){
			tempY += speed;
			heading = Heading.SOUTH;
		}
		if(input.getKeyCode(KeyEvent.VK_LEFT)){
			tempX -= speed;
			heading = Heading.WEST;
		}
		if(input.getKeyCode(KeyEvent.VK_RIGHT)){
			tempX += speed;
			heading = Heading.EAST;
		}
		
		x = tempX;
		y = tempY;
	}
}















