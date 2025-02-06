import java.util.Arrays;
import java.util.Scanner;

public class TimsOrder {
    /** size of the array */
    private int size;
    /** name of customer */
    private String customerName;
    /** array containing TimsProducts requested by user */
    private static TimsProduct[] order;
    
    /**
     * Constructor for TimsOrder
     * @param customerName customer name
     * @param size size of array
     */
    private TimsOrder(String customerName, int size) {
        this.customerName = customerName;
        this.size = size;
    }

    /**
     *  Create method that takes user input and then creates array with size variable, for specificed size, the user is asked for their 
     *  respecitive variables and related methods such as rent
     * @return TimsOrder object
     */
    public static TimsOrder create() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter customer name");
        String customerName = sc.nextLine();
        System.out.println("Enter size");
        int size = sc.nextInt();
        order = new TimsProduct[size];
        for (int i = 0; i < order.length; i++) {
            System.out.println("Enter type");
            String type = sc.next();
            if (type.equalsIgnoreCase("boxofnails")) {
                order[i] = BoxOfNails.create();
            } else if (type.equalsIgnoreCase("boxofitems")) {
                order[i] = BoxOfItems.create();
            } else if (type.equalsIgnoreCase("nailgun")) {
                System.out.println("Will you be buying this product or renting:");
                String rentBuy = sc.next();
                if (rentBuy.equalsIgnoreCase("buy")) {
                    order[i] = NailGun.create();
                } else {
                    NailGun ng = NailGun.create();
                    order[i] = ng;
                    ng.rent();

                }
            } else if (type.equalsIgnoreCase("powertool")) {
                System.out.println("Will you be buying this product or renting:");
                String rentBuy = sc.next();
                if (rentBuy.equalsIgnoreCase("buy")) {
                    order[i] = Powertool.create();
                } else {
                    Powertool pt = Powertool.create();
                    order[i] = pt;
                    pt.rent();

                }
            }
        }
        return new TimsOrder(customerName, size);
    }

    /**
     * Grabs the cost, or rent cost if renting, of each object in the array
     * @return total amount of every objects cost or rent cost when applicable
     */
    public double getAmountDue() {
        double amountDue = 0;
        System.out.println(order.length);
        for (int i = 0; i < order.length; i++) {
            if (order[i] instanceof BoxOfNails || order[i] instanceof BoxOfItems ) {
                amountDue += order[i].getProductCost();
            } else {
                if (((RentableHardware) order[i]).isRented()) {
                    amountDue += ((RentableHardware) order[i]).getRentalCost();
                } else {
                    amountDue += order[i].getProductCost();
                }
            }
        }
        return amountDue;
    }

    /**
     * toStrin for TimsOrder
     * @return String with array size, customer name, and objects in array
     */
    @Override
    public String toString() {
        return "TimsOrder{" +
                "size=" + size +
                ", customerName='" + customerName + '\'' +
                ", order=" + Arrays.toString(order) +
                '}';
    }
}
