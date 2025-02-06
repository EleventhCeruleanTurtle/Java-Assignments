public abstract class TimsProduct implements Commodity{
    // name of product
    private String name;
    // cost of product
    private double cost;
    // price of product
    private double price;

    /**
     * constructor for TimsProduct
     * @param name name of product
     * @param cost cost of product
     * @param price price of product
     */
    public TimsProduct(String name, double cost, double price) {
        this.name = name;
        this.cost = cost;
        this.price = price;
    }

    /**
     * getter for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /** 
     * getter for cost
     * @return cost
     */
    public double getProductCost() {
        return cost;
    }

    /**
     * getter for price
     * @return price
     */
    public double getRetailPrice() {
        return price;
    }

    /**
     * toString for TimsProduct
     * @return String with name, cost and price of product
     */
    @Override
    public String toString() {
        return "TimsProduct [name=" + name + ", cost=" + cost + ", price=" + price + "]";
    }
    
}
