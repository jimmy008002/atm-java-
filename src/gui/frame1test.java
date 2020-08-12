package gui;

// Program creates a GUI that resembles a calculator.
import javax.swing.JFrame;

public class frame1test
{
   public static void main( String args[] )
   {
	   frame frame1 = new frame(); 
      frame1.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 
     
      int input = frame1.getinput();
       
  System.out.print(input);
  frame1.settext(String.valueOf(input));
  input = frame1.getinput();
  System.out.print(input);
   }  // end main
}  // end class Calculator

