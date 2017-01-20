package de.ikstaras.Game;

import java.awt.Graphics2D;

import de.ikstaras.IO.Input;

public abstract class Entity{
	
	protected int x;
	protected int y;
	protected EntityType type;
	
	public Entity(EntityType type, int x, int y){
		this.type = type;
		this.x = x;
		this.y = y;
	}
	
	protected abstract void render(Graphics2D g);
	protected abstract void update(Input input);
}