package scc_text;

import java.awt.event.ActionEvent;

import javax.swing.Timer;

public class BigGunUpgrade extends Upgrade {
	public BigGunUpgrade(int x, int y) {
		super(x, y);
		this.duration = 5000;
		this.timer = new Timer(this.duration, this);
	}
	
	@Override
	public void applyToPlayer(Player player) {
		this.appliedTo = player;
		for (Gun gun : player.guns) {
			gun.width *= 2;
		}
		
		player.guns[player.guns.length - 1].x -= player.guns[0].width / 2;
		
		this.timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (Gun gun : this.appliedTo.guns) {
			gun.width /= 2;
		}
		
		Gun[] guns = this.appliedTo.guns;
		guns[guns.length - 1].x += guns[0].width;
		
		this.timer.stop();
	}
}
