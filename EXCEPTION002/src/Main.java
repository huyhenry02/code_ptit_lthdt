import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < t; i++) {
            String line = sc.nextLine();
            try {
                int mark = FileChecker.checkFileExtension(line);
                System.out.println(mark);
            } catch (NotJavaFileException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
class NotJavaFileException extends Exception {
    public NotJavaFileException(String message) {
        super(message);
    }
}

class FileChecker {
    public static int checkFileExtension(String fileName) throws NotJavaFileException {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new NotJavaFileException("Not java file exception.Mark is -1");
        }
        
        if (fileName.endsWith(".java")) {
            return 1;
        }
        
        return 0;
    }
}
