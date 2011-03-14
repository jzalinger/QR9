// top-level class for graphical output

import javax.swing.*;
import java.awt.*;


public class GUI extends Output {


    private WFrame frame;


    public GUI() {
	super();
	frame=new WFrame();
	animator.resume();
    } //constructor


    public void update() {
	frame.panel.update();
    } //update


    public void badUpdate() {
	frame.panel.badUpdate();
    } //badUpdate





    ///////////////////// INNER CLASS ////////////////////////

    private class WFrame extends JFrame {

	private MainPanel panel;

	private WFrame() {
	    super("Wasteland");
	    JPanel p=new JPanel(new FlowLayout());
	    setPreferredSize(new Dimension(500,600));
	    panel=new MainPanel(500,600);
	    p.add(panel);
	    setContentPane(p);
	    setVisible(true);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    pack();
	} //Frame


    } //WFrame class


} //class