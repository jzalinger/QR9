// client side program for connecting to server

import java.net.*;
import java.io.*;
import java.util.*;


public class Client implements Runnable {


    private static Socket socket;
    private static PrintStream out;


    public static void main(String[] args) {
	try {
	    socket=new Socket("rigel.cs.amherst.edu",2346);
	    out=new PrintStream(socket.getOutputStream());

	    (new Thread(new Client())).start();
	    
	    Scanner sc=new Scanner(System.in);
	    while(sc.hasNextLine()) {
		out.println(sc.nextLine());
		out.flush();
	    }
	}
	catch(IOException e) {
	    System.out.println("error: "+e);
	}
    } //main





    public void run() {
	//handles text coming FROM socket
	try {
	    Scanner in=new Scanner(socket.getInputStream());
	    while(in.hasNextLine())
		System.out.println(in.nextLine());
	}
	catch(IOException e) {
	    System.err.println("error: "+e);
	}
    } //run



} //class