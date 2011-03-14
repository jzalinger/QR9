import java.util.LinkedList;

public class GridManager {

    private Region region;

    public GridManager(Region _region) {
	region = _region;
    } //constructor

    //********************command methods******************//
    public void moveCharTo(GameAction action) {
	Character c = action.getOwner();
	GameActionType type = action.getType();
	boolean canMoveTo = true;
	int size = c.getMapSize();
	Point center = c.getMapCenter();
	Point temp;

	if (type == GameActionType.MOVE_UP) {
	    for (int i = 0; i < size; i++) {
	        temp = getRelativePoint(getUpperLeft(center, (size-1)/2), i, -1);

		if (temp == null || !canMoveTo(temp)) {
		    canMoveTo = false;
		    break;
		}
	    }
	} else if (type == GameActionType.MOVE_DOWN) {
	    for (int i = 0; i < size; i++) {
		temp = getRelativePoint(getLowerLeft(center, (size-1)/2), i, 1);

		if (temp == null || !canMoveTo(temp)) {
		    canMoveTo = false;
		    break;
		}
	    }
	} else if (type == GameActionType.MOVE_LEFT) {
	    for (int i = 0; i < size; i++) {
		temp = getRelativePoint(getUpperLeft(center, (size-1)/2), -1, i);

		if (temp == null || !canMoveTo(temp)) {
		    canMoveTo = false;
		    break;
		}
	    }
	} else if (type == GameActionType.MOVE_RIGHT) {
	    for (int i = 0; i < size; i++) {
		temp = getRelativePoint(getUpperRight(center, (size-1)/2), 1, i);

		if (temp == null || !canMoveTo(temp)) {
		    canMoveTo = false;
		    break;
		}
	    }
	}

	if (canMoveTo) {
	    executeMove(action);
	}
    } //moveCharTo

    private void executeMove(GameAction action) {
	Character c = action.getOwner();
	GameActionType type = action.getType();
	int size = c.getMapSize();
	Point center = c.getMapCenter();
	Point temp;

	if (type == GameActionType.MOVE_UP) {
	    for (int i = 0; i < size; i++) {
	        temp = getRelativePoint(getUpperLeft(center, (size-1)/2), i, 0);
		temp.occupy();
		temp = getRelativePoint(getLowerLeft(center, (size-1)/2), i, 0);
		temp.vacate();
	    }
	    center = getRelativePoint(center, 0, -1);
	} else if (type == GameActionType.MOVE_DOWN) {
	    for (int i = 0; i < size; i++) {
		temp = getRelativePoint(getLowerLeft(center, (size-1)/2), i, 0);
		temp.occupy();
		temp = getRelativePoint(getUpperLeft(center, (size-1)/2), i, 0);
		temp.vacate();
	    }
	    center = getRelativePoint(center, 0, 1);
	} else if (type == GameActionType.MOVE_LEFT) {
	    for (int i = 0; i < size; i++) {
		temp = getRelativePoint(getUpperLeft(center, (size-1)/2), 0, i);
		temp.occupy();
		temp = getRelativePoint(getUpperRight(center, (size-1)/2), 0, i);
		temp.vacate();
	    }
	    center = getRelativePoint(center, -1, 0);
	} else if (type == GameActionType.MOVE_RIGHT) {
	    for (int i = 0; i < size; i++) {
		temp = getRelativePoint(getUpperRight(center, (size-1)/2), 0, i);
		temp.occupy();
		temp = getRelativePoint(getUpperLeft(center, (size-1)/2), 0, i);
		temp.vacate();
	    }
	    center = getRelativePoint(center, 1, 0);
	}

	c.setMapCenter(center);
    } //executeMove

    //*********************util methods********************//
    //@return: null if return is out of array
    public Point getRelativePoint(Point p, int dx, int dy) {
	return region.getPoint(p.getX() + dx, p.getY() + dy);
    } //getRelativePoint

    //@return: true if p is unoccupied and pathable
    public boolean canMoveTo(Point p) {
	return (p.isPathable() && !p.isOccupied());
    } //canMoveTo

    public boolean canMoveTo(Point center,int size) {
	for(Point p:getRegion(center,size))
	    if(!canMoveTo(p)) return false;
	return true;
    } //canMoveTo2

    private Point getUpperLeft(Point center, int size) {
	return getRelativePoint(center, -size, -size);
    } //getUpperLeft

    private Point getLowerLeft(Point center, int size) {
	return getRelativePoint(center, -size, size);
    } //getLowerLeft

    private Point getUpperRight(Point center, int size) {
	return getRelativePoint(center, size, -size);
    } //getUpperRight

    private Point getLowerRight(Point center, int size) {
	return getRelativePoint(center, size, size);
    } //getLowerRight

    //@param size: must be odd
    public LinkedList<Point> getRegion(Point center, int size) {
	LinkedList<Point> points = new LinkedList<Point>();
	Point temp;
	Point upperLeftCorner = getRelativePoint(center,
						 -(size-1)/2,
						 -(size-1)/2);

	for (int y = 0; y < size; y++) {
	    for (int x = 0; x < size; x++) {
		temp = getRelativePoint(upperLeftCorner, x, y);
		points.add(temp);
	    }
	}

	return points;
    } //getRegion
}