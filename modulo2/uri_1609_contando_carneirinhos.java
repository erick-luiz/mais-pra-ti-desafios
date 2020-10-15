import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int casos = scanner.nextInt();
        for(int i = 0; i < casos; i++){
            
            int numeroDeCarneiros = scanner.nextInt();
            List<Integer> valores = new ArrayList<>();
            for(int x = 0; x < numeroDeCarneiros; x++){
                Integer carneiro = scanner.nextInt();
                if(!valores.contains(carneiro)){
                    valores.add(carneiro);
                }
            }

            System.out.println(valores.size());
        }
    }
}
