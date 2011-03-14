import java.util.*;

public class Game {

    private Region region;
    private LinkedList<Player> players;

    public Game() {
	region = new Region("TEST_REGION.txt");
	players = new LinkedList();
    } //constructor

    public void submitAction(GameAction action) {
	int x = action.getPlayer().getX();
	int y = action.getPlayer().getY();

	if (action.getType() == GameActionType.MOVE_UP) {
	    y--;
	} else if (action.getType() == GameActionType.MOVE_DOWN) {
	    y++;
	} else if (action.getType() == GameActionType.MOVE_LEFT) {
	    x--;
	} else if (action.getType() == GameActionType.MOVE_RIGHT) {
	    x++;
	}

	if (region.canMoveTo(x, y)) {
	    action.getPlayer().setPosition(x, y);
	}
	
	/* ** */for(Player p:players) 
	    /* ** */System.out.println(p.getX()+" "+p.getY());
    } //submitAction

    public void addPlayer(Player _p) {
	players.add(_p);
    } //addPlayer

    public void removePlayer(Player _p) {
	players.remove(_p);
    } //removePlayer
}