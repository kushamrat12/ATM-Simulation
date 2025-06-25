// Display Menu Options
import java.util.Scanner;
public class Atm {

    static int balance =2000;
    public static int checkBalance() {

        return balance;

    }
    public static int depositMoney(int m){

        int deposit = m;
        balance = balance+deposit;
       return deposit;
    }
   public static int withdrawMoney(int n){

        int withdraw = n;


            balance = balance-withdraw;
                   return withdraw;


    }
    public static void main(String[] args) {

        System.out.println("Check Balance(C)");
        System.out.println("Deposit Money(D)");
        System.out.println("Withdraw Money(W)");
        System.out.println("Enter 0 for exit");
        Scanner sc = new Scanner(System.in);
        while(true){

        System.out.println("Select any one option: ");
            String opt = sc.nextLine();
            opt = opt.toUpperCase();
            if(opt.equals("0")){
                       break;
                   }

              switch (opt){
               case "C" :
                    System.out.println("Available balance is: "+checkBalance());

               break;
               case "D" :
                   System.out.println("Enter deposited money: ");
                       int m = sc.nextInt();
                       sc.nextLine();
                   if(m<=0){
                       System.out.println("Invalid amount");
                   }
                   else{
                       System.out.println("Deposit Money is: "+depositMoney(m));
                   }
                   System.out.println("Current balance is: "+balance);
               break;
               case "W" :
                   System.out.println("Enter withdraw money: ");
                       int n = sc.nextInt();
                       sc.nextLine();
                       if(n>balance || n<=0 ){
                           System.out.println("Insufficient fund");
                       }
                       else {
                           System.out.println("Withdrawal money is: " + withdrawMoney(n));
                       }
                   System.out.println("Current balance is: "+balance);
               break;
                      sc.close();

       }

        }
    }
}




