package Project1_Restaurant_Management;

import Project1_Restaurant_Management.Models.*;
import Project1_Restaurant_Management.Data.DataLoader;
import Project1_Restaurant_Management.Services.Implementation.ChefServiceImpl;
import Project1_Restaurant_Management.Services.Implementation.CustomerServiceImpl;
import Project1_Restaurant_Management.Services.Implementation.DeliveryServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to our Restaurant's new system!\nThis is the login page.");
            User user = getUser();
            while (user == null) {
                user = getUser();
            }
            System.out.println("You are now logged in as a " + user.getUserType());

            if (user.getUserType().equals("customer")) {
                CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl((Customer) user);
                customerServiceImpl.runServices();
            } else if (user.getUserType().equals("chef")) {
                ChefServiceImpl chefServiceImpl = new ChefServiceImpl((Chef) user);
                chefServiceImpl.runServices();
            } else if (user.getUserType().equals("delivery")) {
                DeliveryServiceImpl deliveryServiceImpl = new DeliveryServiceImpl((DeliveryGuy) user);
                deliveryServiceImpl.runServices();
            }
        }
    }

    public static User getUser(){
        Scanner scanner = new Scanner(System.in);
        List<User> users = DataLoader.loadUsers();
        while (true){
            System.out.println("=======================================");
            System.out.print("Enter your username to login/register: ");
            String username = scanner.nextLine();
            String userType = "";
            for (User user : users) {
                if (username.equals(user.getUsername())) {
                    userType = user.getUserType();
                    System.out.print("Hi again " + username + "!\nWe are glad to have you as our "+ userType + ".\nEnter your password to login: ");
                    String password = scanner.nextLine();
                    if (user.checkPassword(password)){
                        System.out.println("You have logged in successfully.");
                        return user;
                    } else {
                        System.out.println("Incorrect Password");
                    }
                }
            }
            if (userType.isEmpty()){
                System.out.print("Hi " + username + "!\nWe are excited to have you as a new customer.\nEnter a password to register: ");
                String password = scanner.nextLine();
                System.out.print("Enter the password again to confirm: ");
                String passwordConfirmation = scanner.nextLine();
                if (password.equals(passwordConfirmation)){
                    Customer newCustomer = new Customer();
                    if (newCustomer.register(username, password)){
                        newCustomer.setUsername(username);
                        newCustomer.setPassword(password);
                        newCustomer.setUserType("customer");
                        users.add(newCustomer);
                        System.out.println("You have registered successfully.");
                        return newCustomer;
                    } else {
                        System.out.println("An error happened, couldn't register.");
                        return null;
                    }
                } else{
                    System.out.println("Password confirmation was not correct.");
                    return null;
                }
            }
        }
    }
}
