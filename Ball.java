import javafx.scene.shape.Circle;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.Random;

class Ball extends Circle{
	int speedY;
	int speedX;
	int maxSpeed = 6;
	int oldSpeed = 4;
	int rad = 6;
	Random rand = new Random();
	
	public Ball(double x,double y){
		super(x,y,6);
		
		speedY = 0;
		speedX = 2;
		setRadius(6);
		
	}
	
	public void move(Paddle leftPaddle,Paddle rightPaddle){
		
		
		//hitting the bottom, detects collision and positions hte ball correctly and inverts the y speed
		if (getCenterY() + speedY + rad > 512){
			int offset = (int)getCenterY() + speedY + rad - 512;
			setCenterY(512 -offset - rad);
			speedY = -speedY;
			
			
			//hittin the top
		} else if ((int)getCenterY() + speedY - rad < 0){
			int offset = (int)getCenterY() + speedY - rad;
			setCenterY(offset + rad);
			speedY = -speedY;
			
		}
		
		
		
		// hitting right paddle
		if (rightPaddle.contains(getCenterX() + rad,getCenterY() + rad) ||rightPaddle.contains(getCenterX() + rad,getCenterY() - rad)){
			setCenterX(924 + (924 - (getCenterX()+speedX) - rad));// set position to the left of the paddle
			if (Math.abs(speedX) != maxSpeed){
				speedX = -maxSpeed;
				setDeflectionY(rightPaddle);
			} else{
			speedX = -speedX;
			setDeflectionY(rightPaddle);
			}
			
			
			//hitting left paddle
		} else if ((leftPaddle.contains(getCenterX() - rad,getCenterY() + rad) ||leftPaddle.contains(getCenterX() - rad,getCenterY() - rad))){
			setCenterX(100 - (100 - (getCenterX()+speedX)) + rad);// set position to the left of the paddle
			if (Math.abs(speedX) != maxSpeed){
				speedX = -maxSpeed;
				setDeflectionY(leftPaddle);
			} else{
			speedX = -speedX;
			setDeflectionY(leftPaddle);
			}
	}
	
	
	setCenterX(getCenterX() + speedX);
	setCenterY(getCenterY() + speedY);
	
	}
		
		
public void setDeflectionY(Paddle paddle){
	double paddleMid = (int)(paddle.getY()+ (paddle.getHeight() / 2));
	double offset = (getCenterY() - paddleMid);
	
	speedY = speedY + (int)(maxSpeed * (offset / (paddle.getHeight() /2)));
	if (speedY > maxSpeed){
		speedY = maxSpeed;
		
	} else if (speedY< -maxSpeed){
		
		speedY = -maxSpeed;
	}
	
}
	
	

		
		
public void draw(Graphics2D g2){
		g2.setColor(Color.white);
		g2.fillOval((int)(getCenterX() -getRadius()),(int)(getCenterY()-getRadius()),(int)(2*getRadius()),(int)(2*getRadius()));
	}

public void reset(boolean serve){
	
	setCenterX(512);
	setCenterY(256);
	speedY = rand.nextInt(maxSpeed/2);
	if (serve == false){
		speedX = 2;
	} else{
		speedX = -2;
	}
	
	
	
}

public int isOut(){
	if (getCenterX() - rad > 1024){
		return 1;
		
	}else if (getCenterX() + rad < 0){
		return -1;
	}else{
		return 0;
	}
	
	
	
	
}
	
	
	
}