import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.TimeUnit;
import java.awt.Rectangle;
import java.awt.Font;


public class GamePanel extends JPanel implements Runnable{
	
	public int screenWidth = 1024;
	public int screenHeight = 512;
	public int gameState = 0;
	final public int menuState = 0;
	final public int playState = 1;
	int p1Score,p2Score;
	int aiMode;
	int buttonHeight = 50;
	int topOffset = 130;
	
	
	Button singlePlayer = new Button(412,topOffset,200,buttonHeight,"Easy");
	Button singlePlayerMedium = new Button(412,topOffset + buttonHeight,200,buttonHeight,"Medium");
	Button singlePlayerHard = new Button(412,topOffset + 2* buttonHeight,200,buttonHeight,"Hard");
	Button twoPlayer = new Button(412,topOffset+ 3*buttonHeight,200,buttonHeight,"Versus");
	
	
	
	public Ball ball = new Ball(512,256);
	
	public int paddleHeight = 56;
	public int paddleWidth = 15;

	public Paddle leftPaddle = new Paddle(100 - paddleWidth,228,paddleWidth,paddleHeight,0);
	public Paddle rightPaddle = new Paddle(924,228,paddleWidth,paddleHeight,1);
	
	KeyHandler keyH = new KeyHandler(this);
	MouseMotionHandler mouseM = new MouseMotionHandler(this);
	MouseHandler mouseH = new MouseHandler(this);
	
	
	Thread gameThread;
	
	public GamePanel(){
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.addKeyListener(keyH);
		this.addMouseListener(mouseH);
		this.addMouseMotionListener(mouseM);
		
		
		
		this.setFocusable(true);
		
		
	}
	
	@Override
	public void run(){
		while (gameThread != null){
			if (gameState == 0){
				repaint();
				
				
			}else if (gameState == 1){
			twoPlayPong();
		
			}
			
			
			
		}
		
	}
	
	
	
	public void startGameThread(){
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	
	public void update(){
		ball.move(leftPaddle,rightPaddle);
		leftPaddle.move(keyH);
		
		if (aiMode == 0){
		rightPaddle.move(keyH);
		}else if (aiMode == 1){
			rightPaddle.easyAiMove(ball);
		} else if (aiMode == 2){
			rightPaddle.mediumAiMove(ball);
		}else if (aiMode == 3){
			rightPaddle.hardAiMove(ball);
		}
		
		
	}
	
	public void paintComponent(Graphics g){
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D)g;
	g2.setFont(new Font("Arial", Font.PLAIN, 40));
	if (gameState == 0){
	g2.setColor(Color.white);
	g2.setFont(new Font("Arial", Font.PLAIN, 80));
	

		g2.drawString("PONG",512-117,100);
	g2.setFont(new Font("Arial", Font.PLAIN, 40));
	
	singlePlayer.draw(g2);
	singlePlayerMedium.draw(g2);
	singlePlayerHard.draw(g2);
	twoPlayer.draw(g2);
	
	
	
	}else if( gameState == 1){
	ball.draw(g2);
	rightPaddle.draw(g2);
	leftPaddle.draw(g2);
	
	
	//drawing scores
	
	
	g2.drawString(String.valueOf(p1Score),10,50);
	g2.drawString(String.valueOf(p2Score),900,50);
	
	
	}
	g2.dispose();
	}
	
	public void twoPlayPong(){
		p1Score = 0;
		p2Score = 0;
		leftPaddle.reset();
		rightPaddle.reset();
		boolean serve = false;
		while (p1Score < 7 && p2Score < 7){
			playRound(serve);
			serve  = !serve;
			
		}
		gameState = menuState;
		
	}
	
	public void playRound(boolean serve){
		ball.reset(serve);
		while(gameThread != null){
			
			
			
			update();
			repaint();
			
			if(ball.isOut() != 0){
				if (ball.isOut() == 1){
					p1Score++;
				} else{
					p2Score++;
				}
				break;
				
			}
			
			synchronized (this){
			try{
			this.wait(8);
			
			} catch (InterruptedException ex){
				System.out.println("error with thread wait");
			}
			
		}
		
		}
		
		
		
		
	}
	
		
		
		
	
	
	
	
	

}