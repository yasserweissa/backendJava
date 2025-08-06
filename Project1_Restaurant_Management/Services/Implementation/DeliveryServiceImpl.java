package Project1_Restaurant_Management.Services.Implementation;

import Project1_Restaurant_Management.Data.DataLoader;
import Project1_Restaurant_Management.Models.DeliveryGuy;
import Project1_Restaurant_Management.Models.Order;
import Project1_Restaurant_Management.Services.Interfaces.DeliveryService;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryGuy deliveryGuy;
    private Map<String, String> orderIdAndStatusesMap = new HashMap<>();

    public DeliveryServiceImpl (DeliveryGuy deliveryGuy){
        this.deliveryGuy = deliveryGuy;
        List<Order> orders = DataLoader.loadCurrentOrders("/home/yasser/learnin/EraaSoft/Project1_Restaurant_Management/Data/orders.txt");
        this.orderIdAndStatusesMap = getOrderIdAndStatusMap();
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
                    if (!block.isEmpty() && printBlock) {
                        block.forEach(System.out::println);
                        System.out.println();
                    }

                    // Reset for new block
                    block.clear();
                    printBlock = false;

                    String orderId = line.substring("Order ID:".length()).trim();
                    if (orderIdAndStatusesMap.getOrDefault(orderId, "").equals("READY_TO_BE_DELIVERED")) {
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

    public void runServices() {
        Scanner scanner = new Scanner(System.in);
        boolean stayLoggedIn = true;
        while (stayLoggedIn) {
            System.out.println("Options:\n\t[1] I want to view orders that need to be delivered\n\t[2] I want to mark an order as delivered\n\t[3] That's all for now, I will log out");
            System.out.print("Enter option number: ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                viewOrders();
            } else if (choice == 2) {
                String orderId = getOrderId();
                updateOrderStatus(orderId, "DELIVERED\nDelivered by: " + deliveryGuy.getUsername());
            } else if (choice == 3) {
                stayLoggedIn = false;
                System.out.println("\nSee you again soon, " + deliveryGuy.getUsername() + "!\nGoodbye for now...\n------------------------------");
            } else {
                System.out.println("Invalid, there is no option with this number.");
            }
        }
    }

    private String getOrderId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("To update the status of an order, please enter its id:");
        return scanner.nextLine();
    }
}
