

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyHandler implements KeyListener{
	
	GamePanel gp;
	public boolean upPressed_P1,downPressed_P1,upPressed_P2,downPressed_P2;
	
	
	public KeyHandler(GamePanel gp){
		this.gp = gp;
	}
	
	@Override
	public void keyTyped(KeyEvent e){
		
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		int code = e.getKeyCode();
		
	
	if (gp.gameState == 1){
		
		
	if (code == KeyEvent.VK_W){
		upPressed_P1 = true;
	}
	
	if (code == KeyEvent.VK_S){
		downPressed_P1 = true;
	}
	if (code == KeyEvent.VK_UP){
		upPressed_P2 = true;
	}
	if (code == KeyEvent.VK_DOWN){
		downPressed_P2 = true;
	}}
	
	}
	
	@Override
	public void keyReleased(KeyEvent e){
	int code = e.getKeyCode();
		
		
	if (code == KeyEvent.VK_W){
		upPressed_P1 = false;
	}
	
	if (code == KeyEvent.VK_S){
		downPressed_P1 = false;
	}
	if (code == KeyEvent.VK_UP){
		upPressed_P2 = false;
	}
	if (code == KeyEvent.VK_DOWN){
		downPressed_P2 = false;
	}
	}
	
	
}