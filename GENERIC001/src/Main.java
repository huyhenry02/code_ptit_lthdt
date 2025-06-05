import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        List<String> outputs = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            String line = sc.nextLine();
            String[] parts = line.trim().split("\\s+");
            if (isNumeric(parts[0])){
                Integer a = Integer.parseInt(parts[0]);
                Integer b = Integer.parseInt(parts[1]);
                Pair<Integer> pair = new Pair<>(a,b);
                pair.swap();
                outputs.add(pair.toOutputString());
            }else {
                Pair<String> pair = new Pair<>(parts[0],parts[1]);
                pair.swap();
                outputs.add(pair.toOutputString());
            }
        }

        for (String line: outputs){
            System.out.println(line);
        }

        sc.close();
    }
    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }
}

class Pair<T> {
    private T first;
    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public void swap() {
        T temp = first;
        first = second;
        second = temp;
    }

    public String toOutputString() {
        if (first instanceof String) {
            return "'" + first + "' '" + second + "'";
        } else {
            return first + " " + second;
        }
    }

}