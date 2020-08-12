package cal;
// BankDatabase.java
// Represents the bank account information database 
//jason

public class BankDatabase
{
   private Account accounts[]; // array of Accounts
   
   // no-argument BankDatabase constructor initializes accounts
   public BankDatabase()
   {
      accounts = new Account[ 2 ]; // just 2 accounts for testing
      accounts[ 0 ] = new Account( 12345, 54321, 1000.0, 1200.0, 5000.0, 7000.0);
      accounts[ 1 ] = new Account( 98765, 56789, 200.0, 200.0, 1000.0, 1000.0 );  
   } // end no-argument BankDatabase constructor
   
   // retrieve Account object containing specified account number
   private Account getAccount( int accountNumber )
   {
      // loop through accounts searching for matching account number
      for ( Account currentAccount : accounts )
      {
         // return current account if match found
         if ( currentAccount.getAccountNumber() == accountNumber )
            return currentAccount;
      } // end for

      return null; // if no matching account was found, return null
   } // end method getAccount

   // determine whether user-specified account number and PIN match
   // those of an account in the database
   public boolean authenticateUser( int userAccountNumber, int userPIN )
   {
      // attempt to retrieve the account with the account number
      Account userAccount = getAccount( userAccountNumber );

      // if account exists, return result of Account method validatePIN
      if ( userAccount != null )
         return userAccount.validatePIN( userPIN );
      else
         return false; // account number not found, so return false
   } // end method authenticateUser
   
   //check the account exist in database(function transfer)
   public boolean accountExist(int checkAccount) {
	   Account userAccount = getAccount( checkAccount );
	   
	   if ( userAccount != null )
		   return true;
	   else
		   return false;	   
   }
   
   
   public double getCurrentAvailableBalanceOverdrawnLimit(int userAccountNumber) {
	   return getAccount( userAccountNumber ).getCurrentAvailableBalance()
			   +getAccount( userAccountNumber ).getOverdrawnLimit();
   } // end of getCurrentAvailableBalanceOverdrawnLimit method
   
   // return available balance of Account with specified account number
   public double getCurrentAvailableBalance( int userAccountNumber )
   {
      return getAccount( userAccountNumber ).getCurrentAvailableBalance();
   } // end method getAvailableBalance
   
   // return available balance of Account with specified account number
   public double getCurrentTotalBalance( int userAccountNumber )
   {
      return getAccount( userAccountNumber ).getCurrentTotalBalance();
   } // end method getAvailableBalance
   
   // return available balance of Account with specified account number
   public double getSavingAvailableBalance( int userAccountNumber )
   {
      return getAccount( userAccountNumber ).getSavingAvailableBalance();
   } // end method getAvailableBalance

   // return total balance of Account with specified account number
   public double getSavingTotalBalance( int userAccountNumber )
   {
      return getAccount( userAccountNumber ).getSavingTotalBalance();
   } // end method getTotalBalance

   // credit an amount to currentAccount with specified account number
   public void currentCredit( int userAccountNumber, double amount )
   {
      getAccount( userAccountNumber ).currentCredit( amount );
   } // end method credit
   
   // credit an amount to savingAccount with specified account number
   public void savingCredit( int userAccountNumber, double amount )
   {
      getAccount( userAccountNumber ).savingCredit( amount );
   } // end method credit

   // debit an amount from of Account with specified account number
   public void currentDebit( int userAccountNumber, double amount )
   {
      getAccount( userAccountNumber ).currentDebit( amount );
   } // end method debit
   
   // debit an amount from of Account with specified account number
   public void savingDebit( int userAccountNumber, double amount )
   {
      getAccount( userAccountNumber ).savingDebit( amount );
   } // end method debit
   
   public void transterReceipt(int userAccountNumber, double amount) {
	   getAccount( userAccountNumber ).currentCredit(amount);
	   
   } //// end method transterReceipt
   
   // ATM pay the transfer fee
   public void transterPaySaving(int userAccountNumber, double amount) {
	   getAccount( userAccountNumber ).savingDebit(amount);
	   
   } // end method transterPay
   
   public void transterPayCurrent(int userAccountNumber, double amount) {
	   getAccount( userAccountNumber ).currentDebit(amount);
	   
   } // end method transterPay

   
} // end class BankDatabase



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