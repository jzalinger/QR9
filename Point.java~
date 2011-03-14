

public class Point {

    private boolean[] data;

    public Point(String _data) {
	data = new boolean[1];

	if (_data.equals("e")) { //empty space
	    data[0] = true;
	} else if (_data.equals("w")) { //wall
	    data[0] = false;
	} else { //defaul case
	    data[0] = false;
	}
    } //constructor

    public boolean isPathable() {
	return data[0];
    } //isPathable
}