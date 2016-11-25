package scc_text;

public class Bullet extends Movable {
	private static final int DEFAULT_SPEED = 5;
	public int diameter;
	
	public Bullet(int x, int y, int radius) {
		this(x, y, radius, DEFAULT_SPEED);
	}
	
	public Bullet(int x, int y, int radius, int speed) {
		this.x = x;
		this.y = y;
		this.diameter = radius;
		this.speed = speed;
	}
	
	public void move() {
		this.y -= this.speed;
	}
}
