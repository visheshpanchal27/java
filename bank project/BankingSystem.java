import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
    }
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void applyForLoan(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Loan approved for: " + amount);
            System.out.println("New balance after loan: " + balance);
        } else {
            System.out.println("Invalid loan amount!");
        }
    }

    public void accountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

class BankingSystem {
    private BankAccount account = null;
    private Scanner scanner = new Scanner(System.in);

    public void createAccount() {
        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial deposit amount: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Please enter a valid amount!");
            scanner.nextLine();
        }
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine();

        String accountNumber = generateAccountNumber();
        account = new BankAccount(accountNumber, name, initialDeposit);
        System.out.println("Account created successfully. Your account number is: " + accountNumber);
    }

    public void login() {
        if (account == null) {
            System.out.println("No account found! Please create an account first.");
            return;
        }

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        if (account.getAccountNumber().equals(accountNumber)) {
            System.out.println("Welcome, " + account.getAccountHolderName());
            accountOptions();
        } else {
            System.out.println("Account not found!");
        }
    }

    private void accountOptions() {
        int choice;
        do {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Apply for Loan");
            System.out.println("4. Account Info");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                scanner.nextLine();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Please enter a valid amount!");
                        scanner.nextLine();
                    }
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Please enter a valid amount!");
                        scanner.nextLine();
                    }
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter loan amount: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Please enter a valid amount!");
                        scanner.nextLine();
                    }
                    double loanAmount = scanner.nextDouble();
                    scanner.nextLine();
                    account.applyForLoan(loanAmount);
                    break;
                case 4:
                    account.accountInfo();
                    break;
                case 5:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    private String generateAccountNumber() {
        return "BOI" +(int) (Math.random() * 1000);
    }

    public void start() {
        int choice;
        do {
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                scanner.nextLine();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("");
                    System.out.println(".........Exiting..........");
                    System.out.println("(:*-*Tanks For Coming*-*:)");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 3);
    }

    public static void main(String[] args) {
        BankingSystem bankSystem = new BankingSystem();
        bankSystem.start();
    }
}