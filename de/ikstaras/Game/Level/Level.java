package de.ikstaras.Game.Level;

import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

import de.ikstaras.Game.Game;
import de.ikstaras.Utils.Utils;
import de.ikstaras.graphics.TextureAtlas;

public class Level {

	public static final int SPRITE = 16;
	public static final int SPRITES_IN_WIDTH = Game.WIDTH / SPRITE;
	public static final int SPRITES_IN_HEIGHT = Game.HEIGHT / SPRITE;

	private static Integer[][] lvlMap;
	private Map<TileType, Tile> tileMap;

	public Level(TextureAtlas atlas, int scale) {
		
		tileMap = new HashMap<TileType, Tile>();
		lvlMap =  Utils.getMap("res/level.lvl");
		
		//for(int i=0;i<SPRITES_IN_WIDTH;i++)
		//	Arrays.fill(lvlMap[i], 0);
		
		tileMap.put(TileType.BRICK,	new Tile(TileType.BRICK, atlas.cut(16 * SPRITE, 0 * SPRITE, SPRITE, SPRITE), scale));
		tileMap.put(TileType.WATER, new Tile(TileType.WATER, atlas.cut(17 * SPRITE, 3 * SPRITE, SPRITE, SPRITE), scale));
		tileMap.put(TileType.GRASS, new Tile(TileType.GRASS, atlas.cut(17 * SPRITE, 2 * SPRITE, SPRITE, SPRITE), scale));
		tileMap.put(TileType.ICE, new Tile(TileType.ICE, atlas.cut(18 * SPRITE, 2 * SPRITE, SPRITE, SPRITE), scale));
		tileMap.put(TileType.EMPTY, new Tile(TileType.EMPTY, atlas.cut(19 * SPRITE, 3 * SPRITE, SPRITE, SPRITE), scale));

		lvlMap[0][0] = TileType.BRICK.numeric();
	}

	public void render(Graphics2D g){
		for (int i = 0; i < lvlMap.length; i++) {
			for (int j = 0; j < lvlMap[i].length; j++) {
				//System.out.println(lvlMap[0][0]);
				tileMap.get(TileType.getTileType(lvlMap[i][j])).render(g, j * SPRITE, i * SPRITE);
			}
		}
	}
}