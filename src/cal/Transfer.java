package cal;
public class Transfer extends Transaction{
	
	private BankDatabase bankDatabase=new BankDatabase(); // account info database
	private Keypad keypad; // reference to keypad
	private double amount; // amount to Transfer
	private int receiptAccount=0;
	private final static int CANCELED = 0; // constant for cancel option
	private int accountTypeToPay=0;
	private double availableBalance; // amount available for withdrawal
	
	
	// Withdrawal constructor
	public Transfer(int userAccountNumber, Screen atmScreen, 
		      BankDatabase atmBankDatabase, Keypad atmKeypad) {
		
		// initialize superclass variables
	      super( userAccountNumber, atmScreen, atmBankDatabase );
		
	      keypad=atmKeypad;
	}// end Transfer constructor
	
	public void execute() {
		Screen screen = getScreen();
		boolean tranfered = false; // cash was not tranfered yet
		
		
	    // get references to bank database and screen
	    BankDatabase bankDatabase = getBankDatabase();
	    
	    //get and check the receipt account
	    receiptAccount=receiptAccountChecking();
	    if(receiptAccount==0)
	    	return;
	    
		do {
			
			screen.displayMessageLine( "Input the transfer amount (enter 0 to cancel) : " );
			amount=keypad.getInputdouble();//new get method to get double in keypad.java
			
			if (amount!=0||amount!=-2) {
				
				// get available balance of account involved
	            availableBalance = checkWhichEnoughToPayTransfer();
	            
	            // check whether the user has enough money in the account 
	            if ( amount <= availableBalance){
	            	
	            	//Bank starts reconciliation
	            	//money will transfer to Payee's current account
	            	switch (accountTypeToPay) {
	        		case 1:
	        			bankDatabase.currentDebit( getAccountNumber(), amount );//user pay the fee
	        			bankDatabase.currentCredit(receiptAccount, amount);
	        			break;
	        		case 2:
	        			bankDatabase.savingDebit( getAccountNumber(), amount );//user pay the fee
	        			bankDatabase.currentCredit(receiptAccount, amount);
	        			break;
	            	}
	            	if (amount!=0||amount!=-2)
	            	screen.displayMessageLine("Transfer Successfully");
	            	tranfered=true;
	            }
	            else {
	            	screen.displayMessageLine( 
	                        "\nInsufficient funds in your account." +
	                        "\n\nPlease choose a smaller amount." );
				}
			}
			else {
				screen.displayMessageLine("Exit Transfer Function");
			}
			
		} while (!tranfered);
	}// end of execute method
	
	
	private int receiptAccountChecking() {

		Screen screen = getScreen();		
		
		while(true) {
			screen.displayMessageLine( "Input the receipt account (enter 0 to cancel) : " );
			int receiptAccount = keypad.getInput();
			
			//Check if the account exists in the bank database
			if ( receiptAccount == CANCELED||receiptAccount == -2)
				return CANCELED;
			
			if (!bankDatabase.accountExist(receiptAccount)) {
				screen.displayMessageLine( "Account does not exist" );
			}
				
			else
				return receiptAccount;
		}
	}// end of receiptAccountChecking method
	
	private double checkWhichEnoughToPayTransfer(){
		double backData;
		//Check that there is sufficient amount of Current accounts
		backData=bankDatabase.getCurrentAvailableBalance(getAccountNumber());
		if (amount<=backData) {
			accountTypeToPay=1;
			return backData;
		}
		
		//Check that there is sufficient amount of Savings accounts
		backData=bankDatabase.getSavingAvailableBalance(getAccountNumber());
		if (amount<=backData) {
			accountTypeToPay=2;
			return backData;
		}

		return 0; //not enough money
	} //end of checkWhichEnoughToPayTransfer method
	
}
