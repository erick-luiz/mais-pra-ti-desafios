import java.util.Scanner;

public class Main5{

    public static void main(String []args) {
        
        Scanner scanner = new Scanner(System.in);
        String cpf = scanner.next();
        System.out.println(cpf.replaceAll("[.|\\-]","\n"));
    
    }
}
