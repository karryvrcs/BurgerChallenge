import java.util.ArrayList;
import java.util.List;


public class Item {
    private String name;
    private String type;
    private double price;

    public Item(String name, String type, double price){
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public double getPrice() {

        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }

    public void addTopping(int i) {
    }
}


class Drink extends Item{
    private String size;
    public Drink(String name, double price, String size) {
        super(name, "Drink", price);
        this.size = size;
    }

    // factory method
    public static Drink getDrink(int number){
        return switch (number){
            case 1 -> new Drink("Coke", 5, "Regular");
            case 2 -> new Drink("Pepsi", 6, "Regular");
            case 3 -> new Drink("Pepsi", 7.5, "Large");
            default -> throw new IllegalStateException("Unexpected value: " + number);
        };
    }



    @Override
    public String toString() {
        return "Drink{" +
                "size='" + size + '\'' +
                "} " + super.toString();
    }
}


class Side extends Item {
    public Side(String name, double price) {
        super(name, "Side", price);
    }

    public static Side getSide(int number){
        return switch (number){
            case 1 -> new Side("Salad", 3);
            case 2 -> new Side("Fries", 4);
            case 3 -> new Side("Corn Cob", 5);
            default -> throw new IllegalStateException("Unexpected value: " + number);
        };
    }

}


class Burger extends Item{
    private List<Item> toppingList;
    private int maxToppings;

    public Burger(String name, double price, int maxToppings) {
        super(name, "Burger", price);
        this.toppingList = new ArrayList<Item>();
        this.maxToppings = maxToppings;
    }

    public static Burger getBurger(int number){
        return switch (number) {
            case 1 -> new Burger("Cheese Burger", 45, 3);
            case 2 -> new Burger("Double Cheese Burger", 65, 3);
            case 3 -> new Burger("Deluxe Burger", 75, 5);
            default -> throw new IllegalStateException("Unexpected value: " + number);
        };
    }


    public void addTopping (int number){
        Topping topping = Topping.getTopping(number);
        toppingList.add(topping);
    }

    public List<Item> getToppingList(){
        return toppingList;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "toppingList=" + toppingList +
                ", maxToppings=" + maxToppings +
                "} " + super.toString();
    }
}

class Topping extends Item{

    public Topping(String name, double price) {
        super(name, "Topping", price);
    }

    public static Topping getTopping(int number){
        return switch (number){
            case 1 -> new Topping("Tomato", 1);
            case 2 -> new Topping("Pepper", 1.5);
            case 3 -> new Topping("Lettuce", 1);
            case 4 -> new Topping("Mayo", 2);
            case 5 -> new Topping("Ketchup", 3);
            default -> throw new IllegalStateException("Unexpected value: " + number);
        };
    }


}


