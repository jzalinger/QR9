// client side version of game data; only stuff that's relevant to client's PC

import java.util.Scanner;


public class ClientData {


    // ********* this is a WAY simplified version ************

    private int xCoord;
    private int yCoord; //coords of character's middle
    private char[][] points;

    public ClientData() {
	xCoord=-1;
	yCoord=-1;
	points = new char[GameData.CLIENT_VISION_DIAMETER][GameData.CLIENT_VISION_DIAMETER];
    } //empty constructor

    public ClientData(String encoding) {
	points = new char[GameData.CLIENT_VISION_DIAMETER][GameData.CLIENT_VISION_DIAMETER];
	for (int y = 0; y < GameData.CLIENT_VISION_DIAMETER; y++) {
	    for (int x = 0; x < GameData.CLIENT_VISION_DIAMETER; x++) {
		points[x][y] = encoding.charAt(y*GameData.CLIENT_VISION_DIAMETER + x);
	    }
	}
    } //real constructor





    ////////////// ACCESSORS /////////////////

    public int getXCoord() {
	return xCoord;
    } //getXCoord

    public int getYCoord() {
	return yCoord;
    } //getYCoord

    public char getPoint(int x, int y) {
	return points[x][y];
    } //getPoint


} //class