package scc_text;

import java.awt.event.ActionListener;

import javax.swing.Timer;

public abstract class Upgrade extends Movable implements ActionListener {
	public static final int DIAMETER = 15;
	public static final int DEFAULT_SPEED = 4;
	
	protected int duration;
	protected Timer timer;
	protected Player appliedTo;
	
	public boolean used = false;
	
	public Upgrade(int x, int y) {
		this.x = x;
		this.y = y;
		this.speed = DEFAULT_SPEED;
	}
	
	public abstract void applyToPlayer(Player player);
	
	public void move() {
		this.y += this.speed;
	}
}
