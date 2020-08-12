package gui;
import java.awt.*;
import javax.swing.*;


public class display extends JPanel
{
	 private JTextArea textArea;
	public display()
	   {
		 
		textArea =new JTextArea(30,30);
		textArea.setEditable(false); 								
		add(textArea);
	   }
	
	public void settext(String input) 
	{
		
		String b;
		b=textArea.getText()+"\n";		
		textArea.setText( b+input );
			
	}	
	  public void clear() 
	   {		  
		  textArea.setText("");
	   }
	
	
}
