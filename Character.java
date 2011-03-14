// superlcass for anyhting that can take actions (PCs, NPCs)


public abstract class Character {


    private static final int maxCooldown=1; //what cooldown is after acting
    private int cooldown; //turns until action can be taken
    private GameActionType queuedAction;
    private static final int mapSize=3; //mapTiles x mapTiles they inhabit
    private Point mapCenter; //center point they inhabit



    public void decCooldown() {
	if(cooldown>0) cooldown--;
    } //decCooldown


    public boolean canAct() {
	return cooldown<=0 && queuedAction!=null;
    } //canAct


    public GameAction dequeueAction() {
	GameAction a=new GameAction(queuedAction,this);
	queuedAction=null;
	cooldown=maxCooldown;
	return a;
    } //dequeueAction


    public void newAction(GameActionType t) {
	if(queuedAction==null) queuedAction=t;
    } //newAction

    public Point getMapCenter() {
	return mapCenter;
    } //getMapCenter

    public void setMapCenter(Point p) {
	mapCenter = p;
    } //setMapCenter

    public static int getMapSize() {
	return mapSize;
    } //getMapSize


} //class