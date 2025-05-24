import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        
        while (true) {
            String line = sc.nextLine();
            if (line.equals("Tournament")) break;
            
            String[] parts = line.split(" ");
            String trainerName = parts[0];
            String pokemonName = parts[1];
            String element = parts[2];
            int health = Integer.parseInt(parts[3]);
            
            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            trainers.get(trainerName).addPokemon(new Pokemon(pokemonName, element, health));
        }
        
        while (true) {
            String line = sc.nextLine();
            if (line.equals("End")) break;
            
            for (Trainer t : trainers.values()) {
                t.applyElementRule(line);
            }
        }
        
        trainers.values().stream()
                .sorted((a, b) -> Integer.compare(b.getNumberOfBadges(), a.getNumberOfBadges()))
                .forEach(t -> System.out.printf("%s %d %d%n", t.getName(), t.getNumberOfBadges(), t.getPokemons().size()));
    }
}

class Pokemon {
    private String name;
    private String element;
    private int health;
    
    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }
    
    public String getName() {
        return name;
    }
    
    public String getElement() {
        return element;
    }
    
    public int getHealth() {
        return health;
    }
    
    public void setElement(String element) {
        this.element = element;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public void decreaseHealth(int amount) {
        this.health -= amount;
    }
    
    public boolean isDead() {
        return this.health <= 0;
    }
}

class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;
    
    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemons = new ArrayList<>();
    }
    
    public int getNumberOfBadges() {
        return numberOfBadges;
    }
    
    public List<Pokemon> getPokemons() {
        return pokemons;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }
    
    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }
    
    public void increaseNumberOfBadges() {
        this.numberOfBadges++;
    }
    
    public void applyElementRule(String element) {
        boolean hasMatchingElement = pokemons.stream()
                .anyMatch(p -> p.getElement().equals(element));
        if (hasMatchingElement) {
            increaseNumberOfBadges();
        } else {
            pokemons.forEach(p -> p.decreaseHealth(10));
            pokemons.removeIf(Pokemon::isDead);
        }
    }
}

