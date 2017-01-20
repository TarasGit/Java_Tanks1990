package de.ikstaras.Game;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Timer;

import de.ikstaras.Display.Display;
import de.ikstaras.Game.Level.Level;
import de.ikstaras.IO.Input;
import de.ikstaras.graphics.TextureAtlas;

public class Game implements Runnable{

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	private static final String TITLE = "Tanks";
	private static final int COLOR = 0xff000000;
	private static final int NUMBUFFERS = 3;
	private static boolean created;
	private static final String PICTURE = "texture_atlas.png";
	private static final int SCALE = 1;
	private static final int SPEED = 1;
	
	private Player player;
	private Input input;
	private TextureAtlas atlas;
	private Thread t;
	private Graphics2D g;
	private Level lvl;
	
	public Game(){
		Display.create(WIDTH, HEIGHT, TITLE, COLOR, NUMBUFFERS);
		created = false;
		t = new Thread(this);
		input = new Input();
		atlas = new TextureAtlas(PICTURE);
		player = new Player(400, 300, atlas, SCALE, SPEED);
		g = Display.getGraphics();
		Display.setInput(input);
		lvl = new Level(atlas, 1);
		
	}
	
	@Override
	public void run() {
		Timer t = new Timer(1000 / 60, new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				update();
				render();
			}
		});
		t.setRepeats(true);
		t.start();
	}
	
	
	public void update(){
		player.update(input);
		
	}
	
	public void render(){
		Display.clear();
		lvl.render(g);
		player.render(g);
		Display.swapBuffers();
	}
	
	public void start(){
		if(created)
			return;
		
		created = true;
		
		t.start();
	}
	
	public void stop(){
		if(!created)
			return;
		
		created = false;
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}