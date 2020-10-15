import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
 
        Scanner scanner = new Scanner(System.in);
        int percentualDosDiasAnteriores = scanner.nextInt();
        int percentualDaNoiteAnterior = scanner.nextInt();

        if(percentualDaNoiteAnterior >= 97){
            System.out.println("cheia");
            return;
        }
        
        if(percentualDaNoiteAnterior >= 0 && percentualDaNoiteAnterior <= 2){
            System.out.println("nova");
            return;
        }
        
        if(percentualDaNoiteAnterior >= 3 && percentualDaNoiteAnterior <= 96 && percentualDosDiasAnteriores > percentualDaNoiteAnterior){
            System.out.println("minguante");
            return;
        }
        
        System.out.println("crescente");
    }
 
}
