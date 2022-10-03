package Project_1;
//Operation to perform 

//Transfer amount, View Balance, Deposit Amount, Withdraw Amount.

import java.util.Scanner;

class IDFC {  //Creating Class "IDFC" with 1.Fields and 2.Methods. 

	//1.Fields
	private String account_no;  // These are fields that is account_no , name_of_customer etc
	private String name_of_customer; //The private access modifier is accessible only within the class.  
	private String type_of_account;  
	private int balance;
	int amount;
	int transfer;
	
	
	//2.Methods
  @SuppressWarnings("resource")
	public void account_open() { //First we must have an account to perform various operation
  	
  	//Using scanner class for getting value from the user
      Scanner sc = new Scanner(System.in); 
      System.out.print("Enter Account Number of the customer:");  
      account_no=sc.nextLine();
      
      System.out.print("Enter type of account you want to open:");
      System.out.print(" 1.Salary Account "+" 2.Savings Account "+" 3.Current Account ");
      type_of_account=sc.nextLine();
      
      System.out.print("Enter Name of customer:");  
      name_of_customer=sc.nextLine();
      
      System.out.print("Enter Balance:");  
      balance=sc.nextInt();  
  }  
  
  
  public void display_account(){   //method to display account details of the customer  
  	System.out.println("Name of account holder:"+ name_of_customer);  
      System.out.println("Account no.: "+account_no);  
      System.out.println("Account type: "+type_of_account);  
      System.out.println("Balance INR: "+balance);  
  }
  
  
  public void view_balance() { //method to display balance
 	System.out.println(balance);
  }
  
  
  @SuppressWarnings("resource")
	public void deposit(){ //method to deposit the amount given by the customer
  	Scanner sc = new Scanner(System.in);
      System.out.println("Enter the amount you want to deposit INR: ");  
      amount=sc.nextInt();  
      balance=balance+amount;  
  }
  
  
  
  @SuppressWarnings("resource")
	public void withdrawal() {  //method to withdraw the amount given by the customer
  	Scanner sc = new Scanner(System.in);  
      System.out.println("Enter the amount you want to withdraw INR: ");  
      amount=sc.nextInt();  
      if (balance >=amount) {  
          balance = balance-amount;  
          System.out.println("Balance after withdrawal INR: "+balance);  
      }
      else {
      	System.out.println("Your balance is less than INR: "+amount);
      }
  }
  
  @SuppressWarnings("resource")
	public void transfer() {  //method to transfer the amount given by the customer and display  its Balance after withdrawal
  	Scanner sc = new Scanner(System.in);  
      System.out.println("Enter the amount you want to transfer INR: ");  
      transfer=sc.nextInt();  
      if (balance>=transfer) {  
          balance=balance-transfer;
          System.out.println("Transfer Successful amounting INR: "+ transfer); 
          System.out.println("Balance after withdrawal INR: "+balance);  
      }
      else {
      	System.out.println("Your balance is less than INR: "+amount);
      }
  	
  }
      
      
  public boolean search(String ac_no) { //just for matching the account is present or not 
      if (account_no.equals(ac_no)) {  
          display_account();  
          return (true);  
      }  
      return (false);  
  } 
    
}
public class BankApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);  
        //Creating Account  
        System.out.print("How many number of customers do you want to input? ");  
        int n=sc.nextInt();  
        IDFC obj[]=new IDFC[n]; //creating object as an array of the class idfc
        
        for(int i=0; i<obj.length; i++) {  
        	obj[i]=new IDFC ();  
        	obj[i].account_open();  
        }  
     // loop runs until number 6 is not typed to exit from the program  
        int ch;  
        do {  
            System.out.println("\n *Java Banking Application*");  
            System.out.println("\n 1. Display all account details \n 2. View Balance\n 3. Deposit the amount \n 4. Withdraw the amount \n 5. Transfer the amount \n 6. Exit ");  
            System.out.println("Enter your choice: ");  
            ch = sc.nextInt();  
                switch (ch) {  
                    
                
                
                	case 1:  
                        for(int i=0;i<obj.length;i++) {  
                        	obj[i].display_account();  
                        }  
                        break; 
                        
                        
                    case 2:  
                        System.out.print("View your balance INR: ");  
                        for(int i=0;i<obj.length;i++) {  
                        	obj[i].view_balance();  
                        } 
                        break;
                    
                        
                    case 3:  
                        System.out.print("Enter Account no. : ");  
                        String ac_no=sc.next();  
                        boolean found=false;  
                        for (int i = 0; i < obj.length; i++) {  
                            found = obj[i].search(ac_no);  
                            if (found) {  
                            	obj[i].deposit();  
                                break;}  
                        }  
                        if(!found) {  
                            System.out.println("Search failed!");  
                        }
                        break;
                        
                        
                    case 4:
                    	System.out.print("Enter Account No : ");  
                        ac_no=sc.next();  
                        found=false;  
                        for (int i = 0; i < obj.length; i++) {  
                            found = obj[i].search(ac_no);  
                            if (found) {  
                            	obj[i].withdrawal();  
                                break;  }  
                        }  
                        if(!found) {  
                            System.out.println("Search failed, Account doesn't exist.");  
                        }  
                        break;
                        
                    case 5:
                    	obj[0].transfer();
                        break;
                        
                    case 6:
                    	System.out.println("exit");  
                        break;
                 		}  
                }while (ch!=6);

	}

}
