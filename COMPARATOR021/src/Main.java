import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Job {
    private String name;
    private int priority;
    private int time;
    
    public Job(String name, int priority, int time){
        this.name = name;
        this.priority = priority;
        this.time = time;
    }
    
    public int getTime() {
        return time;
    }
    
    public int getPriority() {
        return priority;
    }
    
    public String getName() {
        return name;
    }
    
    public String toString(){
        return name + " " + priority + " " + time;
    }
}

class Search implements Comparator<Job> {
    
    @Override
    public int compare(Job o1, Job o2) {
        if (o1.getPriority() != o2.getPriority()){
            return Integer.compare(o1.getPriority(), o2.getPriority());
        }
        if (o1.getTime() != o2.getTime()){
            return Integer.compare(o1.getTime(), o2.getTime());
        }
        return o1.getName().compareTo(o2.getName());
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = Integer.parseInt(sc.nextLine());
        List<Job> parts = new ArrayList<>();
        for (int i = 0; i < line; i++){
            String job = sc.nextLine();
            String[] jobs = job.split(" ");
            
            parts.add(new Job(jobs[0], Integer.parseInt(jobs[1]), Integer.parseInt(jobs[2])));
        }
        
        parts.sort(new Search());
        
        System.out.println(parts.get(0));
        
        sc.close();
    }
}