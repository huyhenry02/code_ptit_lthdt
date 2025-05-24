import java.util.*;

class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Grocery Bill");
        GroceryBill gb = new GroceryBill(e1);
        gb.add(new Item("item 1", 2.3, 0));
        gb.add(new Item("item 2", 3.45, 0));
        System.out.println(gb);
        
        System.out.println();
        
        Employee e2 = new Employee("Discount Bill");
        DiscountBill db = new DiscountBill(e2);
        db.add(new Item("item 3", 20, 15));
        db.add(new Item("item 4", 40, 35));
        db.add(new Item("item 5", 50, 35));
        System.out.println(db);
    }
}

class Item {
    private String name;
    private double price;
    private double discount;
    
    public Item(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public double getDiscount() {
        return discount;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    public String toString() {
        return String.format("   %s $%.2f (-$%.2f)", name, price, discount);
    }
}

class Employee {
    private String name;
    public Employee(String name){
        this.name = name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}

class GroceryBill {
    protected Employee clerk;
    protected ArrayList<Item> receipt;
    protected double total;
    
    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
        this.receipt = new ArrayList<>();
        this.total = 0.00;
    }
    
    public void add(Item item) {
        receipt.add(item);
        total += item.getPrice();
    }
    
    public double getTotal() {
        return total;
    }
    
    public Employee getClerk() {
        return clerk;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("items:\n");
        for (Item item : receipt) {
            sb.append(item.toString()).append("\n");
        }
        sb.append(String.format("total: $%.2f\n", total));
        sb.append("Clerk: ").append(clerk.getName());
        return sb.toString();
    }
}

class DiscountBill extends GroceryBill {
    private double discountAmount;
    
    public DiscountBill(Employee clerk) {
        super(clerk);
        this.discountAmount = 0.00;
    }
    
    @Override
    public void add(Item item) {
        receipt.add(item);
        total += item.getPrice() - item.getDiscount();
        discountAmount += item.getDiscount();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("items:\n");
        for (Item item : receipt) {
            sb.append(item.toString()).append("\n");
        }
        double subTotal = total + discountAmount;
        sb.append(String.format("sub-total: $%.2f\n", subTotal));
        sb.append(String.format("discount: $%.2f\n", discountAmount));
        sb.append(String.format("total: $%.2f\n", total));
        sb.append("Clerk: ").append(clerk.getName());
        return sb.toString();
    }
}