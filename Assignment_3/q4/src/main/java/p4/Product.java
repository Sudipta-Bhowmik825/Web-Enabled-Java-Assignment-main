package p4;

public class Product {
    private String orderId;
    private String productName;
    private double price;
    private int quantity;

    // Constructor
    public Product(String orderId, String productName, double price, int quantity) {
        this.orderId = orderId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
