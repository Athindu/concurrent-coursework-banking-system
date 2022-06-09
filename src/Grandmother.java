public class Grandmother extends Thread{

    private CurrentAccount currentAccount;
    private String gName;

    public Grandmother(ThreadGroup group, String name, CurrentAccount currentAccount, String gName) {
        super(group, name);
        this.currentAccount = currentAccount;
        this.gName = gName;
    }

    public String getgName() {
        return gName;
    }

    @Override
    public void run() {
        System.out.println("\033[1m"+"===== Grandmother transactions Starts ====="+"\033[0m");

        Transaction birthdayGift = new Transaction( getgName(), 10000);
        currentAccount.deposit(birthdayGift);
        System.out.println("[GrandMother]: Deposit action : " + birthdayGift + "\n[GrandMother Transaction completed]\n");

        try {
            sleep((long) Math.random()*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Transaction christmasGift = new Transaction( getgName(), 5000);
        currentAccount.deposit(christmasGift);
        System.out.println("[GrandMother]: Deposit action : " + christmasGift+ "\n[GrandMother Transaction completed]\n");

        System.out.println("\033[1m"+"===== Grandmother transactions over =====\n"+"\033[0m");

    }
}
