public class TestClass {
    public static void main(String[] args) {
        TimsOrder t = TimsOrder.create();
        System.out.println(t);
        System.out.printf("Total Price: $%.2f\n", t.getAmountDue());
        NailGun ng = NailGun.create();
        System.out.println(ng);
        ng.rent();
        ng.rent();
        ng.returnItem();
        ng.returnItem();
        }

}
