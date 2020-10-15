import java.io.IOException;
 
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main(String... args) {

        //Scanner scanner = new Scanner(new File("<arquivo>")); 
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            int contador = scanner.nextInt();
            
            if(!ehValido(contador)){
            	pulaLinhas(scanner, contador);
                continue;
            }

            String[] codigos = new String[contador];
            for(int i = 0; i < contador; i++){
                codigos[i] = scanner.next();
            }

            Arrays.sort(codigos);
            for(int i = 0; i < codigos.length; i++){
                System.out.println(codigos[i]);
            }
        }
    }

    private static boolean ehValido(int n){
    	return n >= 1 && n <= 1000;
    }

    private static void pulaLinhas(Scanner scanner, int n){
    	for(int i = 0; i < n; i++){
        	scanner.next();
        }
    }
}
