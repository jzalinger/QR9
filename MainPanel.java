// second tier graphics class

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;


public class MainPanel extends JPanel {

    private WCanvas canvas;
    private JLabel alertLabel;
    private MoveListener listener;
    private int alertClear; //cycles until alert disappears
    private static final int MAX_ALERT_CLEAR=10;


    public MainPanel(int w,int h) {
	super();
	setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	setBorder(new LineBorder(Color.BLACK,2));
	setPreferredSize(new Dimension(w,h));
	listener=new MoveListener();

	canvas=new WCanvas(Math.max(w,h),Math.max(w,h));
	add(canvas);
	add(new Rectangle(w,2,Color.BLACK));
	alertLabel=new JLabel("ini");
	add(alertLabel);
	add(new Rectangle(1,200));
	canvas.setFocusable(true);
	canvas.addKeyListener(listener);
	setFocusable(false);
    } //constructor



    public void update() {
	canvas.update();
	canvas.requestFocusInWindow();
	listener.submit();
	//new alerts:
	alertClear--;
	if(alertClear<=0) alertLabel.setText("");

	repaint();
    } //update


    public void badUpdate() {
	alertLabel.setText(" Bad Update");
	alertClear=MAX_ALERT_CLEAR;
    } //badUpdate



} //class