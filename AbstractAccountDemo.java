 public class AbstractAccountDemo {

    // Parent abstract class
    static abstract class BankAccount {
        private String accountNumber;
        protected double balance;

        public BankAccount(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        // Every child must implement withdraw()
        abstract void withdraw(double amount);

        // Shared deposit method
        public void deposit(double amount) {
            if (amount <= 0) {
                refuse("Deposit must be greater than 0");
            } else {
                balance += amount;
                System.out.println("Deposit successful: " + amount);
            }
        }

        // Display refused transaction
        protected void refuse(String reason) {
            System.out.println(accountNumber + " refused: " + reason);
        }

        // Display account balance
        public void show() {
            System.out.println(
                    accountNumber + " balance: " + balance
            );
        }
    }

    // Savings account
    static class SavingsAccount extends BankAccount {
        public SavingsAccount(String number, double balance) {
            super(number, balance);
        }

        @Override
        void withdraw(double amount) {
            if (amount <= 0) {
                refuse("Amount must be greater than 0");
            } else if (balance - amount < 50) {
                refuse("Must keep at least 50");
            } else {
                balance -= amount;
                System.out.println("Savings withdrawal successful");
            }
        }
    }

    // Current account
    static class CurrentAccount extends BankAccount {
        public CurrentAccount(String number, double balance) {
            super(number, balance);
        }

        @Override
        void withdraw(double amount) {
            if (amount <= 0) {
                refuse("Amount must be greater than 0");
            } else if (balance - amount < -200) {
                refuse("Overdraft limit is 200");
            } else {
                balance -= amount;
                System.out.println("Current withdrawal successful");
            }
        }
    }

    // Student account
    static class StudentAccount extends BankAccount {
        public StudentAccount(String number, double balance) {
            super(number, balance);
        }

        @Override
        void withdraw(double amount) {
            if (amount <= 0) {
                refuse("Amount must be greater than 0");
            } else if (amount > 100) {
                refuse("Maximum withdrawal is 100");
            } else if (amount > balance) {
                refuse("Insufficient balance");
            } else {
                balance -= amount;
                System.out.println("Student withdrawal successful");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        try {
            BankAccount acc1 =
                    new SavingsAccount("SAV-1", 200);

            BankAccount acc2 =
                    new CurrentAccount("CUR-1", 200);

            BankAccount acc3 =
                    new StudentAccount("STU-1", 200);

            System.out.println("=== SAVINGS ACCOUNT ===");
            acc1.deposit(50);
            acc1.withdraw(300);
            acc1.show();

            System.out.println("\n=== CURRENT ACCOUNT ===");
            acc2.deposit(50);
            acc2.withdraw(300);
            acc2.show();

            System.out.println("\n=== STUDENT ACCOUNT ===");
            acc3.deposit(50);
            acc3.withdraw(300);
            acc3.show();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

