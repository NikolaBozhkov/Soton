package scc_text;

import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class AttackSpeedUpgrade extends Upgrade {
	public AttackSpeedUpgrade(int x, int y) {
		super(x, y);
		this.duration = 3000;
		this.timer = new Timer(this.duration, this);
	}

	@Override
	public void applyToPlayer(Player player) {
		player.attackSpeed /= 2;
		this.appliedTo = player;
		this.timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.appliedTo.attackSpeed *= 2;
		this.timer.stop();
	}

}
