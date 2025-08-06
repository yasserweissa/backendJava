package Project1_Restaurant_Management.Models;

import Project1_Restaurant_Management.Data.DataLoader;
import Project1_Restaurant_Management.Services.Interfaces.Registerable;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Customer extends User implements Registerable {
    List<Order> orders;

    private static final String USER_FILE = "/home/yasser/learnin/EraaSoft/Project1_Restaurant_Management/Data/users.txt";
    final String role = "Customer";

    @Override
    public String toString() {
        return String.format("%-10s %-10s %-10s", getUsername(), getPassword(), role);
    }

    @Override
    public boolean register(String username, String password) {
        try (FileWriter fw = new FileWriter(USER_FILE, true)) {
            fw.write("\n" + username + "," + password + ",customer");
            return true;
        }
        catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            return false;
        }
    }
}
