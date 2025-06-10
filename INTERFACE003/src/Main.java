interface TacoBox{
    int tacoRemaining();
    void eat();
}

class TripleTacoBox implements TacoBox {
    private int tacos;
    
    public TripleTacoBox(){
        this.tacos = 3;
    }
    @Override
    public int tacoRemaining() {
        return tacos;
    }
    
    @Override
    public void eat() {
        if (tacos > 0){
            tacos--;
        }
    }
}

class CustomTacoBox implements TacoBox {
    private int tacos;
    
    public CustomTacoBox(int tacos){
        this.tacos = tacos;
    }
    @Override
    public int tacoRemaining() {
        return tacos;
    }
    
    @Override
    public void eat() {
        if (tacos > 0){
            tacos--;
        }
    }
}

class Main {
    public static void main(String[] args) {
        TripleTacoBox tripleTacoBox = new TripleTacoBox();
        tripleTacoBox.eat();
        tripleTacoBox.eat();
        CustomTacoBox customTacoBox = new CustomTacoBox(8);
        customTacoBox.eat();
        System.out.println("Triple taco boxes left: " + tripleTacoBox.tacoRemaining());
        System.out.println("Custom taco boxes left: " + customTacoBox.tacoRemaining());
    }
}