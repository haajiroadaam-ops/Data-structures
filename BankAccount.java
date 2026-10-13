class BankAccount {
    private String accountNumber;
    protected double balance;

    // Constructor
    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Withdraw method
    void withdraw(double amount) {
        if (amount <= 0) {
            refuse("amount must be greater than zero");
        } else if (amount > balance) {
            refuse("not enough money");
        } else {
            balance -= amount;
        }
    }

    // Refuse withdrawal
    void refuse(String why) {
        System.out.println(accountNumber + " refused: " + why);
    }

    // Display balance
    void show() {
        System.out.println(accountNumber + " balance: " + balance);
    }
}

// Savings Account
class SavingsAccount extends BankAccount {

    SavingsAccount(String n, double b) {
        super(n, b);
    }

    @Override
    void withdraw(double amount) {
        if (amount <= 0) {
            refuse("amount must be greater than zero");
        } else if (balance - amount < 50) {
            refuse("must keep at least 50");
        } else {
            balance -= amount;
        }
    }
}

// Current Account
class CurrentAccount extends BankAccount {

    CurrentAccount(String n, double b) {
        super(n, b);
    }

    @Override
    void withdraw(double amount) {
        if (amount <= 0) {
            refuse("amount must be greater than zero");
        } else if (balance - amount < -200) {
            refuse("overdraft limit is 200");
        } else {
            balance -= amount;
        }
    }
}

// Student Account
class StudentAccount extends BankAccount {

    StudentAccount(String n, double b) {
        super(n, b);
    }

    @Override
    void withdraw(double amount) {
        if (amount > 100) {
            refuse("max 100 per withdrawal");
        } else {
            super.withdraw(amount);
        }
    }

    public static void main(String[] args) {

        SavingsAccount s = new SavingsAccount("SAV-1", 200);
        CurrentAccount c = new CurrentAccount("CUR-1", 200);
        StudentAccount t = new StudentAccount("STU-1", 200);

        System.out.println(
                "Each account has 200. Each runs withdraw(300):"
        );

        s.withdraw(300);
        s.show();

        c.withdraw(300);
        c.show();

        t.withdraw(300);
        t.show();

        System.out.println("\nStudent tries withdraw(80):");

        t.withdraw(80);
        t.show();
    }


}