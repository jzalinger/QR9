// server for testing what servers are

import java.util.*;
import java.net.*;
import java.io.*;


public class Server {


    private static Object lock; //for synchronization
    private static LinkedList<AccountExec> accounts;
    // *an "account" is a server-side thread for managing a connected client
    private static Game game;


    public static void main(String[] args) {
	lock=new Object();
	accounts=new LinkedList<AccountExec>();
	game=new Game();
	try {
	    ServerSocket serverSocket=new ServerSocket(2346);
	    System.out.println("Starting server...");	    

	    while(true) {
		//accept new clients:
		Socket s=serverSocket.accept();
		synchronized(lock) { //neccessary?
		    AccountExec exec=new AccountExec(s,accounts.size());
		    game.addPlayer(exec.getPlayer());
		    accounts.add(exec);
		    (new Thread(exec)).start();
		    System.out.println("New account: "+exec);
		}
	    }
	} catch(IOException e) {
	    System.err.println("error: "+e);
	}
    } //main




    public static void submitAction(GameAction a) {
	synchronized(lock) {
	    game.submitAction(a);
	}
    } //submitAction





    public static void removeAccount(AccountExec accnt) {
	synchronized(lock) {
	    accounts.remove(accnt);
	    game.removePlayer(accnt.getPlayer());
	    System.out.println("Removed: "+accnt);
	}
    } //removeAccount



} //class