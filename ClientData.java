// client side version of game data; only stuff that's relevant to client's PC

import java.util.*;


public class ClientData {

    private char[][] points; //the map, centered at PC
    private LinkedList<Coord> npcs; //other characters (only PCs for now)
    private LinkedList<CDStructure> structures;
    // (int is their map radius)

    public ClientData() {
	points = new char[GameData.CLIENT_VISION_DIAMETER][GameData.CLIENT_VISION_DIAMETER];
	npcs = new LinkedList<Coord>();
	structures=new LinkedList<CDStructure>();
    } //empty constructor

    public ClientData(String encoding) {
	this();
	for (int y = 0; y < GameData.CLIENT_VISION_DIAMETER; y++) {
	    for (int x = 0; x < GameData.CLIENT_VISION_DIAMETER; x++) {
		char c = encoding.charAt(y*GameData.CLIENT_VISION_DIAMETER + x);
		//npcs:
		if(c>='0' && c<='9') {
		    npcs.add(new Coord(x,y)); //ignores size of guy
		    points[x][y]='p';
		}
		else points[x][y]=c;
		//structs:
		for(StructureType type:StructureType.values())
		    if(type.getMapChar()==c) {
			structures.add(new CDStructure(type,new Coord(x,y)));
			points[x][y]='p';
		    }
	    }
	}
    } //real constructor





    ////////////// ACCESSORS /////////////////

    public char getPoint(int x, int y) {
	return points[x][y];
    } //getPoint

    public LinkedList<Coord> getNPCs() {
	return npcs;
    } //getNPCs

    public LinkedList<CDStructure> getStructures() {
	return structures;
    } //getStructures


} //class