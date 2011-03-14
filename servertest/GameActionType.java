// all distinct actions a player can perform


public enum GameActionType {


    MOVE_UP("MoveUp"),MOVE_DOWN("MoveDown"),MOVE_RIGHT("MoveRight"),MOVE_LEFT("MoveLeft");



    private String name;


    private GameActionType(String s) {
	name=s;
    } //constructor



    public static GameActionType parse(String s) {
	for(GameActionType type:values())
	    if(type.name.equals(s)) return type;
	return null;
    } //parse



} //enum