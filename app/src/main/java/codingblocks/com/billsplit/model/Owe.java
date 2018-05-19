package codingblocks.com.billsplit.model;

/**
 * Created by hp on 5/19/2018.
 */
public class Owe {
    public String payer;
    public String receiver;
    public int amount;

    public Owe(String payer, String receiver, int amount) {
        this.payer = payer;
        this.receiver = receiver;
        this.amount = amount;
    }
}
