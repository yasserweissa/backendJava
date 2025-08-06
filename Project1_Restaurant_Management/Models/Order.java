package Project1_Restaurant_Management.Models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.time.format.DateTimeFormatter;


public class Order {
    private final String orderId;
    private final Customer customer;
    private final Map<Pizza, Integer> items;
    private final String orderTime;
    private final String address;
    private final String phoneNum;

    public Order(Map<Pizza, Integer> items, Customer customer, String address, String phoneNum) {
        this.orderId = "PZ_" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.customer = customer;
        this.items = items;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.orderTime = LocalDateTime.now().format(formatter);
        this.address = address;
        this.phoneNum = phoneNum;
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<Pizza, Integer> getItems() {
        return items;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void printOrder() {
        if (items == null || items.isEmpty()) {
            System.out.println("Your order is empty.");
            return;
        }

        double total = 0.0;
        System.out.println("Your Order:");
        System.out.println("========================================");
        System.out.printf("%-20s %-10s %-10s\n", "Pizza", "Qty", "Subtotal");
        System.out.println("----------------------------------------");

        for (Map.Entry<Pizza, Integer> entry : items.entrySet()) {
            Pizza pizza = entry.getKey();
            int quantity = entry.getValue();
            double subtotal = pizza.getPrice() * quantity;
            total += subtotal;

            System.out.printf("%-20s %-10d %-10.2f\n", pizza.getName(), quantity, subtotal);
        }

        System.out.println("========================================");
        System.out.printf("%32s%.2f\n", "Total: ", total);
    }

    public void submit() {
//        String filePath = "orders.txt";  // adjust path if needed
        Path filePath = Paths.get(System.getProperty("user.dir"), "Project1_Restaurant_Management/Data", "orders.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toString(), true))) {
            writer.write("Order ID: " + orderId);
            writer.newLine();
            writer.write("Order Time: " + orderTime);
            writer.newLine();
            writer.write("Customer: " + customer.getUsername());
            writer.newLine();
            writer.write("Address: " + address);
            writer.newLine();
            writer.write("Phone Number: " + phoneNum);
            writer.newLine();
            writer.write(String.format("%-20s %-10s %-10s", "Pizza", "Qty", "Subtotal"));
            writer.newLine();

            double total = 0.0;
            for (Map.Entry<Pizza, Integer> entry : items.entrySet()) {
                Pizza pizza = entry.getKey();
                int quantity = entry.getValue();
                double subtotal = pizza.getPrice() * quantity;
                total += subtotal;

                writer.write(String.format("%-20s %-10d %-10.2f", pizza.getName(), quantity, subtotal));
                writer.newLine();
            }

            writer.write(String.format("%32s%.2f", "Total: ", total));
            writer.newLine();
            writer.write("Order Status: PENDING");
            writer.newLine();
            writer.write("--------------------------------------------------");
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Failed to write order to file: " + e.getMessage());
        }
    }
}
