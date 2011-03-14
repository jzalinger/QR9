// instance of a particular action undertaken by a PC


public class GameAction {


    private GameActionType type;
    private Character owner;



    public GameAction(GameActionType t, Character c) {
	owner=c;
	type=t;
    } //constructor


    public GameActionType getType() {
	return type;
    } //getType


    public Character getOwner() {
	return owner;
    } //getOwner


} //class