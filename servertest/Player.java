

public class Player {

    private int ID;
    private int myX;
    private int myY;

    public Player(int _ID) {
	ID = _ID;
	myX=1;
	myY=1;
    } //constructor

    public void setPosition(int _x, int _y) {
	myX = _x;
	myY = _y;
    } //setPosition

    public int getX() {
	return myX;
    } //getX

    public int getY() {
	return myY;
    } //getY

    public int getID() {
	return ID;
    } //getID
}