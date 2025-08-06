package Project1_Restaurant_Management.Models;

public class DeliveryGuy extends User{

    final String role = "Delivery Guy";

    @Override
    public String toString() {
        return String.format("%-10s %-10s %-10s", getUsername(), getPassword(), role);
    }

}
