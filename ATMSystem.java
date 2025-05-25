import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Get current balance
    public double getBalance() {
        return balance;
    }

    // Deposit method
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    // Withdraw method with validation
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount account;
    private Scanner scanner;

    // Constructor
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Start the ATM menu
    public void start() {
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> performWithdraw();
                case 2 -> performDeposit();
                case 3 -> displayBalance();
                case 4 -> System.out.println("🚪 Exiting... Thank you for using the ATM.");
                default -> System.out.println("❌ Invalid option. Please choose again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    // ATM menu
    private void displayMenu() {
        System.out.println("\n===== ATM MENU =====");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Choose an option (1-4): ");
    }

    // Perform withdrawal
    private void performWithdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("✅ Withdrawal successful. Current balance: $" + account.getBalance());
        } else {
            System.out.println("❌ Withdrawal failed. Insufficient balance or invalid amount.");
        }
    }

    // Perform deposit
    private void performDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (account.deposit(amount)) {
            System.out.println("✅ Deposit successful. Current balance: $" + account.getBalance());
        } else {
            System.out.println("❌ Deposit failed. Enter a valid amount.");
        }
    }

    // Display balance
    private void displayBalance() {
        System.out.println("💰 Current Balance: $" + account.getBalance());
    }
}

// Main class to run the program
public class ATMSystem {
    public static void main(String[] args) {
        // Create a BankAccount with an initial balance
        BankAccount userAccount = new BankAccount(1000.00);

        // Link ATM to the account
        ATM atmMachine = new ATM(userAccount);

        // Start ATM operations
        atmMachine.start();
    }
}
