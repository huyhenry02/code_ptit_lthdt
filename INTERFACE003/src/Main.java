import java.util.*;

class Main {
    public static void main(String[] args) {
        TacoBox tripleBox = new TripleTacoBox();
        tripleBox.eat();
        tripleBox.eat();
        System.out.println("Triple taco boxes left: " + tripleBox.tacosRemaining());
        
        TacoBox customerBox = new CustomTacoBox(8);
        customerBox.eat();
        System.out.println("Custom taco boxes left: " + customerBox.tacosRemaining());
    }
}

interface TacoBox {
    int tacosRemaining();
    void eat();
}

class TripleTacoBox implements TacoBox {
    private int tacos;
    
    public TripleTacoBox(){
        this.tacos = 3;
    }
    @Override
    public void eat() {
        if (tacos > 0){
            tacos --;
        }
    }
    
    @Override
    public int tacosRemaining() {
        return tacos;
    }
}

class CustomTacoBox implements TacoBox{
    private int tacos;
    
    public CustomTacoBox(int initialTacos) {
        this.tacos = initialTacos;
    }
    
    @Override
    public int tacosRemaining() {
        return tacos;
    }
    
    @Override
    public void eat() {
        if (tacos > 0) {
            tacos--;
        }
    }
}