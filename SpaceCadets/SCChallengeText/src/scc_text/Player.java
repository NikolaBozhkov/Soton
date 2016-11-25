package scc_text;

public class Player extends Movable {
	public static final int HEIGHT = 7;
	public static final int DEFAULT_WIDTH = 60;
	public static final int DEFAULT_SPEED = 4;
	public static final int DEFAULT_SHOT_COOLDOWN = 200;

	private int currentGun = -1;
	
	public int width;
	public int shotCooldown;
	public int attackSpeed;
	public Gun[] guns;
	
	public Player(int x) {
		this(x, StringInvadersApplet.HEIGHT - HEIGHT);
	}
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = DEFAULT_WIDTH;
		this.speed = DEFAULT_SPEED;
		this.shotCooldown = 0;
		this.attackSpeed = DEFAULT_SHOT_COOLDOWN;
		
		this.guns = new Gun[] { 
				new Gun(x, y - Gun.DEFAULT_HEIGHT), 
				new Gun(x + this.width - Gun.DEFAULT_WIDTH, y - Gun.DEFAULT_HEIGHT) 
		};
	}
	
	public void move(int xMin, int xMax, boolean left) {
		int oldX = this.x;
		
		// Move according to direction and limit movement if exceeding limits
		this.x += left ? -this.speed : this.speed;
		this.x = this.x < 0 ? 0 : this.x + this.width > xMax ? xMax - this.width : this.x;
		this.guns[0].x = this.x;
		
		// Avoid more ifs by checking if x has changed for the second gun
		if (oldX != this.x) {
			this.guns[1].x = this.x + this.width - this.guns[1].width;
		}
	}
	
	public Bullet fireGun() {
		this.shotCooldown = this.attackSpeed;
		
		// Alternate guns
		this.currentGun = (this.currentGun + 1) % this.guns.length;
		return this.guns[this.currentGun].fire(this.shotCooldown);
	}
}
