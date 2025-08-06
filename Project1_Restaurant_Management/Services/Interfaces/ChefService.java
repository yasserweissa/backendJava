package Project1_Restaurant_Management.Services.Interfaces;

public interface ChefService {
    void addPizza(String name, double price);
    void editPizza(String name, String newName, double newPrice);
    void viewOrders();
    void updateOrderStatus(String orderId, String status);
//    void updateOrderStatus(String orderId, OrderStatus status);

}
