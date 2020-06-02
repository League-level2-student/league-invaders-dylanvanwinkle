import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
public boolean right = false;
public boolean left = false;
public boolean up = false;
public boolean down = false;

	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 8;
		// TODO Auto-generated constructor stub
	}
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
	}
public void move() {
	if (up && y >= 0) {
	y-=speed;	
	}
	if (down && y+height <= LeagueInvaders.HEIGHT) {
	y+=speed;	
	}
	if (left && x >= 0) {
	x-=speed;	
	}
	if (right && x+width <= LeagueInvaders.WIDTH) {
	x+=speed;	
	}
}	
}