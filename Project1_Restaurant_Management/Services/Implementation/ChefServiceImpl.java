package Project1_Restaurant_Management.Services.Implementation;

import Project1_Restaurant_Management.Models.Chef;
import Project1_Restaurant_Management.Services.Interfaces.ChefService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ChefServiceImpl implements ChefService {
    private final Chef chef;
    private Map<String, String> orderIdAndStatusesMap = new HashMap<>();

    public ChefServiceImpl(Chef chef){
        this.chef = chef;
        this.orderIdAndStatusesMap = getOrderIdAndStatusMap();
    }
    private String getOrderId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("To update the status of an order, please enter its id:");
        return scanner.nextLine();
    }

    @Override
    public void addPizza(String name, double price) {
        Path filePath = Paths.get(System.getProperty("user.dir"), "Project1_Restaurant_Management/Data/menu.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.APPEND)) {
            writer.write(name + "," + String.format("%.2f", price));
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to menu.txt: " + e.getMessage());
        }
    }

    @Override
    public void editPizza(String name, String newName, double newPrice) {
        Path filePath = Paths.get(System.getProperty("user.dir"), "Project1_Restaurant_Management/Data/menu.txt");

        try {
            List<String> lines = Files.readAllLines(filePath);
            boolean found = false;

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] parts = line.split(",", 2);

                if (parts.length == 2 && parts[0].equalsIgnoreCase(name)) {
                    lines.set(i, newName + "," + String.format("%.2f", newPrice));
                    found = true;
                    break;
                }
            }

            if (found) {
                Files.write(filePath, lines);
            } else {
                System.out.println("Pizza '" + name + "' not found in the menu.");
            }

        } catch (IOException e) {
            System.out.println("Error editing menu.txt: " + e.getMessage());
        }
    }



    @Override
    public void viewOrders() { // Use the previous method
        Path filePath = Paths.get(System.getProperty("user.dir"), "Project1_Restaurant_Management/Data/orders.txt");

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            boolean printBlock = false;
            List<String> block = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                // Start of a new order
                if (line.startsWith("Order ID:")) {
                    // Check and print the previous block if needed
                    if (!block.isEmpty() && printBlock) {
                        block.forEach(System.out::println);
                        System.out.println(); // extra line between orders
                    }

                    // Reset for new block
                    block.clear();
                    printBlock = false;

                    String orderId = line.substring("Order ID:".length()).trim();
                    if (orderIdAndStatusesMap.getOrDefault(orderId, "").equals("PENDING")) {
                        printBlock = true;
                    }
                }

                block.add(line);

                // End of order block
                if (line.startsWith("Order Status:")) {
                    if (printBlock) {
                        block.forEach(System.out::println);
                        System.out.println("--------------------------------------------------"); // separate orders
                    }
                    block.clear();
                    printBlock = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateOrderStatus(String targetOrderId, String newStatus) {
        Path filePath = Paths.get(System.getProperty("user.dir"), "Project1_Restaurant_Management/Data", "orders.txt");
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(filePath);
            List<String> updatedLines = new ArrayList<>();

            boolean inTargetOrder = false;

            for (String line : lines) {
                if (line.startsWith("Order ID: ") && line.contains(targetOrderId)) {
                    inTargetOrder = true;
                }

                if (inTargetOrder && line.startsWith("Order Status: ")) {
                    line = "Order Status: " + newStatus;
                    inTargetOrder = false;
                }

                updatedLines.add(line);
            }

            Files.write(filePath, updatedLines);
            orderIdAndStatusesMap.put(targetOrderId, newStatus);
            System.out.println("Order status updated successfully.");

        } catch (IOException e) {
            System.err.println("Failed to update order status: " + e.getMessage());
        }
    }

    private Map<String, String> getOrderIdAndStatusMap() {
        Map<String, String> orderIdAndStatusMap = new HashMap<>();

        Path filePath = Paths.get(System.getProperty("user.dir"), "Project1_Restaurant_Management/Data/orders.txt");

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            String currentOrderId = null;
            String currentStatus = null;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("Order ID:")) {
                    currentOrderId = line.substring("Order ID:".length()).trim();
                } else if (line.startsWith("Order Status:")) {
                    currentStatus = line.substring("Order Status:".length()).trim();
                    if (currentOrderId != null) {
                        orderIdAndStatusMap.put(currentOrderId, currentStatus);
                        currentOrderId = null;
                        currentStatus = null;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return orderIdAndStatusMap;
    }


    public void runServices() {
        Scanner scanner = new Scanner(System.in);
        boolean stayLoggedIn = true;
        while (stayLoggedIn) {
            System.out.println("Options:\n\t[1] I want to view new orders that need to be prepared\n\t[2] I want to mark an order as ready to be delivered\n\t[3] I want to add a new Pizza to the menu\n\t[4] I want to edit a Pizza on the menu\n\t[5] That's all for now, I will log out");
            System.out.print("Enter option number: ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                viewOrders();
            }
            else if (choice == 2) {
                String orderId = getOrderId();
                updateOrderStatus(orderId, "READY_TO_BE_DELIVERED\nPrepared by: " + chef.getUsername());
            }
            else if (choice == 3) {
                String pizzaName = getPizzaName();
                double pizzaPrice = getPizzaPrice();
                addPizza(pizzaName, pizzaPrice);
            }
            else if (choice == 4) {
                System.out.print("Enter the current name of the pizza: ");
                String name = getPizzaName();
                System.out.print("Enter the new name of the pizza: ");
                String newName = getPizzaName();
                double pizzaPrice = getPizzaPrice();
                editPizza(name, newName, pizzaPrice);
            }
            else if (choice == 5) {
                stayLoggedIn = false;
                System.out.println("\nSee you again soon, " + chef.getUsername() + "!\nGoodbye for now...\n------------------------------");
            }
            else {
                System.out.println("Invalid, there is no option with this number.");
            }
        }
    }

    private double getPizzaPrice() {
        System.out.print("Enter the price of the pizza: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    private String getPizzaName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
