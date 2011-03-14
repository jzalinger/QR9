// instance of some structure in game


public class Structure {

    private StructureType type;
    private Point location;
    //--->health, etc


    public Structure(StructureType _type,Point p) {
	type=_type;
	location=p;
    } //constructor


    public Point getLocation() {
	return location;
    } //getLocation

    public int getWidth() {
	return type.getWidth();
    } //getWidth

    public int getHeight() {
	return type.getHeight();
    } //getHeight

    public char getMapChar() {
	return type.getMapChar();
    } //getMapChar


} //class