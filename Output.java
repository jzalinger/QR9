// superclass for any kind of user interface


public abstract class Output {

    protected Animator animator;


    public Output() {
	//*should get called from any subclass constructor
	animator=new Animator(this);
	(new Thread(animator)).start();
    } //constructor


    public abstract void update();


    public abstract void badUpdate(); //called when update some server was 
    //  badly formatted


} //class