import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Item> items;
    private double totalPrice;

    //Constructor (Create a new order)
    public Order() {
        this.items = new ArrayList<>();
        totalPrice = 0;
    }

    public List<Item> getItems(){
        return items;
    }

    public void addDrink(int number){
        Item newDrink = Drink.getDrink(number);
        items.add(newDrink);
        totalPrice += newDrink.getPrice();
    }

    public void addSide(int number){
        Item newSide = Side.getSide(number);
        items.add(newSide);
        totalPrice += newSide.getPrice();
    }

    public void addBurger(int number){
        Burger newBurger = Burger.getBurger(number);
        items.add(newBurger);
        totalPrice += newBurger.getPrice();
    }

    public void addTopping(int orderIndex, int number){
        // number is index of order item. 请确保选中的是一个汉堡，而不是饮料啥的！
        if (getItems().get(orderIndex-1).getClass().getSimpleName().equals("Burger")){
            Burger selectedBurger = (Burger) getItems().get(orderIndex-1);
            //根据number增加topping
            selectedBurger.addTopping(number);

            // 读取最后一项topping的价格，并增加到total price.
            totalPrice += selectedBurger.getToppingList().get(selectedBurger.getToppingList().size()-1).getPrice();
        } else {
            System.out.println("Error: The selected item is not a Burger");

        }

    }

    public void removeItem(int orderIndex){
        if(orderIndex <= getItems().size()){
            getItems().remove(orderIndex-1);
        }
    }

    public void printOrder(){
        int index = 0;
        for (Item item : items) {
            index += 1;
            System.out.print("[" + index + "] ");
            System.out.println(item);
        }

        System.out.println("Order:");
        System.out.println("Total price: " + totalPrice);
        System.out.println("---------------------------");
    }


}
