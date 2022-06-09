import java.util.Arrays;
import java.util.List;

public class Student extends Thread {

    private CurrentAccount currentAccount;
    private String sName;


    public Student(ThreadGroup group, String name, CurrentAccount currentAccount, String sName) {
        super(group, name);
        this.currentAccount = currentAccount;
        this.sName = sName;
    }

    public String getsName() {
        return sName;
    }

    @Override
    public void run() {


        System.out.println("\033[1m"+"===== Student Transactions Starts ====="+"\033[0m");

        //withdrawals
        Transaction buyPhone = new Transaction(getsName(), 90000);
        Transaction billPayment = new Transaction(getsName(), 9000);
        Transaction food = new Transaction(getsName(), 7000);

        //deposits
        Transaction winLottery = new Transaction(getsName(), 80000);
        Transaction savings = new Transaction(getsName(), 5000);
        Transaction salary = new Transaction(getsName(), 15000);

        //list to store transactions
        List<Transaction> transactionsList = Arrays.asList(buyPhone,billPayment,food,winLottery,savings,salary);

        for (int i=0; i< transactionsList.size(); i++){
            if (i < 3 ){
                currentAccount.withdrawal(transactionsList.get(i));
                System.out.println("[Student] - Withdraw action: " + transactionsList.get(i) + "\n[Student Transaction completed]\n");
            }
            else if (i < 6 ){
                currentAccount.deposit(transactionsList.get(i));
                System.out.println("[Student] - Deposit action: " + transactionsList.get(i)+"\n[Student Transaction completed]\n");
            }

            //sleep
            try {
                sleep((long) Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\033[1m"+"===== Student Transactions Over =====\n"+"\033[0m");

    }
}
