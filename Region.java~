import java.util.*;
import java.io.*;

public class Region {

    private Point[][] points;

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
		    points[x][y] = new Point(sc.next());
		}
	    }
	} catch (InputMismatchException e) {
	} catch (NoSuchElementException e) {
	} catch (IllegalStateException e) {
	}
    } //constructor

    public boolean canMoveTo(int _x, int _y) {
	if (_x < 0 || _y < 0 || _x > points[0].length || _y > points.length) {
	    return false;
	}

	return points[_x][_y].isPathable();
    } //canMoveTo
}