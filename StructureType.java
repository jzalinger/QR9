// enum for defining the characteristics of different structures


public enum StructureType {


    Main("Refuge",'M',9,9);



    private int width;
    private int height;
    private String name;
    private char mapChar;
    //--->health
    //--->cost
    //--->etc


    private StructureType(String s,char c,int w,int h) {
	name=s;
	mapChar=c;
	width=w;
	height=h;
    } //constructor


    public int getWidth() {
	return width;
    } //getWidth

    public int getHeight() {
	return height;
    } //getHeight

    public char getMapChar() {
	return mapChar;
    } //getMapChar

    public String toString() {
	return name;
    } //toString


} //enum