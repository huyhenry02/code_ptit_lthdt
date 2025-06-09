import java.util.HashMap;

class nhakho{
    private HashMap<String,Integer> gia;
    private HashMap<String,Integer> hang_ton_kho;
    
    public nhakho(){
        this.gia  = new HashMap<>();
        this.hang_ton_kho = new HashMap<>();
    }
    public void addProduct(String product, int price, int stock){
        this.gia.put(product,price);
        this.hang_ton_kho.put(product, stock);
    }
    public int price(String product){
        return this.gia.getOrDefault(product, -99);
    }
    public int stock(String product){
        return this.hang_ton_kho.getOrDefault(product, 0);
    }
    public boolean take(String product){
        if(!this.hang_ton_kho.containsKey(product)){
            return false;
        }
        int currentstock = this.hang_ton_kho.get(product);
        if (currentstock <= 0 ) {
            return false;
        }
        this.hang_ton_kho.put(product,currentstock - 1);
        return true;
    }
}
public class Main{
    public static void main(String[] args) {
        nhakho wh = new nhakho();
        
        wh.addProduct("coffee",5,1);
        System.out.println("stock:");
        System.out.println("coffee:  "+wh.stock("coffee"));
        System.out.println("sugar: "+wh.stock("sugar"));
        System.out.println("taking coffee "+ wh.take("coffee"));
        System.out.println("taking coffee "+ wh.take("coffee"));
        System.out.println("taking sugar "+ wh.take("sugar"));
        System.out.println("stock:");
        System.out.println("coffee:  "+wh.stock("coffee"));
        System.out.println("sugar: "+wh.stock("sugar"));
    }
}