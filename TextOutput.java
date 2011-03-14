// shell-only UI

import java.util.*;


public class TextOutput extends Output {


    public TextOutput() {
	super();
    } //constructor



    public void update() {
	ClientData data=Client.getData();
	for(int i=0;i<40;i++) System.out.println();

	if(data==null) {
	    System.out.println(" No available data.");
	    System.out.println();
	} else {
	    // very simplified version: 
	    System.out.println("  Location:  ("+data.getXCoord()+", "+data.getYCoord()+")");
	    System.out.println();
	}
    } //update



    public void badUpdate() {
	System.out.println();
	System.out.println();
	System.out.println(" warning: badly formatted update");
    } //badUpdate




} //class