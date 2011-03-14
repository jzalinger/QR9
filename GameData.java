import java.util.*;

public class GameData {

    private LinkedList<Character> allCharacters;
    private LinkedList<Structure> allStructures;
    private Region region;
    public static final int CLIENT_VISION_DIAMETER = 63;


    public GameData() {
	allCharacters = new LinkedList<Character>();
	allStructures = new LinkedList<Structure>();
	region = new Region("map.txt");
	Structure main = new Structure(StructureType.Main,region.getPoint(region.getSpawn().getX(),region.getSpawn().getY()));
	allStructures.add(main);
	region.placeStructure(main);
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
	    Structure s=structureAt(temp);
	    if(s!=null) encoding+=s.getMapChar();
	    else if(characterAt(temp)!=null && characterAt(temp)!=c) 
		encoding+=Character.getMapSize();
	    else encoding += temp.parseToString();
	}
	return encoding;
    } //getEncoding

    public LinkedList<Character> getAllCharacters() {
	return allCharacters;
    } //getAllCharacters

    public Region getRegion() {
	return region;
    } //getRegion

    public Character characterAt(Point p) {
	for(Character c:allCharacters)
	    if(c.getMapCenter()==p) return c;
	return null;
    } //isCharacterAt

    private Structure structureAt(Point p) {
	for(Structure s:allStructures)
	    if(s.getLocation()==p) return s;
	return null;
    } //structureAt


} //clas