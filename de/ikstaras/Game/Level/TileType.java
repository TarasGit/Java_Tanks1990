package de.ikstaras.Game.Level;

public enum TileType{
	EMPTY(0), BRICK(1), ICE(2), GRASS(3), WATER(4);
	
	private int x;
	
	private TileType(int x){
		this.x = x;
	}
	
	public int numeric(){
		return x;
	}
	
	public static TileType getTileType(int n){
		switch(n){
		case 1:
			return BRICK;
		case 2:
			return ICE;
		case 3:
			return GRASS;
		case 4:
			return WATER;
		case 0:
		default:
			return EMPTY;
		}
	}
}