import java.util.*;
import java.io.*;

public class Region {

    private Point[][] points;
    private GridManager gridManager;

    public Region(String _file) {
	Scanner sc;
	try {
	    sc = new Scanner(new File(_file));
	} catch (FileNotFoundException e) {
	    return;
	}
	try {
	    points = new Point[sc.nextInt()][sc.nextInt()];
	    
	    for (int y = 0; y < points.length; y++) {
		for (int x = 0; x < points[0].length; x++) {
		    points[x][y] = new Point(sc.next(), x, y);
		}
	    }
	} catch (InputMismatchException e) {
	} catch (NoSuchElementException e) {
	} catch (IllegalStateException e) {
	}

	gridManager = new GridManager(this);
    } //constructor

    //@method: CAN RESULT IN STACKED CHARACTERS AND ERRORS IN POINTS
    public void placeCharacter(Character c, int _x, int _y) {
	c.setMapCenter(getPoint(_x, _y));
	for (Point p: gridManager.getRegion(c.getMapCenter(), c.getMapSize())) {
	    p.occupy();
	}
    } //placeCharacter

    public Point getPoint(int _x, int _y) {
	try {
	    return points[_x][_y];
	} catch (ArrayIndexOutOfBoundsException e) {
	    return new Point(_x, _y);
	}
    } //getPoint

    public GridManager getGridManager() {
	return gridManager;
    } //getGridManager
}