public class StatementEntry {

    private final char TAB = '\t' ;

    private final String CustomerID ;
    private final int    amount ;
    private final int    currentBal ;

    public StatementEntry(String customerID, int amount, int currentBal) {
        CustomerID = customerID;
        this.amount = amount;
        this.currentBal = currentBal;
    }

    public String getCustomer() {
        return CustomerID;
    }

    public int getAmount() {
        return amount;
    }

    public int getCurrentBalance() {
        return currentBal;
    }

    public String toStringOLD( ) {
        return  new String( "Customer: " + CustomerID + ","  + TAB +
                "Amount: "   + amount     + ", " + TAB +
                "Balance: "  + currentBal
        ) ;
    }

//    @Override
//    public String toString() {
//        return "Customer: " +
//                CustomerID + ","  + TAB +
//                "Amount: "   + amount     + ", " + TAB +
//                "Balance: "  + currentBal ;
//    }
}
