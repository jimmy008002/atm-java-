package gui;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;


public class frame extends JFrame
{
		
	  Keypad key1 = new Keypad();
	  public display key2 = new display();
	 public frame()
	   {
	      super( "ATM" );
	      	      		      	      
	    add(key1,BorderLayout.WEST);		      
	    add(key2,BorderLayout.EAST);
		      this.setSize( 900, 650); // set frame size
		      this.setVisible( true ); // display frame
		      this.setResizable( false );
	    		      
	   }
	 public void settext(String input) 
	    {			
			key2.settext( input );					
		}	 
	 public int getinput() 
	 {	 
	  int b =key1.getinput(); 
	  key2.clear();
	  return b;
	  
     }	 	 
}
