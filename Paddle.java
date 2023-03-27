import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

class Paddle extends Rectangle{
	
	int player;
	int speed = 3;
	int ai =0;
	int intercept;
	int distance;
	int sideOffset;
	
	public Paddle(int x, int y,int w,int h, int p){
			super(x,y,w,h);
			player = p;
	}
	
	public void move(KeyHandler keyH){
		if (player == 0){
			if (keyH.upPressed_P1){
				if (getY() - speed < 0){
					super.setLocation((int)getX(),0);
				}else{
			super.setLocation((int)getX(),(int)getY() - speed);
			}}
			if (keyH.downPressed_P1){
				if (getY() + height + speed > 512){
				super.setLocation((int)getX(),456);	
				}else{
				super.setLocation((int)getX(),(int)getY() + speed);
				}
				
			}
			
		} else if (player == 1){
			if (keyH.upPressed_P2){
			if (getY() - speed < 0){
					super.setLocation((int)getX(),0);
				}else{
			super.setLocation((int)getX(),(int)getY() - speed);
			}
			}
			if (keyH.downPressed_P2){
				if (getY() + height + speed > 512){
				super.setLocation((int)getX(),456);	
				}else{
				super.setLocation((int)getX(),(int)getY() + speed);
				}
			}	
			
	}}
	
	public void draw(Graphics2D g2){
		g2.setColor(Color.white);
		g2.fillRect((int)getX(),(int)getY(),(int)getWidth(),(int)getHeight());
		
		
		
	}
	
	public void reset(){
		setLocation((int)getX(),256);
	}
	
	public void easyAiMove(Ball ball){
		//keeps paddle in line with ball at all times
		
		//if paddle above move down
		
		if (getY() + (getHeight()/2) < ball.getCenterY()){
			
			if (getY() + height + speed > 512){
				super.setLocation((int)getX(),456);	
				}else{
				super.setLocation((int)getX(),(int)getY() + speed);
				}
			
		}
		
		//if paddle below move up
		else if (getY() + (getHeight()/2) > ball.getCenterY()){
			
			if (getY() - speed < 0){
					super.setLocation((int)getX(),0);
				}else{
			super.setLocation((int)getX(),(int)getY() - speed);
			}
			
		}
	}
	public void mediumAiMove(Ball ball){
		
		if (ball.speedX > 0){
		distance = (int)(getX() - (ball.getCenterX()+ ball.rad))/4;
		
		intercept = (int)( ball.getCenterY() + (ball.speedY * distance));
		
		
		
		
		
		
	
		if (getY() + (getHeight()/2) < intercept){
			
			if (getY() + height + speed > 512){
				super.setLocation((int)getX(),456);	
				}else{
				super.setLocation((int)getX(),(int)getY() + speed);
				}
			
		}
		
		//if paddle below move up
		else if (getY() + (getHeight()/2) > intercept){
			
			if (getY() - speed < 0){
					super.setLocation((int)getX(),0);
				}else{
			super.setLocation((int)getX(),(int)getY() - speed);
			}
			
		}


	}}
		
		public void hardAiMove(Ball ball){
			if (ball.speedX > 0){
		distance = (int)(getX() - (ball.getCenterX()+ ball.rad))/ball.maxSpeed;
		
		intercept = (int)( ball.getCenterY() + (ball.speedY * distance));
		
		if (intercept < 0){
			intercept = -intercept;
		} else if (intercept > 512){
			intercept = 512 - (intercept -512);
			
		}
		
		
		
		
	
		if (getY() + (getHeight()/2) < intercept){
			
			if (getY() + height + speed > 512){
				super.setLocation((int)getX(),456);	
				}else{
				super.setLocation((int)getX(),(int)getY() + speed);
				}
			
		}
		
		//if paddle below move up
		else if (getY() + (getHeight()/2) > intercept){
			
			if (getY() - speed < 0){
					super.setLocation((int)getX(),0);
				}else{
			super.setLocation((int)getX(),(int)getY() - speed);
			}
			
		}
			
		}
		
		
		
	}
	
}
	

	
