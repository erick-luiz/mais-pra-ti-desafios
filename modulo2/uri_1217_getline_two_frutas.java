import java.util.Scanner;

public class Main {
        public static void main(String... args) {
            
            Scanner scanner = new Scanner(System.in);
            int nDias = scanner.nextInt();
            double valor = 0.0;
            double kilos = 0.0; 
            for(int i = 0; i < nDias; i++){
                valor += scanner.nextDouble();
                scanner.nextLine();
                String frutas = scanner.nextLine();
                int nFrutas = frutas.split(" ").length;
                System.out.printf("day %d: %d kg %n", i+1, nFrutas);
                kilos += nFrutas;
            }
            System.out.printf("%.2f kg by day %n", kilos/nDias);
            System.out.printf("R$ %.2f by day %n", valor/nDias);
    }
}
