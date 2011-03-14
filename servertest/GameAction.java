// instance of a particular action undertaken by a PC


public class GameAction {


    private GameActionType type;
    private Player owner;



    public GameAction(Player p,GameActionType t) {
	owner=p;
	type=t;
    } //constructor

    public Player getPlayer() {
	return owner;
    } //getPlayer

    public GameActionType getType() {
	return type;
    } //getType


} //class