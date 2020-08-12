
package cal;// Withdrawal.java
// Represents a withdrawal ATM transaction

public class Withdrawal extends Transaction
{
   private Keypad keypad; // reference to keypad
   private CashDispenser cashDispenser; // reference to cash dispenser
   BankDatabase bankDatabase;
   
   private int amount; // amount to withdraw
   private int accountTypeToPay=0;
   private double availableBalance; // amount available for withdrawal
   private final static int CANCELED = 7; // constant corresponding to menu option to cancel

   
   // Withdrawal constructor
   public Withdrawal( int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad, 
      CashDispenser atmCashDispenser )
   {
      // initialize superclass variables
      super( userAccountNumber, atmScreen, atmBankDatabase );
      
      // initialize references to keypad and cash dispenser
      keypad = atmKeypad;
      cashDispenser = atmCashDispenser;
   } // end Withdrawal constructor

   // perform transaction
   public void execute()
   {
      boolean cashDispensed = false; // cash was not dispensed yet
      
      // get references to bank database and screen
      bankDatabase = getBankDatabase(); 
      Screen screen = getScreen();

      // loop until cash is dispensed or the user cancels
      do
      {
         // obtain a chosen withdrawal amount from the user 
         amount = displayMenuOfAmounts();
         
         // check whether user chose a withdrawal amount or canceled
         if ( amount != CANCELED )
         {
            // get available balance of account involved
            availableBalance = checkWhichEnoughToPayTransfer();
      
            // check whether the user has enough money in the account 
            if ( availableBalance!=0 )
            {   
            	
               // check whether the cash dispenser has enough money
               if ( cashDispenser.isSufficientCashAvailable( amount ) )
               {
                  // update the account involved to reflect withdrawal
            	  transactionSettlement();
            	   
                  cashDispenser.dispenseCash( amount ); // dispense cash
                  cashDispensed = true; // cash was dispensed

                  // instruct user to take cash
                  screen.displayMessageLine( 
                     "\nPlease take your cash now." );
               } // end if
               else // cash dispenser does not have enough cash
                  screen.displayMessageLine( 
                     "\nInsufficient cash available in the ATM." +
                     "\nPlease choose a smaller amount." );
            } // end if
            else // not enough money available in user's account
            {
               screen.displayMessageLine( 
                  "\nInsufficient funds in your account." +
                  "\n\nPlease choose a smaller amount." );
            } // end else
         } // end if
         else // user chose cancel menu option 
         {
            screen.displayMessageLine( "\nCanceling transaction..." );
            return; // return to main menu because user canceled
         } // end else
      } while ( !cashDispensed );

   } // end method execute

   // display a menu of withdrawal amounts and the option to cancel;
   // return the chosen amount or 0 if the user chooses to cancel
   private int displayMenuOfAmounts()
   {
      int userChoice = 0; // local variable to store return value

      Screen screen = getScreen(); // get screen reference
      
      // array of amounts to correspond to menu numbers
      int amounts[] = { 0, 100, 200, 400, 500, 1000 };

      // loop while no valid choice has been made
      while ( userChoice == 0 )
      {
         // display the menu
         screen.displayMessageLine( "\nWithdrawal Menu:" );
         screen.displayMessageLine( "1 - $100" );
         screen.displayMessageLine( "2 - $200" );
         screen.displayMessageLine( "3 - $400" );
         screen.displayMessageLine( "4 - $500" );
         screen.displayMessageLine( "5 - $1000" );
         screen.displayMessageLine( "6 - Other amount" );
         screen.displayMessageLine( "7 - Cancel transaction" );
         screen.displayMessageLine( "Only provide HKD 100, 500 and 1000" );
         screen.displayMessage( "Choose a withdrawal amount: " );

         int input = keypad.getInput(); // get user input through keypad
         
         // determine how to proceed based on the input value
         switch ( input )
         {
            case 1: // if the user chose a withdrawal amount 
            case 2: // (i.e., chose option 1, 2, 3, 4 or 5), return the
            case 3: // corresponding amount from amounts array
            case 4:
            case 5:
               userChoice = amounts[ input ]; // save user's choice
               break;    
            case 6:
            	userChoice=otherAmount();
            	break;
            case -2:  //
            case CANCELED: // the user chose to cancel
            	userChoice = CANCELED; // save user's choice
            	break;
            default: // the user did not enter a value from 1-6
            	screen.displayMessageLine( 
            			"\nInvalid selection. Try again." );
         } // end switch
      } // end while

      return userChoice; // return withdrawal amount or CANCELED
   } // end method displayMenuOfAmounts
   
   //execute the user-defined withdrawal amount
   private int otherAmount() {
	   Screen screen = getScreen();
	   
	   //while loop will be continuous if user input is not multiple of 100
	   while (true) {
		   screen.displayMessageLine( "\nInput the withdrawal amount" );
		   int input = keypad.getInput();
		   
		   //show notification if input invalid
		   if ((input%100)!=0) {
			   screen.displayMessageLine( "Invalid Input" );
			   screen.displayMessageLine( "Only provide HKD 100, 500 and 1000" );		   
		   }	
		   else {
			   return input; // if input is multiple of 100, return the amount
		   }
	}// end while
   }// end method otherAmount

   private void transactionSettlement() {
	   Screen screen = getScreen();
		switch (accountTypeToPay) {
		case 1:
			bankDatabase.currentDebit( getAccountNumber(), amount );//user pay the fee
			break;
			
		case 2:
		//	bankDatabase.currentDebit( getAccountNumber(), amount );//user pay the fee
			screen.displayMessageLine( "You used overdrawn limit.Cant withdraw" );
			break;
		}
		
	}
   
   private double checkWhichEnoughToPayTransfer(){
		
		//Check that there is sufficient amount of Current accounts
		availableBalance=bankDatabase.getCurrentAvailableBalance( getAccountNumber());
		if (amount<=availableBalance) {
			accountTypeToPay=1;
			return availableBalance;
		}
		
		//Check that there is sufficient amount of Current accounts when use overdrawn limit
		availableBalance=bankDatabase.getCurrentAvailableBalanceOverdrawnLimit(getAccountNumber());
		if (amount<=availableBalance) {
			accountTypeToPay=2;
			return availableBalance;
		}
		else
			return 0; //not enough money
	}
   
} // end class Withdrawal

// Withdrawal just can use 


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