
class Product{
    private String name;
    private String location;
    private int weight;
    
    public Product(String name){
        this.name = name;
        this.location = "shelf";
        this.weight = 1;
    }
    
    public Product(String name, String location){
        this.name = name;
        this.location = location;
        this.weight = 1;
    }
    
    public Product(String name, int weight){
        this.name = name;
        this.weight = weight;
        this.location = "shelf";
    }
    
    public int getWeight() {
        return weight;
    }
    
    public String getName() {
        return name;
    }
    
    public String getLocation() {
        return location;
    }
}

class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Tape measure");
        System.out.println(p1.getName() + " (" + p1.getWeight() + "kg) can be found from the " + p1.getLocation());
        
        Product p2 = new Product("Plaster", "home improvement section");
        System.out.println(p2.getName() + " (" + p2.getWeight() + "kg) can be found from the " + p2.getLocation());
        
        Product p3 = new Product("Tyre", 5);
        System.out.println(p3.getName() + " (" + p3.getWeight() + "kg) can be found from the " + p3.getLocation());
    }
}