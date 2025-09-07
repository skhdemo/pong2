/*
 * This code is protected under the Gnu General Public License (Copyleft), 2005 by
 * IBM and the Computer Science Teachers of America organization. It may be freely
 * modified and redistributed under educational fair use.
 */

/**
 * modified by Sepehr Khodadadi
 * 11/20/2024
 */
import java.awt.Color;

import csta.ibm.pong.GameObject;

public class Paddle extends GameObject {
	// Add any state variables here


	public static final int DEFAULT_HEIGHT = 80;
	public static final int DEFAULT_WIDTH = 10;
	
	public Paddle(int x, int y){
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setX(x);
		setY(y);
		setColor(Color.WHITE);
	}
	
	/**
	 * This method can consist the functionalities that are only particular to paddle in every act of the game but not used.
	 */
	public void act() {
		
	}
	
	
	// Add any additional methods here
	
	/**
	 * This method makes the height of the paddle smaller.
	 */
	public void shrinkPaddle(){
		setSize(getWidth(), getHeight()-2);
		if(getHeight() < getWidth()){
			resetHeight();
		}
	}
	
	/**
	 * This method makes the height of the paddle back to normal.
	 */
	public void resetHeight(){
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	/**
	 * Method for up movement of paddles.
	 * @param p
	 */
	public void moveUp(int paddleSpeed){
		setY(getY() + paddleSpeed);
	}
	
	/**
	 * Method for down movement of paddles.
	 * @param p
	 */
	public void moveDown(int paddleSpeed){
		setY(getY() - paddleSpeed);
	}
}