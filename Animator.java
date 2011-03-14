// thread for updating UI in real time


public class Animator implements Runnable {

    private static final int delay=80; //in ms
    private Output parent;
    private boolean running;


    public Animator(Output o) {
	parent=o;
    } //constructor



    public synchronized void run() {
	try {
	    while(true) {
		wait(delay);
		if(running) parent.update();
	    }
	} catch(InterruptedException e) {
	    System.err.println("ERROR: animator was interrupted: "+e);
	}
    } //run



    public synchronized void resume() {
	running=true;
    } //synchronized


    public synchronized void pause() {
	running=false;
    } //pause



} //class
