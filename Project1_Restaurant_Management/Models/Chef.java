package Project1_Restaurant_Management.Models;

public class Chef extends User{
    @Override
    public String toString() {
        return String.format("%-10s %-10s %-10s", getUsername(), getPassword(), getUserType());
    }
}
