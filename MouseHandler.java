import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class MouseHandler implements MouseListener{
	GamePanel Gp;
	
	public MouseHandler(GamePanel x){
		Gp = x;
		
	}
	
	
	
	
	
	public void mouseClicked(MouseEvent e){
		int xPos = e.getX();
		int yPos = e.getY();
		
		if (Gp.gameState == 0){
		if (Gp.singlePlayer.contains(xPos,yPos)){
			
			Gp.aiMode = 1;
			Gp.gameState = Gp.playState;
		}
		if (Gp.singlePlayerMedium.contains(xPos,yPos)){
			
			Gp.aiMode = 2;
			Gp.gameState = Gp.playState;
		}
		if (Gp.singlePlayerHard.contains(xPos,yPos)){
			
			Gp.aiMode = 3;
			Gp.gameState = Gp.playState;
		}
		if (Gp.twoPlayer.contains(xPos,yPos)){
			
			Gp.aiMode = 0;
			Gp.gameState = Gp.playState;
		}
		}
		
		
		
		
	}
	
	public void mouseEntered(MouseEvent e){
		
	}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	
	
	
	
}