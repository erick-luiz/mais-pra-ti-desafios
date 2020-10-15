import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String... args) {
    
        Scanner scanner = new Scanner(System.in);
        int nEntradas = scanner.nextInt();
        
        int[] valores = new int[nEntradas];
        for(int i = 0; i < nEntradas; i++){
            valores[i] = scanner.nextInt();
        }
        
        Arrays.sort(valores);
        for(int i = 0, count = 1; i < valores.length; i++){
            if(i == valores.length - 1 || valores[i] != valores[i + 1]){
                System.out.println(valores[i] + " aparece "+ count+ " vez(es)");
                count = 1;
                continue;
            }
            count++;
        }
    }
}
