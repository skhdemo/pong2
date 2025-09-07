/*
 * This code is protected under the Gnu General Public License (Copyleft), 2005 by
 * IBM and the Computer Science Teachers of America organization. It may be freely
 * modified and redistributed under educational fair use.
 */

/*
 * modified by Sepehr Khodadadi
 * 11/20/2024
 */

 import java.awt.Color;

 import javax.swing.ImageIcon;
 import javax.swing.JLabel;
 
 import csta.ibm.pong.GameObject;
 
 /**
  * Class representing the ball
  * @author 440017524
  *
  */
 
 public class Ball extends GameObject {
	 // Add any state variables here
	 
	 private int dx = 4;
	 private int dy = 4;
	 private final int MAX_ANGEL = 8; // Define a constant for the maximum angle change
	 
	 public Ball(int x, int y){
		 setSize(25, 25);
		 setX(x);
		 setY(y);
		 setColor(Color.BLACK);
	 }
	 
	 /**
	  * This method can consist the functionalities that are only particular to paddle in every act of the game. 
	  */
	 public void act() {
		 setX(getX() + dx);
		 setY(getY() + dy);
		 
	 }
	 
	 // Add any additional methods here
	 
	 /**
	  * Speed change for when the ball collides with the wall.
	  */
	 public void bounceWall(){
		 dy *= -1;
	 }
	 
	 /**
	  * Speed change of the ball when uit collides with a paddle 
	  * @param normalizedImpact
	  */
	  public void bouncePaddle(double normalizedImpact) {
		// Reverse horizontal direction to make the ball bounce
		dx = -dx;
	
		// Segment the paddle into 3 parts:
		// The middle part doesn't change the angle, while top and bottom do.
		if (normalizedImpact < -0.33) {
			// Ball hits the top part of the paddle
			dy = (int)(normalizedImpact * MAX_ANGEL); // Steeper angle
		} else if (normalizedImpact > 0.33) {
			// Ball hits the bottom part of the paddle
			dy = (int)(normalizedImpact * MAX_ANGEL); // Steeper angle
		} else {
			// Ball hits the middle part of the paddle (straight bounce)
			dy = 0;
		}
	
		// Ensure the ball has a minimum vertical speed to prevent it from becoming stuck
		if (dy == 0) {
			dy = (dx > 0) ? 1 : -1; // Apply a slight vertical speed if the ball hits the center
		}
	}
	
	 
	 /**
	  * This method stops the ball and places it in a very far location.
	  */
	 public void stopBall(){
		 dy = 0;
		 dx = 0;
		 setLocation(1000, 1000); // this line sets the location to a very far location so that it does not block the middle line when game finishes 
	 }
	 
	 /**
	  * This method starts moving the ball.
	  */
	 public void startBall(){
		 dy = 4;
		 dx = 4; 
	 }
 
	 /**
	  * Getter method to get the x speed of the ball.
	  * @return
	  */
	 public int getDx(){
		 return dx;
	 }
	 
	 /**
	  * Getter method to get the y speed of the ball.
	  * @return
	  */
	 public int getDy(){
		 return dy;
	 }
 }