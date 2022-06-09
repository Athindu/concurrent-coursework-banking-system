import java.sql.Timestamp;

public class BankingSystem {

    CurrentAccount currentAccount;
    Student student;
    Grandmother grandmother;
    LoanCompany company;
    University university;

    ThreadGroup groupHuman;
    ThreadGroup groupOrganization;

    public BankingSystem() {
        this.groupHuman = new ThreadGroup("Human");
        this.groupOrganization = new ThreadGroup("Organization");
        this.currentAccount = new CurrentAccount("Athindu",5000,248995486);
        this.student = new Student(groupHuman,groupHuman.getName(),currentAccount,currentAccount.getAccountHolder());
        this.grandmother = new Grandmother(groupHuman,groupHuman.getName(),currentAccount,"Grandmother");
        this.company = new LoanCompany(groupOrganization,groupOrganization.getName(),currentAccount,"Loan Company");
        this.university = new University(groupOrganization,groupOrganization.getName(),currentAccount,"University");
    }

    public static void main(String[] args) {
        BankingSystem system = new BankingSystem();
        long startTime = System.currentTimeMillis();
        System.out.println("\033[1m"+"[Bank_System] - System started " +"\033[0m"+ new Timestamp(System.currentTimeMillis())+"\n");

        system.student.start();
        system.grandmother.start();
        system.company.start();
        system.university.start();
        try {
            system.student.join();
            system.grandmother.join();
            system.company.join();
            system.university.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("\033[1m"+"[Bank_System] - All the transactions have been terminated. "+"\033[0m" + new Timestamp(System.currentTimeMillis()));
        System.out.println("[Bank_System] - Execution time: "+(endTime - startTime) + "ms \n");
        //Print final bank statement
        system.currentAccount.printStatement();
    }
}
