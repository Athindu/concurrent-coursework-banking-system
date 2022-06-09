public class LoanCompany extends Thread {

    private CurrentAccount currentAccount;
    private String companyName;

    public LoanCompany(ThreadGroup group, String name, CurrentAccount currentAccount, String companyName) {
        super(group, name);
        this.currentAccount = currentAccount;
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public void run() {
        System.out.println("\033[1m"+"===== Loan Company transactions Starts ====="+"\033[0m");

        for (int i=0; i<3; i++) {
            Transaction loan = new Transaction(getCompanyName(), 70000);
            currentAccount.deposit(loan);
            System.out.println("[Loan Company]: Deposit action : " + loan+ "\n[Loan Company Transaction completed]\n");

            try {
                sleep((long) Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\033[1m"+"===== Loan Company transactions Over =====\n"+"\033[0m");
    }
}
