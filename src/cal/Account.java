package cal;
// Represents a bank account
//jason

public class Account 
{
   private int accountNumber; // account number
   private int pin; // PIN for authentication
   private double currentAvailableBalance; // Current Available Blance
   private double currentTotalBalance; // Current Total Blance
   private double savingAvailableBalance; // Saving Available Balance
   private double savingTotalBalance; // Saving Total Balance
   private final  int overdrawnLimit = 10000;
   private double interestRate = 0.001;
      
   // Account constructor initializes attributes
   public Account( int theAccountNumber, int thePIN, 
      double theCurrentAvailableBalance, double theCurrentTotalBalance, double theSavingAvailableBalance, double theSavingTotalBalance )
   {
      accountNumber = theAccountNumber;
      pin = thePIN;
      currentAvailableBalance = theCurrentAvailableBalance;
      currentTotalBalance = theCurrentTotalBalance;
      savingAvailableBalance = theSavingAvailableBalance;
      savingTotalBalance = theSavingTotalBalance;
   } // end Account constructor

   // determines whether a user-specified PIN matches PIN in Account
   public boolean validatePIN( int userPIN )
   {
      if ( userPIN == pin )
         return true;
      else
         return false;
   } // end method validatePIN
   
   //get overdrawnLimit
   public int getOverdrawnLimit() {
	   return overdrawnLimit;
   } //end of overdrawnLimit method
   
   // returns current Available Balance
   public double getCurrentAvailableBalance()
   {
       return currentAvailableBalance;
   }// end getCurrentAvailableBalance
   
    // returns Saving Available Balance
   public double getCurrentTotalBalance()
   {
       return currentTotalBalance;
   }// end getSavingAvailableBalance
   
   // returns available balance
   public double getSavingAvailableBalance()
   {
      return savingAvailableBalance;
   } // end saving Available Balance

   // returns the total balance
   public double getSavingTotalBalance()
   {
      return savingTotalBalance;
   } // end method getTotalBalance
   
   
   // credits an amount to the current account
   public void currentCredit( double amount )
   {
      currentTotalBalance += amount; // add to total balance
   } // end method credit

   // credits an amount to the saving account
   public void savingCredit( double amount )
   {
      savingTotalBalance += amount; // add to total balance
   } // end method credit

   // debits an amount from the account
   
   public void currentDebit( double amount )
   {
      currentAvailableBalance -= amount; // subtract from available balance
      currentTotalBalance -= amount; // subtract from total balance
   } // end method debit
   
   public void savingDebit( double amount )
   {
      savingAvailableBalance -= amount; // subtract from available balance
      savingTotalBalance -= amount; // subtract from total balance
   } // end method debit
   
   // returns account number
   public int getAccountNumber()
   {
      return accountNumber;  
   } // end method getAccountNumber
} // end class Account


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