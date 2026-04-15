import java.util.Scanner;

// 1. Interface (Showing High-Level Abstraction)
interface Transaction {
    void deposit(double amount);
    void withdraw(double amount) throws Exception;
}

// 2. Custom Exception (Showing Error Handling)
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// 3. Base Class
class Account implements Transaction {
    protected double balance;
    private int pin;

    public Account(double initialBalance, int pin) {
        this.balance = initialBalance;
        this.pin = pin;
    }

    public boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        }
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Error: Insufficient balance. Current: " + balance);
        }
        balance -= amount;
        System.out.println("Successfully withdrawn: " + amount);
    }
}

// 4. Child Class (Showing Inheritance & Polymorphism)
class SavingsAccount extends Account {
    private final double MIN_BALANCE = 500.0;

    public SavingsAccount(double initialBalance, int pin) {
        super(initialBalance, pin);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance - amount < MIN_BALANCE) {
            throw new InsufficientFundsException("Error: Minimum balance of " + MIN_BALANCE + " must be maintained.");
        }
        super.withdraw(amount);
    }
}

public class AtmSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account myAccount = new SavingsAccount(2000.0, 1234);

        System.out.println("--- Secure Java ATM ---");
        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        if (!myAccount.validatePin(pin)) {
            System.out.println("Invalid PIN. System Locked.");
            return;
        }

        while (true) {
            System.out.print("\n1. Balance\n2. Deposit\n3. Withdraw\n0. Exit\nChoice: ");
            int choice = sc.nextInt();

            if (choice == 0) break;

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Balance: " + myAccount.getBalance());
                        break;
                    case 2:
                        System.out.print("Amount: ");
                        myAccount.deposit(sc.nextDouble());
                        break;
                    case 3:
                        System.out.print("Amount: ");
                        myAccount.withdraw(sc.nextDouble());
                        break;
                }
            } catch (Exception e) {
                // Catching the custom exception (Abstraction & Robustness)
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}


                  
      




