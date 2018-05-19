package codingblocks.com.billsplit.model;

import java.util.List;
import java.util.Set;

/**
 * Created by hp on 5/15/2018.
 */
public class Tour {
    public String id;
    public String name;
    public Set<String> tours;

    public List<Transaction> transactions;
}
