import java.util.*;

public class Game {

    private GameData data;
    private GameEngine engine;
    private LinkedList<Player> players;

    public Game() {
	data = new GameData();
	engine=new GameEngine(this);
	players = new LinkedList();
	(new Thread(engine)).start();
	engine.resume();
    } //constructor



    public void addPlayer(Player _p) {
	players.add(_p);
	data.getAllCharacters().add(_p);
	data.getRegion().placeCharacter(_p, 2, 2);
    } //addPlayer


    public void removePlayer(Player _p) {
	players.remove(_p);
    } //removePlayer

    public GameData getData() {
	return data;
    } //getData


} //class