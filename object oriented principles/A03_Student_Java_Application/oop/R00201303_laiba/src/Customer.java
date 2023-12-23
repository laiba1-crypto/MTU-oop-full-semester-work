
/**
 * @author: Laiba Asif
*/
//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------

import java.util.ArrayList;

public class Customer {

    // ---------------------------------------
    // Fields
    // ---------------------------------------
    private String name, address;
    private ArrayList<Order> orders;

    public Customer(String theName, String theAddress) {
        // ---------------------------------------
        // Constructor
        // ---------------------------------------
        name = theName;
        address = theAddress;
        orders = new ArrayList<Order>();
    }
    // ---------------------------------------
    // GET METHODS
    // ---------------------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    // ---------------------------------------
    // SET METHODS
    // ---------------------------------------

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

}
