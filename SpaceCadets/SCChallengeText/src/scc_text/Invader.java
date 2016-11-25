package scc_text;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Invader {
	private static final int SPEED_Y = 20;
	
	public List<CharPoint> charPoints;
	
	public int speed = 2;
	
	public Invader(String text, int x, int y, Function<String, Rectangle2D> getStringBounds, int spacing, int containerWidth) {
		this.charPoints = new ArrayList<CharPoint>();
		
		// Prev values used to calculate next position
		int prevChX = x;
		int prevChY = y;
		int prevChWidth = 0;
 		
		// Loop through every char and create a CharPoint
		for (int i = 0; i < text.length(); i++) {
			String chValue = text.substring(i, i + 1);
			
			// Puts the chars at equal distance from each other and moves to new line if necessary
			int chX = prevChX + prevChWidth + spacing;
			int chY = prevChY;
			if (chX >= containerWidth) {
				chX %= containerWidth;
				chY += SPEED_Y;
			}
			
			prevChX = chX;
			prevChY = chY;
			prevChWidth = (int)getStringBounds.apply(chValue).getWidth();
		
			// Skip whitespaces
			if (!chValue.equals(" ")) {
				this.charPoints.add(new CharPoint(chValue, chX, chY));
			}
		}
	}
	
	public void move(int containerWidth) {
		for (CharPoint chPoint : this.charPoints) {
			chPoint.x += this.speed;
			chPoint.y += chPoint.x >= containerWidth ? SPEED_Y : 0;
			chPoint.x %= containerWidth;
		}
	}
}
