import java.util.Scanner;

public class NailGun extends RentableHardware{
    // features of the NailGun
    private String features;

    /**
     * Constructor for NailGun
     * @param name name of NailGun
     * @param features features of NailGun
     * @param cost cost of NailGun
     * @param price price of NailGun
     * @param rentalPrice rental price of NailGun
     */
    private NailGun(String name, String features, double cost, double price, double rentalPrice) {
        super(name, rentalPrice, cost, price);
        this.features = features;
    }

    /**
     * Create method for NailGun, takes user input and then calls HailGun constructor with user input as parameters
     * @return NailGun object
     */
    public static NailGun create() {
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
        return new NailGun(name, features, cost, price, rentalPrice);
    }

    /**
     * getter for features
     * @return features
     */
    public String getFeatures() {
        return features;
    }

    /**
     * toString for NailGun 
     * @return super's toString, and features
     */
    @Override
    public String toString() {
        return "NailGun [" + super.toString() + ", features=" + features + "]";
    }
}
