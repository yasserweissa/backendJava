package Project1_Restaurant_Management.Services.Implementation;

import Project1_Restaurant_Management.Data.DataLoader;
import Project1_Restaurant_Management.Models.Customer;
import Project1_Restaurant_Management.Models.Order;
import Project1_Restaurant_Management.Models.Pizza;
import Project1_Restaurant_Management.Services.Interfaces.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private final Customer customer;
    List<Pizza> pizzasMenu;

    public CustomerServiceImpl(Customer customer) {
        this.pizzasMenu = DataLoader.loadMenu();
        this.customer = customer;
    }

    @Override
    public void viewMenu() {
        System.out.println("===== Our Pizzas Menu =====");
        System.out.println("id  Item            Price");
        for (Pizza pizza : pizzasMenu) {
            System.out.println(pizza.toString());
        }
        System.out.println("===========================\n");
    }

    @Override
    public void makeOrder(Customer customer) {

        Map<Pizza, Integer> items = getOrderItems();
        String address = getAddress();
        String phoneNum = getPhoneNum();
        Order order = new Order(items, customer, address, phoneNum);
        order.printOrder();
        order.submit();
    }

    private String getAddress() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the address to be delivered to: ");
        return sc.nextLine();
    }

    private String getPhoneNum() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a phone number: ");
        return sc.nextLine();
    }

    public Pizza isValid(String string) {
        for (Pizza pizza:pizzasMenu){
            if (string.equals(pizza.getName()) || string.equals(pizza.getId())){
                return pizza;
            }
        }
        return null;
    }

    private Map<Pizza, Integer> getOrderItems() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("please insert the Pizza's name or id:");
        Map<Pizza, Integer> items = new HashMap<>();
        String userInput;
        while (true){
            userInput = scanner.nextLine();
            Pizza pizza = isValid(userInput);
            while (pizza == null){
                System.out.println("Your input does not match the name or the id of any Pizza on our menu.");
                System.out.println("Make sure you insert the name or id correctly.");
                System.out.print("Name/Id: ");
                userInput = scanner.nextLine();
                pizza = isValid(userInput);
            }
            System.out.print("How many " + pizza.getName() + " Pizzas would you like?");
            int quantity = scanner.nextInt();
            items.put(pizza, quantity);
            userInput = scanner.nextLine();
            System.out.print("Anything else? [Yes/No]: ");
            userInput = scanner.nextLine();
            if(userInput.equals("Yes")){
                System.out.print("Please insert the Pizza's name or id:");
            } else {
                return items;
            }
        }
    }

    public void runServices() {
        Scanner scanner = new Scanner(System.in);
        boolean stayLoggedIn = true;
        while (stayLoggedIn){
            System.out.println("Options:\n\t[1] I want to view the menu\n\t[2] I make an order\n\t[3] That's all for now, I will log out");
            System.out.print("Enter option number: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    viewMenu();
                    break;
                case 2:
                    System.out.print("To make an order, ");
                    makeOrder(customer);
                    break;
                case 3:
                    stayLoggedIn = false;
                    System.out.println("\nSee you again soon, " + customer.getUsername() + "!\nGoodbye for now...\n------------------------------");
                    break;
                default:
                    System.out.println("Invalid, there is no option with this number.");
            }
        }
    }
}
