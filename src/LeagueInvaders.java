
import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	public static final int HEIGHT = 640;
	public static final int WIDTH = 500;
	GamePanel gp;
	
	public static void main(String[] args) {
		LeagueInvaders li = new LeagueInvaders(new JFrame(), new GamePanel());
		li.setup();
	}
	
	LeagueInvaders(JFrame frame, GamePanel gp){
		this.frame = frame;
		this.gp = gp;
	}
	public void setup() {
		frame.add(gp);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(gp);
	}
}
