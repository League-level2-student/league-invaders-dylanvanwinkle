import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship rs;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random ran = new Random();
	int score = 0;

	ObjectManager(Rocketship rs) {
		this.rs = rs;
	}

	public void addProjectile(Projectile p) {
		projectiles.add(p);
	}

	public void addAlien() {
		aliens.add(new Alien(ran.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	public void update() {
		rs.update();
		if(rs.isActive) {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		checkCollision();
		purgeObjects();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}

	public void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			if (rs.collisionBox.intersects(aliens.get(i).collisionBox)) {
				rs.isActive = false;
				aliens.get(i).isActive = false;
			}
			for (int j = 0; j < projectiles.size(); j++) {
				if (projectiles.get(j).collisionBox.intersects(aliens.get(i).collisionBox)) {
					aliens.get(i).isActive = false;
					projectiles.get(j).isActive = false;
					score++;
				}
			}
		}
	}
	public int getScore(){
		return score;
	}
}
