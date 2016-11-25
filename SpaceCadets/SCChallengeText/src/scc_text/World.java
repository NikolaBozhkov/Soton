package scc_text;

import java.util.*;
import java.util.function.Function;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

public class World implements KeyListener {
	private static final int CHAR_SPACING = 3;
	
	private Random random;
	private int width;
	private int height;
	private Function<String, Rectangle2D> getStringBounds;
	private HashSet<Integer> keysDown = new HashSet<Integer>();
	
	public List<Invader> invaders = new ArrayList<Invader>();
	public List<Bullet> bullets = new ArrayList<Bullet>();
	public List<Upgrade> upgrades = new ArrayList<Upgrade>();
	public Player player;
	
	public World(int width, int height, Function<String, Rectangle2D> getStringBounds) {
		this.random = new Random();
		this.width = width;
		this.height = height;
		this.getStringBounds = getStringBounds;
		
		this.invaders.add(new Invader("String Invaders! I am too lazy to write a random sentence generator and a spawner. This is now long enough so never mind.", 0, 15, this.getStringBounds, CHAR_SPACING, this.width));
		
		// Center X and place near the bottom with Height as margin
		int playerX = (this.width - Player.DEFAULT_WIDTH) / 2;
		int playerY = this.height - Player.HEIGHT * 2;
		this.player = new Player(playerX, playerY);
	}
	
	private boolean updateBullet(Bullet bullet, Iterator<Bullet> iterator) {
		bullet.move();
		
		// Remove bullet if off screen
		if (bullet.y <= -bullet.diameter) {
			iterator.remove();
			return true;
		}
		
		return false;
	}
	
	private boolean updateUpgrade(Upgrade upgrade, Iterator<Upgrade> iterator) {
		upgrade.move();
		
		// Remove upgrade if off screen
		if (upgrade.y >= this.height) {
			iterator.remove();
			return true;
		}
		
		return false;
	}
	
	private void spawnChancedUpgrade(int x, int y) {
		// Spawn upgrades with 7% chance
		if (this.random.nextInt(100) < 7) {
			int rnd = this.random.nextInt(2);
			
			if (rnd == 0) {
				this.upgrades.add(new BigGunUpgrade(x, y));
			} else if (rnd == 1) {
				this.upgrades.add(new AttackSpeedUpgrade(x, y));
			} else {
				
			}
		}
	}
	
	public void update(double timePassed) {		
		for (Invader invader : this.invaders) {
			invader.move(this.width);
		}
		
		for (Iterator<Upgrade> upgradeIterator = this.upgrades.iterator(); upgradeIterator.hasNext();) {
			Upgrade upgrade = upgradeIterator.next();
			boolean upgradeRemoved = this.updateUpgrade(upgrade, upgradeIterator);
			
			// Check if player is in contact with the upgrade
			if (!upgradeRemoved
					&& upgrade.x + Upgrade.DIAMETER > this.player.x && this.player.x + this.player.width > upgrade.x
					&& upgrade.y + Upgrade.DIAMETER > this.player.y && this.player.y > upgrade.y) {
				upgrade.applyToPlayer(this.player);
				upgradeIterator.remove();
			}
		}
		
		for (Iterator<Bullet> bulletIterator = this.bullets.iterator(); bulletIterator.hasNext();) {
			Bullet bullet = bulletIterator.next();
			boolean bulletRemoved = this.updateBullet(bullet, bulletIterator);
			
			// Check for collision
			for (Invader invader : this.invaders) {
				for (Iterator<CharPoint> chIterator = invader.charPoints.iterator(); chIterator.hasNext();) {
					CharPoint chPoint = chIterator.next();
					Rectangle2D chPointBounds = this.getStringBounds.apply(chPoint.value);
					
					// If bullet is still in game and in the bounds of the string
					if (!bulletRemoved 
							&& bullet.x + bullet.diameter >= chPoint.x && bullet.x <= chPoint.x
							&& bullet.y <= chPoint.y && bullet.y + bullet.diameter >= chPoint.y - chPointBounds.getHeight()) {
						chIterator.remove();
						bulletIterator.remove();
						bulletRemoved = true;
						this.spawnChancedUpgrade(chPoint.x, chPoint.y);
					}
				}
			}
		}
		
		for (int keyCode : this.keysDown) {
			switch (keyCode) {
			case KeyEvent.VK_LEFT:
				this.player.move(0, this.width, true);
				break;
			case KeyEvent.VK_RIGHT:
				this.player.move(0, this.width, false);
				break;
			case KeyEvent.VK_SPACE:
				if (this.player.shotCooldown == 0) {
					this.bullets.add(this.player.fireGun());
				}
				
				break;
			default:
				break;
			}
		}
		
		this.player.shotCooldown -= timePassed;
		if (this.player.shotCooldown < 0) this.player.shotCooldown = 0;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		this.keysDown.add(keyCode);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		this.keysDown.remove(keyCode);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
