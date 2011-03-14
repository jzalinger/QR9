// class/thread that manages server's interacions with a particular client

import java.net.*;
import java.util.*;
import java.io.*;


public class AccountExec implements Runnable {


    private Socket socket;
    private int id;
    private PrintWriter out;
    private BufferedReader in;
    private Player player; //in-game PC corresponding to this account


    public AccountExec(Socket s,int id) {
	socket=s;
	this.id=id;
	player=new Player(id);
	try {
	    out=new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
	    in=new BufferedReader(new InputStreamReader(s.getInputStream()));
	} catch(IOException e) {
	    System.err.println("WARNING: error while constructing in/out for account "+this);
	}
    } //constructor




    public void run() {
	// all clients do is submit messages, which this sends to the server
	try {
	    String s=in.readLine();
	    while(s!=null) {
		GameActionType type=GameActionType.parse(s);
		if(type==null) sendMessage("BadAction");
		else player.newAction(type);

		s=in.readLine();
	    }
	} catch(IOException e) {
	    System.err.println("WARNING: error while reading input from account"+this);
	}
	//done reading, close account:
	try {
	    socket.close();
	    Server.removeAccount(this);
	} catch(IOException e) {
	    System.err.println("WARNING: could not close socket for account "+this);
	}
    } //run



    public void sendMessage(String s) {
	out.println(s);
	out.flush();
    } //sendMessage





    /////////////////// ACCESSORS /////////////////////

    public String toString() {
	return "Account "+id;
    } //toString

    public Player getPlayer() {
	return player;
    } //getPlayer


} //class