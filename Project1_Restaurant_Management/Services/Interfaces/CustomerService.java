package Project1_Restaurant_Management.Services.Interfaces;

import Project1_Restaurant_Management.Models.Customer;
import Project1_Restaurant_Management.Models.Pizza;

import java.util.Map;

public interface CustomerService {
    void viewMenu();
    void makeOrder(Customer customer);
}
