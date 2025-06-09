import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Product {
    private String name;
    private int price;
    private int stock;
    public Product(String name, int price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public int getPrice() {
        return price;
    }
    
    public int getStock() {
        return stock;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public String toString(){
        return name + " " + price + " " + stock;
    }
}

class ByName implements Comparator<Product> {
    public int compare(Product a, Product b){
        return a.getName().compareTo(b.getName());
    }
}

class ByPrice implements Comparator<Product>{
    
    @Override
    public int compare(Product a, Product b) {
        if (a.getPrice() != b.getPrice()){
            return a.getPrice() - b.getPrice();
        }
        return a.getName().compareTo(b.getName());
    }
}

class ByStock implements Comparator<Product>{
    
    @Override
    public int compare(Product a, Product b) {
        if (a.getStock() != b.getStock()){
            return a.getStock() - b.getStock();
        }
        return a.getName().compareTo(b.getName());
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine());
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < testCase; i++){
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            int price = Integer.parseInt(parts[1]);
            int stock = Integer.parseInt(parts[2]);
            
            products.add(new Product(parts[0], price, stock));
        }
        
        String sortBy = sc.nextLine();
        switch (sortBy){
            case "BY_NAME": {
                products.sort(new ByName());
                break;
            }
            case "BY_PRICE": {
                products.sort(new ByPrice());
                break;
            }
            case "BY_STOCK": {
                products.sort(new ByStock());
                break;
            }
            default:
                break;
        }
        
        for (Product p: products){
            System.out.println(p);
        }
        sc.close();
    }
}