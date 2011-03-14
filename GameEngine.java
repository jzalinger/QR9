// thread that makes mechanics go, executes actions at the right time, etc


public class GameEngine implements Runnable {


    private Game parent;
    private static final int delay=50; //in ms
    private boolean running;


    public GameEngine(Game g) {
	parent=g;
	running=false;
    } //constructor



    public synchronized void run() {
	try {
	    while(true) {
		wait(delay);
		if(running) {
		    process();
		}
	    }
	} catch(InterruptedException e ) {
	    System.err.println("ERROR: game engine has been interrupted: "+e);
	    System.exit(1);
	} 
    } //run




    private synchronized void process() {

	//allow each game character to act (if able and willing):
	for(Character c:parent.getData().getAllCharacters()) {
	    c.decCooldown();
	    if(c.canAct()) parent.getData().submitAction(c.dequeueAction());
	}

	//--->all attacks/etc take effect

	//send new info to all clients:
	Server.updateClientData();

    } //process




    public synchronized void resume() {
	running=true;
    } //resume


    public synchronized void pause() {
	running=false;
    } //pause

} //class