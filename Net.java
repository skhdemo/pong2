
import java.awt.Color;
import java.io.ObjectInputStream.GetField;

import csta.ibm.pong.GameObject;
import csta.ibm.pong.Game;



/**
 * 
 * @author 440017524
 * Class for the net GUI 
 */
public class Net extends GameObject {

	public Net(int x, int y, int width, int height){
		setSize(width, height);
		setX(x);
		setY(y);
		setColor(Color.WHITE);
	}

	/**
	 * This method can consist the functionalities that are only particular to net in every act of the game 
	 */
	public void act() {
		
	}

}
