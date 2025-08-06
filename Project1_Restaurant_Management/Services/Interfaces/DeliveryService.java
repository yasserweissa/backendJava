package Project1_Restaurant_Management.Services.Interfaces;

public interface DeliveryService {
    void viewOrders();
    void updateOrderStatus(String orderId, String status);
//    void updateOrderStatus(String orderId, OrderStatus status);
}
