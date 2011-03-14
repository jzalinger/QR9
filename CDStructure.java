// "client data structure"; simplified version of structure for client side data


public class CDStructure {

    private StructureType type;
    private Coord location;


    public CDStructure(StructureType t,Coord c) {
	type=t;
	location=c;
    } //constructor


    public Coord getLocation() {
	return location;
    } //getLocation


    public int getWidth() {
	return type.getWidth();
    } //getWidth


    public int getHeight() {
	return type.getHeight();
    } //getHeight


    public String toString() {
	return type.toString();
    } //toString


} //class