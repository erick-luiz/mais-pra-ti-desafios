import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
           int a = scanner.nextInt();
           int b = scanner.nextInt();
           int c = scanner.nextInt();
           
           if(a == b && b == c){
               System.out.println("*");
           }else if(a == b){
               System.out.println("C");
           }else if(b == c){
                System.out.println("A");               
           } else {
               System.out.println("B"); 
           }
        }
    }
}
