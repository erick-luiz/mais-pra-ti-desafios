import java.io.IOException;
import java.util.Scanner;

public class Main {
    
    public static void main(String args[]) {
        
        Scanner scanner = new Scanner(System.in);
        
        int numeroDePessoas = scanner.nextInt();
        
        while(numeroDePessoas != 0) {
            
            int resultado = 10;
            int valorAnterior = scanner.nextInt();
            
            for(int i = 1; i < numeroDePessoas; i++){
                int valorAtual = scanner.nextInt();
                if(valorAtual - valorAnterior > 10){
                    resultado += 10;
                }else {
                    resultado += valorAtual - valorAnterior;
                }
                valorAnterior = valorAtual;
            }

            System.out.println(resultado);
            numeroDePessoas = scanner.nextInt();
        }
    }
}
