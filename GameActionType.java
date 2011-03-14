// all distinct actions a player can perform


public enum GameActionType {


    MOVE_UP,MOVE_DOWN,MOVE_RIGHT,MOVE_LEFT;




    public static GameActionType parse(String s) {
	for(GameActionType type:values())
	    if(type.toString().equals(s)) return type;
	return null;
    } //parse



} //enum