package scc_text;

import java.applet.*; 
import java.awt.event.*; 
import java.awt.*;
import javax.swing.Timer;

public class StringInvadersApplet extends Applet implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	private static final int INTERVAL = 1000 / 60; // 60 FPS
	
	private Renderer renderer;
	private World world;
	private Timer timer;
	
	@Override
	public void init() {
		this.setSize(WIDTH, HEIGHT);
		this.setBackground(new Color(34, 49, 63));
		this.setFont(new Font("Consolas", Font.BOLD, 15));
		
		Image buffer = this.createImage(WIDTH, HEIGHT);
		Graphics bufferGraphics = buffer.getGraphics();
		this.renderer = new Renderer(bufferGraphics, buffer);
		
		this.world = new World(WIDTH, HEIGHT, this.renderer.getStringBoundsFunction());
		this.addKeyListener(this.world);
		
		this.timer = new Timer(INTERVAL, this);
	}
	
	@Override
	public void start() {		
		this.timer.start();
	}
	
	@Override
	public void paint(Graphics g) {
		this.renderer.drawWorld(this.world, g, this);
	}
	
	@Override
	public void update(Graphics g) {
		this.paint(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.world.update(INTERVAL);
		this.repaint();
	}
}
