

1. **BankAccount Class**
   - **Purpose**: Represents an individual bank account.
   - **Attributes**:
     - `accountNumber`: A unique identifier for each account.
     - `accountHolderName`: Name of the person who owns the account.
     - `balance`: The current balance in the account.
   - **Methods**:
     - `deposit(amount)`: Adds a specified amount to the account balance.
     - `withdraw(amount)`: Deducts a specified amount from the account, ensuring there are sufficient funds.
     - `checkBalance()`: Returns the current account balance.

2. **Bank Class**
   - **Purpose**: Manages multiple bank accounts.
   - **Attributes**:
     - A collection (such as a `HashMap` or `List`) of `BankAccount` objects, allowing the system to keep track of multiple accounts.
   - **Methods**:
     - `createAccount(accountNumber, accountHolderName, initialBalance)`: Creates and adds a new account to the system.
     - `findAccount(accountNumber)`: Locates an account based on its account number.
     - `depositToAccount(accountNumber, amount)`: Deposits money into a specific account.
     - `withdrawFromAccount(accountNumber, amount)`: Withdraws money from a specific account.
     - `displayAllAccounts()`: Lists all the accounts with their details (account number, holder's name, and balance).

3. **Main Program**
   - **Purpose**: The entry point of the banking system where the user can interact with the system.
   - **Operations**:
     - **Account creation**: Allows the user to input details for creating a new bank account.
     - **Deposit & Withdraw**: Enables the user to deposit or withdraw money from their account by specifying the account number.
     - **Check Balance**: Allows users to inquire about their account balance.
     - **View All Accounts**: Displays details of all accounts in the bank.

### Core Concepts:

- **Encapsulation**: The system uses classes to encapsulate bank account data and behavior, ensuring that account details are secure and only modifiable through defined methods (deposit, withdraw, etc.).
  
- **Object-Oriented Design**: Each account is represented as an object, and the bank manages these objects using a collection like a `HashMap` or `List`.

- **Data Validation**: Ensures that operations like withdrawal cannot occur if there are insufficient funds, and deposits are only valid with positive amounts.

- **Scalability**: By using a collection like a `HashMap`, the system can manage many accounts efficiently, allowing easy lookup and modification of individual accounts.

### Flow of the System:
1. **Account Creation**: When a new account is created, a `BankAccount` object is initialized with a unique account number, account holder's name, and initial balance.
2. **Deposits and Withdrawals**: These actions modify the balance of an existing account after checking the validity (e.g., checking if there are enough funds for a withdrawal).
3. **Balance Inquiry**: The system allows users to check the balance of any account by providing the account number.
4. **Account Management**: The bank, as a central system, manages all accounts, ensuring they are easily accessible and modifiable for various operations.

### Example Use Case:
1. **Create Account**: User creates an account with a specified account number, name, and initial balance.
2. **Deposit Money**: User deposits money into their account.
3. **Withdraw Money**: User withdraws money, but only if there is enough balance.
4. **Check Balance**: User checks the current balance.
5. **Manage Multiple Accounts**: The system can handle and list multiple accounts efficiently.

This is a typical design for a simple banking system in Java, focusing on object-oriented principles to create a modular and maintainable program.
