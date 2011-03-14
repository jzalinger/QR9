// simple component for helping manipulate layout

import java.awt.*;
import javax.swing.*;


public class Rectangle extends JComponent {

    private int w;
    private int h;
    private Color color;

 
   public Rectangle(int x,int y) {
	setPreferredSize(new Dimension(x,y));
	w=x;
	h=y;
    } //constructor

    public Rectangle(int x,int y,Color c) {
	this(x,y);
	color=c;
    } //constructor2



    public void paintComponent(Graphics g) {
	if(color!=null) {
	    g.setColor(color);
	    g.fillRect(0,0,w,h);
	}
    } //paintComponent



} //class