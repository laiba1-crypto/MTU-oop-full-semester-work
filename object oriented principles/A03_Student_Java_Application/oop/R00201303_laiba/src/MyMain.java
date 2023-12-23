
/**
 * @author: Laiba Asif
*/
//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------

import java.util.ArrayList;
import java.util.Scanner;

//--------------------------------------------------
//
//	CLASS MyMain
//
//--------------------------------------------------
/**
 * This is the main class for the A03 Project,
 * representing the management of a drugstore<br>
 * .
 */

public class MyMain {
    static Scanner sc = new Scanner(System.in);

    public static boolean checkDouble(String s) {
        // for robustness, check that that certain values are doubles
        boolean result = true;
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            result = false;
        }
        return result;
    }

    public static boolean checkInt(String s) {
        // for robustness, check that that certain values are ints
        boolean result = true;
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            result = false;
        }
        return result;
    }

    public static HairElectronic createHairElectronic() {// Create a new Hair Electronic
        String make, type, description;
        int power = 0;// initialise to avoid error. In reality variable has to be assigned a value to
                      // exit the do while loop below.
        boolean isNumeric;
        double price = 0;// initialise to avoid error.

        System.out.println("Hair Electronic make:");
        make = sc.nextLine();
        System.out.println("Hair Electronic type:");
        type = sc.nextLine();

        do {// for robustness, check that power is an int
            isNumeric = true;
            System.out.println("Hair Electronic power(volts):");
            String powerNumericCheck = sc.nextLine();
            if (checkInt(powerNumericCheck)) {
                power = Integer.parseInt(powerNumericCheck);
            } else {
                isNumeric = false;
                System.out.println("Please enter a numeric value for power(volts).");
            }
        } while (isNumeric == false);

        do {// for robustness, check that price is a double
            isNumeric = true;
            System.out.println("Hair Electronic price:");
            String priceNumericCheck = sc.nextLine();
            if (checkDouble(priceNumericCheck)) {
                price = Double.parseDouble(priceNumericCheck);
            } else {
                isNumeric = false;
                System.out.println("Please enter a numeric value for price.");
            }
        } while (isNumeric == false);

        System.out.println("Enter Hair Electronic description:");
        description = sc.nextLine();

        HairElectronic newPhone = new HairElectronic(make, type, power, price, description);
        return newPhone;
    }

    public static Customer createCustomer() {// Create a new customer
        String name, address;
        System.out.println("Customer Name:");
        name = sc.nextLine();
        System.out.println("Customer Address (1 Line):");
        address = sc.nextLine();

        Customer newCustomer = new Customer(name, address);
        return newCustomer;
    }

    public static void main(String[] args) {
        ArrayList<Customer> custList = new ArrayList<Customer>(); // To handle "add new customer" menu option

        HairElectronic he0 = new HairElectronic("Rimmington", "straightner", 120, 80,
                "Equipped with tourmaline-ceramic plates, this BaByliss straightener will drift effortlessly through your hair to create a sleek, straight look that lasts from morning until night");
        HairElectronic he1 = new HairElectronic("Bayliss", "curler", 100, 100,
                "Easy to use lever to softly hold the hair as you curl.");
        Epilator ep0 = new Epilator("philips", "Series 8000", 3, false, 70,
                "This epilator comes with a handy exfoliator head that will help prevent any painful ingrown hairs. It performed better on wet skin and we noticed a reduction in hair regrowth after eight weeks of use. The hair that did grow back was more sparse and finer, too.");
        Epilator ep1 = new Epilator("Braun", "Silk-épil 9 9-561", 5, true, 55,
                "It features an in-built light that allows you to see any spots you’ve missed and worked well on both wet and dry skin. ");

        ProductDB database = new ProductDB();

        database.add(he0);
        database.add(he1);
        database.add(ep0);
        database.add(ep1);
        // For testing application, the
        // projectDB will be used to access product info, rather than variables such as
        // he0 and ep1.

        Customer cust1 = new Customer("Laiba", "Sharock Road, Cork");
        custList.add(cust1);

        Order o = new Order();

        o.add(he0, 2);// 2 rimmington
        o.add(ep0, 1);// 1 Braun

        cust1.getOrders().add(o);

        int menu;
        String menuCheck;
        boolean validMenu;
        // --------------------------------------------------
        // printMenu
        // --------------------------------------------------
        /**
         * This function prints the menu by the screen to the user.<br>
         */

        do {
            validMenu = true;

            do {// for robustness, check that menu value is an int

                System.out.println("Please Choice An Option?");
                System.out.println("1.\tCreate a new Hair Machine.");
                System.out.println("2.\tCreate a new Customer.");
                System.out.println("3.\tSearch for a product by productid.");
                System.out.println("4.\tDisplay all products.");
                System.out.println("5.\tAllow a customer to order.");
                System.out.println(
                        "6.\tDisplay all orders that a customer has made and all the products that are in a given order.");
                System.out.println("7.\tDisplay all orders for a given product by the productid.");
                System.out.println("8.\tQuit.");
                menuCheck = sc.nextLine();

                if (!checkInt(menuCheck)) {
                    validMenu = false;
                    System.out.println("Please enter a numeric value.");
                }
            } while (validMenu == false);

            menu = Integer.parseInt(menuCheck);

            switch (menu) {
                case 1: // create new hair electronic machine and add to database
                    database.add(createHairElectronic());
                    System.out.println();
                    break;

                case 2:// Create new customer object, store in custList
                    custList.add(createCustomer());
                    System.out.println();
                    break;

                case 3:// Search for product by productID
                    int id;
                    String idCheck;
                    boolean validID;

                    do {
                        validID = true;
                        System.out.println("Enter the productid number:");
                        idCheck = sc.nextLine();

                        if (!checkInt(idCheck)) {
                            validID = false;
                            System.out.println("Please enter a numeric value");
                        } else {

                        }
                    } while (validID == false);

                    id = Integer.parseInt(idCheck);
                    database.find(id).print();// Product print. Not yet cast to hairelectronic or epilator
                    System.out.println();
                    break;

                case 4:// Output every Product in database
                    for (int i = 0; i < database.getProductList().size(); i++) {//
                        database.getProductList().get(i).print();// Product print. Not yet hairelectronic or epilator
                        System.out.println();
                    }
                    System.out.println();
                    break;

                case 5:
                    boolean valid;
                    int custNum = 0, productNum = 0, product = 0;
                    String custCheck, productCheck;

                    do {
                        valid = true;
                        System.out.println("Which customer is placing the order?");
                        for (int i = 0; i < custList.size(); i++) {
                            System.out.println(i + 1);// +- 1 to accommodate zero counting
                            System.out.println(custList.get(i).getName() + ", " + custList.get(i).getAddress());
                        }
                        custCheck = sc.nextLine();

                        if (!checkInt(custCheck)) {
                            valid = false;
                            System.out.println("Please enter a numeric value");
                        } else {
                            custNum = Integer.parseInt(custCheck) - 1;
                        }
                    } while (valid == false);

                    Order custOrder = new Order();// add new order to customer
                    custList.get(custNum).getOrders().add(custList.get(custNum).getOrders().size(), custOrder);

                    do {
                        valid = true;
                        System.out.println("\nWhich products would you like to order?");
                        for (int i = 0; i < database.getProductList().size(); i++) {
                            System.out.println(i + 1);// +- 1 to accommodate zero counting
                            database.getProductList().get(i).print();
                        }
                        productCheck = sc.nextLine();

                        if (!checkInt(productCheck)) {
                            valid = false;
                            System.out.println("Please enter a numeric value");
                        } else {
                            product = Integer.parseInt(productCheck) - 1;
                        }
                    } while (valid == false);

                    do {
                        valid = true;
                        System.out.println("\nHow many of that product would you like to order?");
                        productCheck = sc.nextLine();

                        if (!checkInt(productCheck)) {
                            valid = false;
                            System.out.println("Please enter a numeric value");
                        } else {
                            productNum = Integer.parseInt(productCheck);
                        }
                    } while (valid == false);

                    custOrder.add(database.getProductList().get(product), productNum);// add(product, quantity)

                    break;

                case 6:

                    do {
                        valid = true;
                        custNum = 0;
                        System.out.println("Which customer's orders would you like to view?");
                        for (int i = 1; i <= custList.size(); i++) {
                            System.out.println((i) + ":\t " + custList.get(i - 1).getName() + ", "
                                    + custList.get(i - 1).getAddress());
                        }

                        custCheck = sc.nextLine();

                        if (!checkInt(custCheck)) {
                            valid = false;
                            System.out.println("Please enter a numeric value");
                        }

                    } while (valid == false);
                    custNum = Integer.parseInt(custCheck) - 1;
                    Customer custOption = custList.get(custNum);
                    // +- 1 to accommodate zero counting

                    System.out.println("Which order would you like to view?");
                    String orderCheck;
                    int orderNum;
                    do {
                        valid = true;
                        for (int i = 1; i <= custOption.getOrders().size(); i++) {
                            System.out.println(i);
                        }
                        orderCheck = sc.nextLine();

                        if (!checkInt(orderCheck)) {
                            valid = false;
                            System.out.println("Please enter a numeric value");
                        }

                    } while (valid == false);

                    orderNum = Integer.parseInt(orderCheck) - 1;
                    // +- 1 to accommodate zero counting
                    Order orderOption = custOption.getOrders().get(orderNum);

                    for (int i = 0; i < orderOption.getProductList().size(); i++) {
                        orderOption.getProductList().get(i).print();
                    }
                    break;

                case 7:

                    do {
                        valid = true;
                        System.out.println("Enter the productID of the product which you are looking for.");
                        idCheck = sc.nextLine();

                        if (!checkInt(idCheck)) {
                            valid = false;
                            System.out.println("Please enter a numeric value");
                        }
                    } while (valid == false);

                    int ID = Integer.parseInt(idCheck);

                    for (int i = 0; i < custList.size(); i++) {
                        for (int j = 0; j < custList.get(i).getOrders().size(); j++) {

                            Order orderToCheck = custList.get(i).getOrders().get(j);

                            if (orderToCheck.find(ID) != null) {// Order object inherits the find method from ProductDB
                                                                // class.
                                System.out.println("Customer:\t" + custList.get(i).getName() + ", Order:\t" + (j + 1));
                            } // If find doesn't return a null value, the productID appears in that order. j+1
                              // used to allow for the zero counting

                        }
                    }

                    break;
                case 8:
                    System.out.println("Goodbye, Would Like To See You Again!");
                    break;

                default:
                    System.out.println("Error. Please enter a value between 0 to 8.");
                    menu = 1; // Takes the customer back to the menu
                    break;
            }
        } while (menu != 8);
    }

}
