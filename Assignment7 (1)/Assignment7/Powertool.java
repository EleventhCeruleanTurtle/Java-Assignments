import java.util.Scanner;

public class Powertool extends RentableHardware{
    // features of the powertool
    private String features;

    /**
     * Constructor for powertool
     * @param name name of powertool
     * @param features features of powertool
     * @param cost cost of powertool
     * @param price price of powertool
     * @param rentalPrice rental price of powertool
     */
    private Powertool(String name, String features, double cost, double price, double rentalPrice) {
        super(name, rentalPrice, cost, price);
        this.features = features;
    }

    /**
     * Create method for Powertool, takes user input and then calls Powertool constructor with user input as parameters
     * @return Powertool object
     */
    public static Powertool create() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.next();
        System.out.println("Enter cost");
        double cost = sc.nextDouble();
        System.out.println("Enter price");
        double price = sc.nextDouble();
        System.out.println("Enter features");
        String features = sc.next();
        System.out.println("Enter rental price");
        double rentalPrice = sc.nextDouble();
        return new Powertool(name, features, cost, price, rentalPrice);
    }

    /**
     * getter for features
     * @return features
     */
    public String getFeatures() {
        return features;
    }

    /**
     * toString for Powertool
     * @return super's toString, and features
     */
    @Override
    public String toString() {
        return "Powertool [" + super.toString() + ", features=" + features + "]";
    }
}
