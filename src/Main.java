
public class Main {
    public static void main(String[] args) {

        Order order = new Order();

        order.addBurger(2);
        order.addBurger(2);
        order.addSide(3);
        System.out.println();


//        order.getItems().get(3).addTopping(1);
        order.printOrder();
        System.out.println();


        order.addTopping(2,1);
        order.addTopping(2,2);
        //order.printOrder();
        order.printOrder();



    }
}