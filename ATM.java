import java.util.*;
import java.io.*;
class BankAcc_User {
    double balance;
    BankAcc_User(double b) {
        balance = b;
    }
    void UserBal() {
        System.out.println("Closing Balance: Rs." +balance);
    }
}
class ATM extends BankAcc_User {
    ATM(double b) {
        super(b);
    }
    void withdraw(double amount) {
        if (amount > super.balance)
            System.out.println("Insufficient Balance!");
        else {
            super.balance -= amount;
            System.out.println("Transaction Complete: Rs." + amount);
            checkBalance();
        }
    }
    void deposit(double amount) {
        super.balance += amount;
        System.out.println("Deposit Complete: Rs." + amount);
        checkBalance();
    }
    void checkBalance() {
        super.UserBal();
    }
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------------------------------\n\t\tWelcome\n----------------------------------------");
        System.out.println("Please Select the Transaction To Proceed:");
        System.out.println("1. Withdrawal\n2. Deposit\n3. Balance Enquiry\n0. Exit");
        System.out.println("----------------------------------------");
        System.out.print("Enter Opening balance: Rs.");
        double amount = sc.nextDouble();
        ATM ob = new ATM(amount);
        int ch;
        do{
            System.out.print("Enter Choice:");
            ch = sc.nextInt();
            switch (ch){
                case 1:
                    System.out.print("Enter The Amount: Rs.");
                    amount = sc.nextDouble();
                    ob.withdraw(amount);
                    break;
                case 2:
                    System.out.print("Enter The Amount: Rs.");
                    amount = sc.nextDouble();
                    ob.deposit(amount);
                    break;
                case 3:
                    ob.checkBalance();
                    break;
                case 0:
                    System.out.println("Thank You.");
                    break;
                default:
                    System.out.println("Invalid Choice! Please Select The Correct Choice");
                    break;
            }
            System.out.println("----------------------------------------");
        }while(ch!=0);
        sc.close();
    }
}
