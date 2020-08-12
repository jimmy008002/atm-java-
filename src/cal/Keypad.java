package cal;
// Keypad.java
// Represents the keypad of the ATM
import gui.frame;
public class Keypad
{
 
   private int input;// reads data from the command line
    private frame frame1;
   // no-argument constructor initializes the Scanner
   public Keypad(frame frame1)
   {
	   this.frame1 = frame1;
  	      	 
   } // end no-argument Keypad constructor

   // return an integer value entered by user 
   public int getInput()
   {
	   return frame1.getinput(); // we assume that user enters an integer  
   } // end method getInput
   
// return an integer value entered by user 
   public double getInputdouble()
   {
	   double d=frame1.getinput();
	   
      return d; // we assume that user enters an double  
   } // end method getInputdouble
   
} // end class Keypad  



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