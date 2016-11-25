package scc_text;

import java.awt.image.ImageObserver;
import java.util.function.Function;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Renderer {
	private static final Color PLAYER_COLOR = new Color(243, 156, 18);
	private static final Color INVADER_COLOR = new Color(46, 204, 114);
	private static final Color GUN_COLOR = new Color(249, 191, 59);
	private static final Color BULLET_COLOR = new Color(247, 202, 24);
	private static final Color UPGRADE_COLOR = new Color(42, 187, 155);
	
	private Graphics bufferGraphics;
	private Image buffer;
	
	public Renderer(Graphics bufferGraphics, Image buffer) {
		this.bufferGraphics = bufferGraphics;
		this.buffer = buffer;
	}
	
	private void drawInvader(Invader invader) {
		this.bufferGraphics.setColor(INVADER_COLOR);
		for (CharPoint chPoint : invader.charPoints) {
			this.bufferGraphics.drawString(chPoint.value, chPoint.x, chPoint.y);
		}
	}
	
	private void drawPlayer(Player player) {
		this.bufferGraphics.setColor(PLAYER_COLOR);
		this.bufferGraphics.fillRect(player.x, player.y, player.width, Player.HEIGHT);
		
		// Draw guns to the left and right corner of the player
		this.bufferGraphics.setColor(GUN_COLOR);
		for (Gun gun : player.guns) {
			this.bufferGraphics.fillRect(gun.x, gun.y, gun.width, gun.height);
		}
	}
	
	private void drawBullet(Bullet bullet) {
		this.bufferGraphics.setColor(BULLET_COLOR);
		this.bufferGraphics.fillOval(bullet.x, bullet.y, bullet.diameter, bullet.diameter);
	}
	
	private void drawUpgrade(Upgrade upgrade) {
		this.bufferGraphics.setColor(UPGRADE_COLOR);
		this.bufferGraphics.fillOval(upgrade.x, upgrade.y, Upgrade.DIAMETER, Upgrade.DIAMETER);
	}
	
	public void drawWorld(World world, Graphics graphics, ImageObserver observer) {
		// Ready canvas for new state
		this.bufferGraphics.clearRect(0, 0, StringInvadersApplet.WIDTH, StringInvadersApplet.HEIGHT);
		
		// Draw each invader
		for (Invader invader : world.invaders) {
			this.drawInvader(invader);
		}
		
		// Draw each bullet 
		for (Bullet bullet : world.bullets) {
			this.drawBullet(bullet);
		}
		
		// Draw each upgrade
		for (Upgrade upgrade : world.upgrades) {
			this.drawUpgrade(upgrade);
		}
		
		this.drawPlayer(world.player);
		
		// Dump the buffer image to the visible graphics
		graphics.drawImage(this.buffer, 0, 0, observer);
		Toolkit.getDefaultToolkit().sync();
	}
	
	public Function<String, Rectangle2D> getStringBoundsFunction() {
		return x -> this.bufferGraphics.getFontMetrics().getStringBounds(x, this.bufferGraphics);
	}
}
