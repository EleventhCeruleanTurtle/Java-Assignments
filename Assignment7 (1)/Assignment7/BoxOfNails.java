import java.util.Scanner;

public class BoxOfNails extends TimsProduct{
    /** size of items */
    private double size;
    /** quantity of items */
    private int quantity;

    /**
     * Constructor takes:
     * @param name the name of the items
     * @param size the size of the items
     * @param quantity the quantity of the items
     * @param cost the cost of the items
     * @param price the price of the items
     */
    private BoxOfNails(String name, double size, int quantity, double cost, double price) {
        super(name, cost, price);
        this.quantity = quantity;
        this.size = size;
    }

    /**
     * create method, asks for user input and then creates new BoxOfItems with constructor
     * @return new BoxOfItems object with user answers as parameters
     */
    public static BoxOfNails create() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.next();
        System.out.println("Enter cost");
        double cost = sc.nextDouble();
        System.out.println("Enter price");
        double price = sc.nextDouble();
        System.out.println("Enter size");
        double size = sc.nextDouble();
        System.out.println("Enter quantity");
        int quantity = sc.nextInt();
        return new BoxOfNails(name, size, quantity, cost, price);
    }

    /**
     * getter for size
     * @return size
     */
    public double getSize() {
        return size;
    }

    /**
     * getter for quantity
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * toString for BoxOfNails
     * @return String containing new variables (size, quantity) and call super's toString for others (name, cost, price)
     */
    @Override
    public String toString() {
        return "BoxOfNails [" + super.toString() + ", size=" + size + ", quantity=" + quantity + "]";
    }
}
