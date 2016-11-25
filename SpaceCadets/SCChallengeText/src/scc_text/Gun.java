package scc_text;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Gun implements ActionListener {
	public static final int DEFAULT_WIDTH = 5 ;
	public static final int DEFAULT_HEIGHT = 10;
	
	private Timer timer;
	
	public int width;
	public int height;
	public int x;
	public int y;
	
	public Gun(int x, int y) {
		this.width = Gun.DEFAULT_WIDTH;
		this.height = Gun.DEFAULT_HEIGHT;
		this.x = x;
		this.y = y;
	}
	
	public Bullet fire(int cooldown) {
		this.timer = new Timer(cooldown, this);
		this.timer.start();
		
		this.height /= 2;
		this.y += this.height;
		
		return new Bullet(this.x, this.y - this.width, this.width);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.height *= 2;
		this.y -= this.height / 2;
		this.timer.stop();
	}
}
