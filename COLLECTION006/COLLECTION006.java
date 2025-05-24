import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++){
            String line = scanner.nextLine();
            String[] tokens = line.split("");
            Map<Integer, Integer> valueCount = new HashMap<>();
            
            for (int i = 1; i < tokens.length; i+=2) {
                int value = Integer.parseInt(tokens[i]);
                valueCount.put(value, valueCount.getOrDefault(value, 0) + 1);
            }
            int minFrequency = Integer.MAX_VALUE;
            int result = Integer.MAX_VALUE;
            
            for (Map.Entry<Integer, Integer> entry : valueCount.entrySet()) {
                int val = entry.getKey();
                int freq = entry.getValue();
                if (freq < minFrequency || (freq == minFrequency && val < result)) {
                    minFrequency = freq;
                    result = val;
                }
            }
            
            System.out.println(result);
        }
        scanner.close();
    }
}
