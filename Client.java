// client side program for connecting to server

import java.net.*;
import java.io.*;
import java.util.*;


public class Client implements Runnable {

    private static Socket socket;
    private static PrintStream out;
    private static Output output;
    private static ClientData data;
    private static Object datalock;


    public static void main(String[] args) {
	try {
	    datalock=new Object();
	    data=new ClientData();
	    output=new GUI();

	    socket=new Socket("192.168.1.10",2000);
	    out=new PrintStream(socket.getOutputStream());

	    (new Thread(new Client())).start();
	    /*	    
	    Scanner sc=new Scanner(System.in);
	    while(sc.hasNextLine()) {
		out.println(sc.nextLine());
		out.flush();
	    }
	    */
	}
	catch(IOException e) {
	    System.out.println("error: "+e);
	    System.exit(1);
	}
    } //main



    public static void sendMessage(String s) {
	out.println(s);
	out.flush();
    } //sendMessage



    public void run() {
	//handles text coming FROM socket
	try {
	    Scanner in=new Scanner(socket.getInputStream());
	    while(in.hasNextLine()) {
		String encoding=in.nextLine();
		try { 
		    ClientData temp=new ClientData(encoding);
		    synchronized(datalock) { 
			data=temp;
		    }
		} catch(BadFormatException e) { 
		    /* ** */System.out.println("bad: \""+encoding+"\"");
		    output.badUpdate();
		}
	    }
	}
	catch(IOException e) {
	    System.err.println("error: "+e);
	}
    } //run




    public static ClientData getData() {
	synchronized(datalock) {
	    return data;
	}
    } //getData




} //class