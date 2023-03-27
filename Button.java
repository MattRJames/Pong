import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.Color;

class Button extends Rectangle{
	boolean selected = false;
	String text;
	int textWidth;
	 
	public Button(int x,int y, int width, int height,String t){
		super(x,y,width,height);
		text = t;
	}
	
	
	public void draw(Graphics2D g2){
		g2.setColor(new Color(1f,1f,1f,0.2f));
		textWidth = g2.getFontMetrics().stringWidth(text);
		
		if (selected == true){
			
			g2.fillRect(x,y,width,height);
			
			
		}
		
	g2.setColor(Color.white);
	g2.drawString(text,x+ (width/2 - textWidth/2),y + height -10);
	
}
public void setSelected(){
	
	selected = true;



}

public void setUnselected(){
	selected =false;
}


}