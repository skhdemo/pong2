/*
 * This code is protected under the Gnu General Public License (Copyleft), 2005 by
 * IBM and the Computer Science Teachers of America organization. It may be freely
 * modified and redistributed under educational fair use.
 */

 import java.io.ObjectInputStream.GetField;

 import javax.swing.ImageIcon;
 import javax.swing.JLabel;
 import javax.swing.JOptionPane;
 
 import csta.ibm.pong.Game;
 
 import java.awt.Font;
 import java.awt.Color;
 import java.awt.image.ReplicateScaleFilter;
 
 /**
  * Modified by Sepehr Khodadadi
  * 11/20/2024
  * @author 440017524
  */
 public class Pong extends Game {
	 // Add any state variables or object references here
	 private static Pong p;
	 private Ball ball;
	 private Paddle p1;
	 private Paddle p2;
	 private JLabel score1, score2;
	 private JLabel ballImage;
	 private Net net;
	 private int p1Score = 0;
	 private int p2Score = 0;
	 private int paddleSpeed = 7;
	 private boolean activePlayer = true; // variable for sound effect. true --> player1     false --> player2
	 
	 /**
	  * This method initializes the ball and paddles for each player and initializes the score system and JLabels for them.
	  */
	 public void setup() {
		 // Setting up the score system for player 1
		 score1 = new JLabel();
		 Font font = new Font("Arial", Font.BOLD, 30);
		 score1.setBounds(getFieldWidth()/2-60, 50, 100, 100); // the -60 pixel is just to make the scores symmetrical
		 score1.setForeground(Color.white);
		 score1.setFont(font);
		 score1.setText("" + p1Score);
		 add(score1);
		 
		 // Setting up the score system for player 2
		 score2 = new JLabel();
		 score2.setBounds(getFieldWidth()/2+50, 50, 100, 100); // the +50 pixel is just to make the scores symmetrical
		 score2.setForeground(Color.white);
		 score2.setFont(font);
		 score2.setText("" + p2Score);
		 add(score2);
 
		 // Setting up the ball
		 ball = new Ball(getFieldWidth()/2, getFieldHeight()/2); 
		 
		 // Setting up the players paddles
		 p1 = new Paddle(0, getFieldHeight()/2-Paddle.DEFAULT_HEIGHT/2);
		 p2 = new Paddle(getFieldWidth()-Paddle.DEFAULT_WIDTH, getFieldHeight()/2-Paddle.DEFAULT_HEIGHT/2);
		 add(p1);
		 add(p2);
		 
		 
		 // Ball image
		 ImageIcon icon = new ImageIcon("assets/ball.png");
		 ballImage = new JLabel(icon);
		 ballImage.setBounds(getFieldWidth()/2, getFieldHeight()/2, ball.getWidth(), ball.getHeight());
		 add(ballImage);
		 add(ball);
		 
		 // Net
		 net = new Net(getFieldWidth()/2+2, 0, 5, getFieldHeight());
		 add(net);
		 
		 // Repaint to fix the JLabel bug
		 repaint();
	 }
	 
	 
	 /**
	  * This method runs every time and in the game (each cycle) and checks for the win and scoring conditions and also ball movement and paddles movement. 
	  */
	 public void act() {
		setDelay(15);
		 // BallImage movement
		 ballImage.setLocation(ball.getX(), ball.getY());
		 
		 // Paddle movement based on user inputs
		 if(ZKeyPressed() && p1.getY() <= getFieldHeight() - p1.getHeight()){
			 p1.moveUp(paddleSpeed);
		 }
		 if(XKeyPressed() && p1.getY() >= 0){
			 p1.moveDown(paddleSpeed);
		 }
		 if(NKeyPressed() && p2.getY() <= getFieldHeight() - p2.getHeight()){
			 p2.moveUp(paddleSpeed);;
		 }
		 if(MKeyPressed() && p2.getY() >= 0){
			 p2.moveDown(paddleSpeed);
		 }
		 
		 // Ball movement
		 if(ball.getY() >= getFieldHeight()-ball.getHeight() || ball.getY() <= 0){
			 ball.bounceWall();
			 SoundPlayer.playSound("assets/wall.wav");
		 }
		 if ((ball.collides(p1) && ball.getDx() < 0) || (ball.collides(p2) && ball.getDx() > 0)) {
			// Get the paddle involved in the collision
			Paddle paddle = ball.collides(p1) ? p1 : p2;
		
			// Calculate the relative impact position (normalized to [-1, 1])
			double paddleCenter = paddle.getY() + (paddle.getHeight() / 2.0);
			double relativeImpact = (ball.getY() + (ball.getHeight() / 2.0)) - paddleCenter;
			double normalizedImpact = relativeImpact / (paddle.getHeight() / 2.0);
		
			// Adjust the ball's speed and angle based on the impact location
			ball.bouncePaddle(normalizedImpact);
		
			// Shrink paddles after collision
			p1.shrinkPaddle();
			p2.shrinkPaddle();
		
			// Play sound and toggle active player
			if (activePlayer) {
				SoundPlayer.playSound("assets/pong1.wav");
				activePlayer = !activePlayer;
			} else {
				SoundPlayer.playSound("assets/pong2.wav");
				activePlayer = !activePlayer;
			}
		}
		
		 
		 // Score and winning conditions
		 if(ball.getX() <= -ball.getWidth()/2){
			 reset();
			 p2Score++;
			 p1.resetHeight();
			 p2.resetHeight();
			 score2.setText("" + p2Score);
			 activePlayer = !activePlayer;
			 if(p2Score == 5){ // Player 2 winning
				 ball.stopBall();
				 SoundPlayer.playSound("assets/idk.wav");
				 AfterGameMessage("Player 2 won!  Rematch?");
			 }
		 }
		 if(ball.getX() >= getFieldWidth()-ball.getWidth()/2){
			 reset();
			 p1Score++;
			 p1.resetHeight();
			 p2.resetHeight();
			 score1.setText("" + p1Score);
			 activePlayer = !activePlayer;
			 if(p1Score == 5){ // Player 1 winning
				 ball.stopBall();
				 SoundPlayer.playSound("assets/idk.wav");
				 AfterGameMessage("Player 1 won!  Rematch?");
			 }
		 }
	 }
	 
	 
	 // Add any additional methods here
	 
	 /**
	  * This method put the ball in middle of the board and change the movement towards the person who got the score.
	  */
	 public void reset(){
		 ball.setY(getFieldHeight()/2);
		 ball.setX(getFieldWidth()/2);
		 ball.bouncePaddle(0.5);
	 }
	 
	 /**
	  * This method pops a message and asks the user if he wants to play again or not.
	  * @param message
	  */
	 public void AfterGameMessage(String message) {
		 // Show a JOptionPane with Yes and No options
		 int choice = JOptionPane.showConfirmDialog(
				 null,
				 message,
				 "Confirmation",
				 JOptionPane.YES_NO_OPTION,
				 JOptionPane.QUESTION_MESSAGE
		 );
 
		 // Return true for Yes, false for No
		 if(choice == JOptionPane.YES_OPTION){
			 resetGame();
		 }else{
			 System.exit(0);
		 }
	 }	
 
	 /**
	  * This method resets the. In details, it sets the scores back to zero and puts the ball in middle and make it move.
	  */
	 public void resetGame(){
		 // Resetting scores
		 p1Score = 0;
		 score1.setText("" + p1Score);
		 p2Score = 0;
		 score2.setText("" + p2Score);
		 ball.setLocation(getFieldWidth()/2, getFieldHeight()/2);
		 ball.startBall();
		 p1.setLocation(0, getFieldHeight()/2-Paddle.DEFAULT_HEIGHT/2);
		 p2.setLocation(getFieldWidth()-Paddle.DEFAULT_WIDTH, getFieldHeight()/2-Paddle.DEFAULT_HEIGHT/2);
		 activePlayer = !activePlayer;
	 }
 
	 /**
	  * Main method to start the game.
	  */
	 public static void main(String[] args) {
		 if (InstructionMenu.showInstructions()) {
			 p = new Pong();
			 p.setSize(800, 600);
			 p.setResizable(false);
			 p.setVisible(true);
			 p.initComponents();		
		 }
 
	 }
 }