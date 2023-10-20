import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Welcome to order!");
            System.out.println("Please enter:");
            System.out.println("[N] New Order  [Q] Quit");
            // Once the user press enter, the text entered by user is read and store in the String s.
            String s = scanner.nextLine();

            if ("Nn".contains(s)){
                System.out.println("Create a new order...");
                Order order = new Order();
                startOrder(scanner, order);
            } else if ("Qq".contains(s)){
                System.out.println("Quit");
                break;
            } else {
                System.out.println("Error: Invalid input");
            }
        }
    }

    public static void startOrder(Scanner scanner, Order order){

        while(true){
            System.out.println("Menu:");
            System.out.printf("[1] Meal\n[2] Burger\n[3] Topping\n[4] Drink\n[5] Side\n[P] Print the order\n[R] Remove item\n[Y] Submit\n");

            String input = scanner.nextLine();
            switch (input){
                case "2" -> addBurger(scanner, order);
                case "3" -> addTopping(scanner, order);
                case "4" -> addDrink(scanner, order);
                case "5" -> addSide(scanner, order);
                case "P", "p" -> order.printOrder();
                case "R", "r" -> removeItem(scanner, order);
            }
        }
    }

    public static void addBurger (Scanner scanner, Order order){
        while(true){
            System.out.println("Menu -> Burger:");
            System.out.print("[1] Cheese Burger\n[2] Double Cheese Burger\n[3] Deluxe Burger\n[Q] Back to the previous page\n");

            String input = scanner.nextLine();
            if("Qq".contains(input)){
                startOrder(scanner, order);
                break;
            } else if ("123".contains(input)) {
                order.addBurger(Integer.parseInt(input));
                order.printOrder();
            } else {
                System.out.println("Error: Invalid input");
            }

        }
    }

    public static void addDrink (Scanner scanner, Order order){
        while(true){
            System.out.println("Menu -> Drink:");
            System.out.print("[1] Regular Coke\n[2] Regualr Pepsi\n[3] Large Pepsi\n[Q] Back to the previous page\n");

            String input = scanner.nextLine();
            if("Qq".contains(input)){
                startOrder(scanner, order);
                break;
            } else if ("123".contains(input)) {
                order.addDrink(Integer.parseInt(input));
                order.printOrder();
            } else {
                System.out.println("Error: Invalid input");
            }

        }
    }

    public static void addSide (Scanner scanner, Order order){
        while(true){
            System.out.println("Menu -> Side:");
            System.out.print("[1] Salad\n[2] Fries\n[3] Corn Cob\n[Q] Back to the previous page\n");

            String input = scanner.nextLine();
            if("Qq".contains(input)){
                startOrder(scanner, order);
                break;
            } else if ("123".contains(input)) {
                order.addSide(Integer.parseInt(input));
                order.printOrder();
            } else {
                System.out.println("Error: Invalid input");
            }

        }
    }

    public static void addTopping (Scanner scanner, Order order){
//        List<Burger> burger = order.getItems().stream()
//                //筛选Burger
//                .filter(item -> item instanceof Burger)
//                .map(item -> (Burger) item)
//                .toList();
        while(true){
            System.out.println("Menu -> Topping:");
            System.out.println("Select a burger for toppings:");
            System.out.println("[Q] Back to the previous page");
            order.printOrder();
//            burger.forEach(System.out::println);

            String input = scanner.nextLine();
            if("Qq".contains(input)){
                startOrder(scanner, order);
                break;
            } else if (Integer.parseInt(input) <= order.getItems().size()) {
                System.out.print("[1] Tomato\n[2] Pepper\n[3] Lettuce\n[4] Mayo\n[5] Ketchup\n");
                String inputTopping = scanner.nextLine();
                order.addTopping(Integer.parseInt(input),Integer.parseInt(inputTopping));


            } else {
                System.out.println("Error: Invalid input");
            }

        }
    }

    public static void removeItem (Scanner scanner, Order order){

        while(true) {
            System.out.println("Menu -> removeItem:");
            System.out.println("Remove a item:");
            order.printOrder();
            System.out.println("[Q] Back to the previous page" );
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("Q")){
                startOrder(scanner, order);
                break;
            }
            order.removeItem(Integer.parseInt(input));
            System.out.println("Remove successfully");
            System.out.println();
        }

    }
}