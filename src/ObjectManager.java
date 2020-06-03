import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship rs;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random ran = new Random();

	ObjectManager(Rocketship rs) {
		this.rs = rs;
	}

	public void addProjectile(Projectile p) {
		projectiles.add(p);
	}

	public void addalien() {
		aliens.add(new Alien(ran.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}
	public void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
	}
	public void draw(Graphics g) {
		rs.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}
	public void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (!aliens.get(i).isActive) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (!projectiles.get(i).isActive) {
				projectiles.remove(i);
			}
		}
	}
}
