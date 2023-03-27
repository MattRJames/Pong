import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

class MouseMotionHandler implements MouseMotionListener{
	
	GamePanel Gp;
	
	public MouseMotionHandler(GamePanel x){
		Gp = x;
	}
	
	public void mouseMoved(MouseEvent e){
		int xPos = e.getX();
		int yPos = e.getY();
		
		

			if (Gp.singlePlayer.contains(xPos,yPos)){
				Gp.singlePlayer.setSelected();
				
			} else{
				Gp.singlePlayer.setUnselected();
			}
			
			if (Gp.singlePlayerMedium.contains(xPos,yPos)){
				Gp.singlePlayerMedium.setSelected();
				
			} else{
				Gp.singlePlayerMedium.setUnselected();
			}
			
			if (Gp.singlePlayerHard.contains(xPos,yPos)){
				Gp.singlePlayerHard.setSelected();
				
			} else{
				Gp.singlePlayerHard.setUnselected();
			}
			
			if (Gp.twoPlayer.contains(xPos,yPos)){
				Gp.twoPlayer.setSelected();
				
			} else{
				Gp.twoPlayer.setUnselected();
			}
		
		
	}
	
	public void mouseDragged(MouseEvent e){}
	
	
	
	
	
	
}