import java.util.Scanner;

public class Account {
	//Define variables
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;
	
	//Create a class constructor
	Account(String cname, String cid) {
	customerName = cname;
	customerID = cid;
	
	}
	
	//Create a function for Receiving of funds
	void receive(int amount) {
		if (amount != 0) {
		balance += amount;
		previousTransaction = amount;
		}
	}	
	
	//Create a function for Transferring of funds
	void transfer(int amount) {
		if (amount != 0) {
		balance -= amount;
		previousTransaction = -amount;
		}
	}	
		
		
	//Create function for displaying previous transaction
	void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("You received: " + previousTransaction);
		}
		
		else if (previousTransaction < 0) {
			System.out.println("You transferred: " + previousTransaction);
		}
		else System.out.println("There was no transaction done previously!");
	}
	
	
	//Create function for projecting calculation of interest rates
	void calculateInterestRate(int years) {
		double interestRate = 0.01;
		double newBalance = balance * (Math.pow((1 + interestRate), (years * 1)));
		System.out.println("The current interest rate is: " + (interestRate * 100) + "%");
		System.out.println("Your compounded balance after " + years + " years is: " + newBalance);
	}
	
	
	//Create function showing the main menu of the application
	void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome " + customerName + "!");
		System.out.println("Your Username is " + customerID + ".");
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("A. Check your balance");
		System.out.println("B. Make a transfer");
		System.out.println("C. Make a request to receive funds");
		System.out.println("D. View previous transaction");
		System.out.println("E. Calculate interest");
		System.out.println("F. Exit");
		
		do {
			System.out.println();
			System.out.println("Enter an option: ");
			char option1 = scanner.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();;
			
			
	
			switch(option) {
			//Case 'A' allows the user to check their account balance
			case 'A':
				System.out.println("====================================");
				System.out.println("Balance = $" + balance);
				System.out.println("====================================");
				System.out.println();
				break;
				//Case 'B' allows the user to transfer money from their account using the 'transfer' function
			case 'B':
				System.out.println("Enter an amount to transfer: ");
				int amount2 = scanner.nextInt();
				transfer(amount2);
				System.out.println();
				break;
				//Case 'C' allows the user to request for money to be sent to their account using the 'receive' function
			case 'C':
				System.out.println("Enter an amount to receive: ");
				int amount = scanner.nextInt();
				receive(amount);
				System.out.println();
				break;		
				//Case 'D' allows the user to view their most recent transaction using the 'getPreviousTransaction' function
			case 'D':
				System.out.println("====================================");
				getPreviousTransaction();
				System.out.println("====================================");
				System.out.println();
				break;
				//Case 'E' calculates the compound interest on the account after a number of years specified by the user
			case 'E':
				System.out.println("Enter how many years of compound interest: ");
				int years = scanner.nextInt();
				calculateInterestRate(years);
				break;
				//Case 'F' exits the user from their account
			case 'F':
				System.out.println("====================================");
				break;
				//The default case let's the user know that they entered an invalid character and how to enter a valid one
			default:
				System.out.println("Error: invalid option. Please enter A, B, C, D, or E to access services.");
				break;
			}
		} while(option != 'F');
		System.out.println("Thank you for banking with us!");


	
	}

}	




//1.Greeting Message
//2. Menu showing list of services: View Balance, Transfer, Receive, Calculate Interest, View previous transaction,Exit
