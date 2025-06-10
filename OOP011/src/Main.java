import java.util.Scanner;

class Product {
    private String productId;
    private String name;
    private double price;
    
    public Product(String productId, String name, double price){
        this.name = name;
        this.price = price;
        this.productId = productId;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void display(){
        System.out.println("Sản phẩm: " + name + " (Mã: " + productId + ")" );
    }
}

class Order {
    private String orderId;
    private int quantity;
    private Product product;
    
    public Order(String orderId, int quantity, Product product){
        this.orderId = orderId;
        this.quantity = quantity;
        this.product = product;
    }
    
    public double calculateTotal(){
        return quantity * product.getPrice();
    }
    
    public void display(){
        System.out.println("--- Thông tin đơn hàng ---");
        System.out.println("Đơn hàng: " + orderId);
        product.display();
        System.out.println("Giá: " + String.format("%.1f", product.getPrice()));
        System.out.println("Số lượng: " + quantity);
        System.out.println("Tổng tiền: " + String.format("%.1f", calculateTotal()));
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String productId = sc.nextLine();
        String name = sc.nextLine();
        double price = Double.parseDouble(sc.nextLine());
        String orderId = sc.nextLine();
        int quantity = Integer.parseInt(sc.nextLine());
        
        Product product = new Product(productId, name, price);
        Order order = new Order(orderId, quantity, product);
        
        order.display();
        sc.close();
        
        
    }
}