package cal;
// Screen.java
// Represents the screen of the ATM

import gui.frame;

public class Screen
{
  private frame frame1;
	public Screen(frame frame1){
	   this.frame1 = frame1;
	   
	   
   }
	// displays a message without a carriage return
   public void displayMessage( String message ) 
   {
	   frame1.settext(message);
	
   } // end method displayMessage

   // display a message with a carriage return
   public void displayMessageLine( String message ) 
   {
	   frame1.settext(message);
    
   } // end method displayMessageLine

   // display a dollar amount
   public void displayDollarAmount( double amount )
   {
	  String message;
			  message = String.format("$%.2f", amount);
	   
			  frame1.settext(message);
 
   } // end method displayDollarAmount 
} // end class Screen



/**************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/