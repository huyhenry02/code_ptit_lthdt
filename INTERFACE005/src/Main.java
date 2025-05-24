import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Birthable> birthables = new ArrayList<>();
        
        while (true) {
            String line = sc.nextLine();
            if(line.equals("End")) break;
            
            String[] parts = line.split(" ");
            String type = parts[0];
            
            if (type.equals("Citizen")) {
                String name = parts[1];
                String id = parts[2];
                int age = Integer.parseInt(parts[3]);
                String birthDate = parts[4];
                
                birthables.add(new Citizen(name, id, age, birthDate));
            } else if (type.equals("Pet")) {
                String name = parts[1];
                String birthDate = parts[2];
                
                birthables.add(new Pet(name, birthDate));
            }
        }
        
        String year = sc.nextLine().trim();
        
        for (Birthable b : birthables) {
            if (b.getBirthDate().endsWith(year)) {
                System.out.println(b.getBirthDate());
            }
        }
    }
}

interface Identifiable {
    String getId();
}

interface Birthable {
    String getBirthDate();
}

class Citizen implements Identifiable, Birthable {
    
    private String name;
    private String id;
    private int age;
    private String birthDate;
    
    public Citizen (String name, String id, int age, String birthDate) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.birthDate = birthDate;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    @Override
    public String getBirthDate() {
        return birthDate;
    }
    
    @Override
    public String getId() {
        return id;
    }
}

class Pet implements Birthable {
    private String name;
    private String birthDate;
    
    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String getBirthDate() {
        return birthDate;
    }
}