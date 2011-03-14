// custom keyboard listener to watch for arrow keys and then dispath actions
//  to server

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MoveListener implements KeyListener {

    private boolean movingUp;
    private boolean movingDown;
    private boolean movingRight;
    private boolean movingLeft;


    public void keyPressed(KeyEvent e) {
	if(e.getKeyCode()==KeyEvent.VK_UP)
	    movingUp=true;
	if(e.getKeyCode()==KeyEvent.VK_DOWN)
	    movingDown=true;
	if(e.getKeyCode()==KeyEvent.VK_RIGHT)
	    movingRight=true;
	if(e.getKeyCode()==KeyEvent.VK_LEFT)
	    movingLeft=true;
    } //keyPressed


    public void keyReleased(KeyEvent e) {
	if(e.getKeyCode()==KeyEvent.VK_UP)
	    movingUp=false;
	if(e.getKeyCode()==KeyEvent.VK_DOWN)
	    movingDown=false;
	if(e.getKeyCode()==KeyEvent.VK_RIGHT)
	    movingRight=false;
	if(e.getKeyCode()==KeyEvent.VK_LEFT)
	    movingLeft=false;
    } //keyReleased



    public void submit() {
	//sends some move action off to server
	// *will not work well if two keys are pressed at once
	String message=null;
	if(movingUp) message=GameActionType.MOVE_UP.toString();
	if(movingDown) message=GameActionType.MOVE_DOWN.toString();
	if(movingRight) message=GameActionType.MOVE_RIGHT.toString();
	if(movingLeft) message=GameActionType.MOVE_LEFT.toString();

	if(message!=null) Client.sendMessage(message);
    } //submit




    public void keyTyped(KeyEvent e) {  }



} //class