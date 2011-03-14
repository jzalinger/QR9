// a very small unit of discrete linear distance

public class Point {

    private int myX;
    private int myY;

    private boolean[] data;
    private static final int NUM_DATA = 2;
    private static final int PATHABLE = 0;
    private static final int OCCUPIED = 1;

    public Point(String _data, int _x, int _y) {
	myX = _x;
	myY = _y;

	data = new boolean[NUM_DATA];

	if (_data.equals("e")) { //empty space
	    data[PATHABLE] = true;
	} else if (_data.equals("w")) { //wall
	    data[PATHABLE] = false;
	} else { //default case
	    data[PATHABLE] = false;
	}
	data[OCCUPIED] = false;
    } //constructor

    public Point(int _x, int _y) {
	myX = _x;
	myY = _y;
	data = new boolean[NUM_DATA];
	data[PATHABLE] = false;
	data[OCCUPIED] = false;
    } //constructor for "null" points

    //*********************util methods*******************//
    //@method: call only after isOccupied returns false
    public void occupy() {
	data[OCCUPIED] = true;
    } //occupy

    public void vacate() {
	data[OCCUPIED] = false;
    } //vacate

    public String parseToString() {
	if (data[PATHABLE])
	    return "p";
	else return "b";
    } //parseToString

    //*******************accessor methods*****************//
    public int getX() {
	return myX;
    } //getX

    public int getY() {
	return myY;
    } //getY

    public boolean isPathable() {
	return data[PATHABLE];
    } //isPathable

    public boolean isOccupied() {
	return data[OCCUPIED];
    } //isOccupied
}