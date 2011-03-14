import java.util.*;
import java.io.*;

public class Region {

    private Point[][] points;
    private GridManager gridManager;
    private Point spawn;

    public Region(String _file) {
	Scanner sc;
	try {
	    sc = new Scanner(new File(_file));
	} catch (FileNotFoundException e) {
	    return;
	}
	try {
	    points = new Point[sc.nextInt()][sc.nextInt()];
	    Coord tempSpawn=new Coord(sc.nextInt(),sc.nextInt());	    

	    for (int y = 0; y < points.length; y++) {
		for (int x = 0; x < points[0].length; x++) {
		    points[x][y] = new Point(sc.next(), x, y);
		}
	    }
	    spawn=getPoint(tempSpawn.getX(),tempSpawn.getY());
	} catch (InputMismatchException e) {
	} catch (NoSuchElementException e) {
	} catch (IllegalStateException e) {
	}

	gridManager = new GridManager(this);
    } //constructor

    //@method: CAN RESULT IN STACKED CHARACTERS AND ERRORS IN POINTS
    public void placeCharacter(Character c) {
	Point pt=spawn;
	boolean flag=true;
	for(int r=0;flag;r++) { //radius around spawn you're looking for
	    for(Point p:gridManager.getRegion(spawn,r))
		if(gridManager.canMoveTo(p,Character.getMapSize())) {
		    pt=p;
		    flag=false;
		    break; 
		}
	}
	//pt is now a place where PC can safely spawn
	c.setMapCenter(getPoint(pt.getX(),pt.getY()));
	for (Point p: gridManager.getRegion(c.getMapCenter(), c.getMapSize())) {
	    p.occupy();
	}
    } //placeCharacter

    public void placeStructure(Structure s) {
	//marks all points underneath it as occupied
	int x = s.getLocation().getX();
	int y = s.getLocation().getY();
	for(int i=0;i<s.getWidth();i++)
	    for(int j=0;j<s.getHeight();j++)
		getPoint(x+i,y+j).occupy();
    } //placeStructure

    public Point getPoint(int _x, int _y) {
	try {
	    return points[_x][_y];
	} catch (ArrayIndexOutOfBoundsException e) {
	    return new Point(_x, _y);
	}
    } //getPoint

    public GridManager getGridManager() {
	return gridManager;
    } //getGridManage

    public Point getSpawn() {
	return spawn;
    } //getSpawn


} //class