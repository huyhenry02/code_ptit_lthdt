import java.lang.reflect.Array;
import java.util.ArrayList;

class Item {
    private String name;
    private int weight;
    
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    
    public Item(String name) {
        this.name = name;
        this.weight = 0;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }
}

abstract class Box {
    public abstract void add(Item item);
    public abstract boolean isInBox(Item item);
}

class BoxWithMaxWeight extends Box {
    
    private ArrayList<Item> items;
    private final int maxHeight;
    
    public BoxWithMaxWeight(int maxHeight) {
        this.maxHeight = maxHeight;
        this.items = new ArrayList<>();
    }
    
    @Override
    public void add(Item item){
        int currentHeight = 0;
        
        for (Item i: items){
            currentHeight += i.getWeight();
        }
        
        if (currentHeight + item.getWeight() <= maxHeight){
            items.add(item);
        }
    }
    
    @Override
    public boolean isInBox(Item item) {
        for (Item i: items){
            if (i.getName().equals(item.getName())){
                return true;
            }
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        Box box = new BoxWithMaxWeight(10);
        
        Item item1 = new Item("Saludo", 5);
        Item item2 = new Item("Pirkka", 5);
        Item item3 = new Item("Kopi Luwak", 5);
        
        box.add(item1);
        box.add(item2);
        box.add(item3);
        
        System.out.println(box.isInBox(item1));
        System.out.println(box.isInBox(item2));
        System.out.println(box.isInBox(item3));
    }
}