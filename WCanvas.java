// parts of GUI that displays map

import java.awt.*;
import javax.swing.*;


public class WCanvas extends JComponent {

    private int w;
    private int h;
    private ClientData data;
    private static final int POINT_SIZE = 7;


    public WCanvas(int w,int h) {
	this.w=w;
	this.h=h;
	setPreferredSize(new Dimension(w,h));
	setBackground(Color.WHITE);
	data=new ClientData(); //with default info
    } //constructor



    public void update() {
	//fetch latest version of data
	data=Client.getData();
    } //update



    public void paintComponent(Graphics g) {
	//paint passable/unpassable:
	for (int y = 0; y < GameData.CLIENT_VISION_DIAMETER; y++) {
	    for (int x = 0; x < GameData.CLIENT_VISION_DIAMETER; x++) {
		if (data.getPoint(x, y) == 'p') {
		    g.setColor(Color.WHITE);
		} else if (data.getPoint(x, y) == 'b') {
		    g.setColor(Color.BLACK);
		} else {
		    g.setColor(Color.RED);
		}
		g.fillRect(x*POINT_SIZE, y*POINT_SIZE, POINT_SIZE, POINT_SIZE);
	    }
	}
	//paint PC:
	g.setColor(Color.GRAY);
	int middle=(GameData.CLIENT_VISION_DIAMETER/2-1)*POINT_SIZE;
	int size=POINT_SIZE*Character.getMapSize();
	g.fillOval(middle,middle,size,size);

    } //paintComponent


} //class