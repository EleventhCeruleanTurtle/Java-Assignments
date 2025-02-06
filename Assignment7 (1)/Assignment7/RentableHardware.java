public abstract class RentableHardware extends TimsProduct implements Rentable {
    // rental cost of product
    private double rentalCost;
    // whether the item is currently being rented out or not
    private boolean rented;

    /**
     * Constructor for RentableHardware
     * @param name name of the product
     * @param rentalCost rental cost of the product
     * @param cost cost of the product
     * @param price price of the product
     */
    public RentableHardware(String name, double rentalCost, double cost, double price) {
        super(name, cost, price);
        this.rentalCost = rentalCost;
    }

    /**
     * getter for rental cost
     * @return rentalCost
     */
    public double getRentalCost() {
        return rentalCost;
    }

    /**
     * If item in not being rented, rents item. sets rented to true if false.
     */
    public void rent() {
        if (this.rented) {
            System.out.println("Sorry this product is already being rented.");
        } else {
            this.rented = true;
            System.out.println("This item is now being rented.");
        }
    }

    /**
     * if item is being rented, returns item. Sets rented to false if true.
     */
    public void returnItem() {
        if (this.rented == false) {
            System.out.println("This item is not being rented.");
        } else {
            this.rented = false;
            System.out.println("Thank you for returning this item.");
        }
    }

    /**
     * getter for rented
     * @return rented
     */
    public boolean isRented() {
        return rented;
    }

    
}
