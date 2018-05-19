package codingblocks.com.billsplit.model;

import android.util.ArraySet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by hp on 5/15/2018.
 */
public class User {
    public String id;
    public String name;
    public Set<String> tours;


    public User() {
        tours = new HashSet<>();
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.tours = new HashSet<>();
    }
}
