public class CurrentAccount implements BankAccount {

    private String accountName;
    private int balance;
    private int accountNo;
    private int amount;
    private String customer;

    private Statement statement;

    public CurrentAccount(String accountName, int balance, int accountNo) {
        this.accountName = accountName;
        this.balance = balance;
        this.accountNo = accountNo;
        this.statement = new Statement(accountName,accountNo);
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public int getAccountNumber() {
        return this.accountNo;
    }

    @Override
    public String getAccountHolder() {
        return this.accountName;
    }

    @Override
    public synchronized void deposit(Transaction t) {
        this.amount = t.getAmount();
        this.balance += this.amount;
        new Statement(getAccountHolder(),getAccountNumber());
        this.statement.addTransaction(t.getCID(),t.getAmount(),this.balance);
        notifyAll();
    }

    @Override
    public synchronized void withdrawal(Transaction t) {
        this.amount = t.getAmount();
        this.customer = t.getCID();

        //check for the eligibility of the transaction
        isOverdrawn();

        this.balance -= this.amount;
        new Statement(getAccountHolder(), getAccountNumber());
        this.statement.addTransaction(t.getCID(), t.getAmount(), this.balance);
    }

    //overdrawn status of the transaction
    @Override
    public boolean isOverdrawn() {
        while (this.amount > getBalance()) {
            System.out.println("[Current Account] - "+ this.customer +"'s transaction of "+ this.amount + " failed. Insufficient balance for the transaction. Wait...\n");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public void printStatement() {
        System.out.println("\033[1m"+"------ FINAL BANK STATEMENT ------"+"\033[0m");
        statement.print();
    }
}
