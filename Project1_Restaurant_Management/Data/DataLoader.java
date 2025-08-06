package Project1_Restaurant_Management.Data;

import Project1_Restaurant_Management.Models.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    public static List<User> loadUsers() {
        Path filePath = Paths.get(System.getProperty("user.dir"), "Project1_Restaurant_Management/Data/users.txt");
        List<User> users = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String username = parts[0];
                    String password = parts[1];
                    String userType = parts[2];
                    if (userType.equals("chef")){
                        User user = new Chef();
                        user.setUsername(username);
                        user.setPassword(password);
                        user.setUserType(userType);
                        users.add(user);
                    }
                    else if (userType.equals("customer")) {
                        User user = new Customer();
                        user.setUsername(username);
                        user.setPassword(password);
                        user.setUserType(userType);
                        users.add(user);
                    }
                    else if (userType.equals("delivery")) {
                        User user = new DeliveryGuy();
                        user.setUsername(username);
                        user.setPassword(password);
                        user.setUserType(userType);
                        users.add(user);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading users: " + e.getMessage());
        }

        return users;
    }

    public static List<Pizza> loadMenu() {
        Path filePath = Paths.get(System.getProperty("user.dir"), "Project1_Restaurant_Management/Data/menu.txt");
        List<Pizza> menu = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            int id = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    double price = Double.parseDouble(parts[1]);

                    Pizza pizza = new Pizza();
                    pizza.setName(name);
                    pizza.setId(String.valueOf(id));
                    pizza.setPrice(price);
                    menu.add(pizza);
                    id++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading menu: " + e.getMessage());
        }

        return menu;
    }

    public static List<Order> loadCurrentOrders(String s) {
        return List.of();
    }
}
