public class University extends Thread{

    private CurrentAccount currentAccount;
    private String uniName;


    public University(ThreadGroup group, String name, CurrentAccount currentAccount, String uniName) {
        super(group, name);
        this.currentAccount = currentAccount;
        this.uniName = uniName;
    }

    public String getUniName() {
        return uniName;
    }

    @Override
    public void run() {
        System.out.println("\033[1m"+"===== University transactions Starts ====="+"\033[0m" );

        for (int i=0; i<3; i++) {
            Transaction fee = new Transaction(getUniName(), 50000);
            currentAccount.withdrawal(fee);

            System.out.println("[University]: Withdraw action : " + fee + "\n[University Transaction completed]\n");

            try {
                sleep((long) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("\033[1m"+"===== University transactions over =====\n"+"\033[0m");
    }
}
