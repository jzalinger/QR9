import java.util.*;

public class GameData {

    private LinkedList<Character> allCharacters;
    private Region region;

    public static final int CLIENT_VISION_DIAMETER = 63;

    public GameData() {
	allCharacters = new LinkedList<Character>();
	region = new Region("TEST_REGION.txt");
    } //constructor

    public void submitAction(GameAction action) {
	switch (action.getType()) {
	case MOVE_UP:
	case MOVE_DOWN:
	case MOVE_LEFT:
	case MOVE_RIGHT:
	    region.getGridManager().moveCharTo(action);
	    break;
	default:
	    break;
	}
    } //submitAction

    //@return: points are encoded from upper left to right, then down
    public String getEncoding(Character c) {
	LinkedList<Point> gridRegion = region.getGridManager().getRegion(
				      c.getMapCenter(), CLIENT_VISION_DIAMETER);
	ListIterator iter = gridRegion.listIterator();
	Point temp;
	String encoding = "";
	while (iter.hasNext()) {
	    temp = (Point)(iter.next());
	    encoding += temp.parseToString();
	}
	return encoding;
    } //getEncoding

    public LinkedList<Character> getAllCharacters() {
	return allCharacters;
    } //getAllCharacters

    public Region getRegion() {
	return region;
    } //getRegion
}