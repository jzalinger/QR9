// parametized random map gnerator
//  *when run, output should be piped into map text file

//  *for now, only does rocks and spawn point

import java.util.Random;


public class MapGen {

    private static int size; //all maps are square
    private static double rockFreq; // [0-1) range
    private static Random random;
    private static boolean[][] grid;
    //--->baddie difficulty
    //--->resource frequency


    public static void main(String[] args) {
	if(args.length!=2 && args.length!=3) {
	    System.err.println("USAGE: <size> <rock freq> <optional: seed>");
	    System.exit(0);
	}

	size=Integer.parseInt(args[0]);
	rockFreq=Double.parseDouble(args[1])%1;
	long seed=(long)(Math.random()*100000);
	if(args.length==3) seed=Long.parseLong(args[2]);
	random=new Random(seed);

	//print size,spawn
	System.out.println(size+" "+size);
	System.out.println(size/2+" "+(size/2));

	grid=new boolean[size][size];
	// value = "is rocks here"
	for(int i=0;i<size;i++)
	    for(int j=0;j<size;j++)
		grid[i][j]=false;

	//create and expand rocks:
	int rockSeeds=(int)((size/10.0)*(rockFreq*(0.9+random.nextDouble()*0.2)));
	/* ** */System.err.println(rockSeeds);
	for(int i=0;i<rockSeeds;i++) {
	    int rx=(int)(random.nextDouble()*size);
	    int ry=(int)(random.nextDouble()*size);
	    makeRock(rx,ry,0);
	}

	//clear area around spawn:
	int diff=size/2-10;
	for(int i=-10;i<=20;i++)
	    for(int j=-10;j<=20;j++)
		grid[i+diff][j+diff]=false;


	//print grid spaces:
	for(int i=0;i<size;i++)
	    for(int j=0;j<size;j++) {
		if(grid[i][j]) System.out.print("w ");
		else System.out.print("e ");
	    }
    } //main



    private static void makeRock(int x,int y,int depth) {
	if(depth>10 || random.nextDouble()*(depth/1.5)>0.8) return;
	grid[x][y]=true;
	
	if(x>0) makeRock(x-1,y,depth+1);
	if(x<size-1) makeRock(x+1,y,depth+1);
	if(y>0) makeRock(x,y-1,depth+1);
	if(y<size-1) makeRock(x,y+1,depth+1);
    } //makeRock





} //class