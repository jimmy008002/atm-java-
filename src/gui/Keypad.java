package gui;

// Program creates a GUI that resembles a ATM keypad
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JTextArea;
import java.awt.*;
import java.awt.event.*;

public class Keypad extends JPanel
{
   private JButton keys[];
   private JPanel keyPadJPanel;
   private JTextArea textArea; //text area to display output 
   private boolean in=false;
  
   // constructor sets up GUI
   
   public Keypad()
   {
	
	   jhandler handler = new jhandler();
       jhandler1 handler1 = new jhandler1();
	   enter enter1 = new enter();
	   cancel cancel1= new cancel();
      textArea =new JTextArea(3,20);  // declaration of textArea for displaying output
      textArea.setEditable(false);    // set textArea not editable

      keys = new JButton[ 16 ]; // array keys contains 16 JButtons 

      // initialize all digit key buttons
      for ( int i = 0; i <= 9; i++ )
         keys[ i ] = new JButton( String.valueOf( i ) );
      // initialize all function key buttons
      keys[ 10 ] = new JButton( "Enter" );
      keys[ 11 ] = new JButton( "Clear" );
      keys[ 12 ] = new JButton( "Cancel" );
      keys[ 13 ] = new JButton( "" );
      keys[ 14 ] = new JButton( "00" );
      keys[ 15 ] = new JButton( "." );
      
     
     
      
      for ( int i = 0; i <= 9; i++ )
      keys[ i].addActionListener(handler);
      keys[11].addActionListener(handler1); 
      keys[ 14].addActionListener(handler);
      keys[ 15].addActionListener(handler);
      keys[10].addActionListener(enter1);
      keys[ 12 ].addActionListener(cancel1);
      // set keyPadJPanel layout to grid layout
      keyPadJPanel = new JPanel();
      keyPadJPanel.setLayout( new GridLayout( 4, 4 ) );

      // add buttons to keyPadJPanel panel
      // 7, 8, 9, enter
      for ( int i = 7; i <= 10; i++ )
         keyPadJPanel.add( keys[ i ] );

      // 4, 5, 6
      for ( int i = 4; i <= 6; i++ )
         keyPadJPanel.add( keys[ i ] );

      // clear
      keyPadJPanel.add( keys[ 11 ] );

      // 1, 2, 3
      for ( int i = 1; i <= 3; i++ )
         keyPadJPanel.add( keys[ i ] );

      // cancel
      keyPadJPanel.add( keys[ 12 ] );

      // 0
      keyPadJPanel.add( keys[ 0 ] );
     
      // ., 00, null
      for ( int i = 15; i >= 13; i-- )
         keyPadJPanel.add( keys[ i ] );
    	
      add(textArea, BorderLayout.NORTH);
      add( keyPadJPanel, BorderLayout.SOUTH );
 
   } // end keypad constructor
   
   private class jhandler implements ActionListener 
   { 
      public void actionPerformed( ActionEvent event )
      {
    	   	  String b=textArea.getText();   	     	  
    	  textArea.setText(b+event.getActionCommand()); 
      }
   }
   
   private class jhandler1 implements ActionListener 
   { 
      public void actionPerformed( ActionEvent event )
      {	   	  
    	  String b=textArea.getText();
    	  textArea.replaceRange(null,0,b.length());
      }
   }
   
  
     
   private class cancel implements ActionListener 
   {
      public void actionPerformed( ActionEvent event )
      {   
    	  textArea.setText("-2");
    	  in=true;
      }
   }
   
   private class enter implements ActionListener 
   {
      public void actionPerformed( ActionEvent event )
      {
        in=true;
      }
   } 
   
   public int getinput()
   {   
	   int intValue = -1;
	   while (intValue == -1) 
		 {
		 if (in==true) 
		 {
			 try  
			 {
				 intValue = Integer.valueOf(textArea.getText());
			 }
			 catch(NumberFormatException e) {}
			 
		 }
		 System.out.print(" "); 
		 }
		 
	     in=false;
	     String b=textArea.getText();
	  	  
	  	  textArea.replaceRange(null,0,b.length());
   return  intValue ;
   }
    
} // end class keypad
