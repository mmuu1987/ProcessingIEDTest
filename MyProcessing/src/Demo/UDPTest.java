package Demo;

import processing.core.PApplet;
import hypermedia.net.*;

public class UDPTest extends PApplet {

	UDP udp;
  @Override 
  public void settings() { 
   size(800, 200,P2D); 
   udp = new UDP(this, 6000 );
   udp.setBuffer(1024);
   //udp.log( true ); 		// <-- printout the connection activity
   udp.listen( true );
   udp.setReceiveHandler("myReceive");	
   println(udp.isListening());
  } 

  @Override 
  public void draw() { 
  
  } 

  public void myReceive(byte[] data, String ip, int port)
  {
 
	  String message = new String( data );
	  
	  // print the result
	  println( "receive: \""+message+"\" from "+ip+" on port "+port );
  }
 
  void receive( byte[] data, String ip, int port ) {	// <-- extended handler
	  
	  
	  // get the "real" message =
	  // forget the ";\n" at the end <-- !!! only for a communication with Pd !!!
	 // data = subset(data, 0, data.length-2);
	  String message = new String( data );
	  
	  // print the result
	  println( "receive: \""+message+"\" from "+ip+" on port "+port );
	}
  
  
  public static void main (String... args) { 
	  UDPTest pt = new UDPTest(); 
   PApplet.runSketch(new String[]{"UDPTest"}, pt); 
  }
}
