public class Transaction {

    private final String CustomerID ;
    private final int    amount ;

    public Transaction(String customerID, int amount) {
        CustomerID = customerID;
        this.amount = amount;
    }

    public String getCID() {
        return CustomerID;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return  new String( "[ " +
                "Customer: " + CustomerID + ", " +
                "Amount: "   + amount +
                "]"
        ) ;
    }
}
