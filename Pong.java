

import javax.swing.JFrame;
public class Pong{
	public static void main(String[] args){
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Pong");
		
		GamePanel gamePanel = new GamePanel();
		
		window.add(gamePanel);
		
		window.pack();
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		
		gamePanel.startGameThread();
	}
	
}