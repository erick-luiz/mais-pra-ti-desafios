import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Main {

	private final static long MIN = 1;
	private final static Long MAX = 10_000_000_000L;

	public static void main(String... args) throws IOException {
            
            Scanner scanner = new Scanner(new File("C:\\Users\\erick.lopes\\Documents\\NetBeansProjects\\Desafios\\src\\desafios\\dados.txt"));
            
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            while(a != 0 || b != 0){
                if(saoValoresValidos(a, b))
                    System.out.println((3 * a) - (a + b));
                a = scanner.nextInt();
                b = scanner.nextInt();
            }
    }

    private static boolean saoValoresValidos(long a, long b) {
            return estaNoLimite(a) && estaNoLimite(b) && (a <= b);
    }

    private static boolean estaNoLimite(long x) {
            return x >= MIN && x <= MAX;
    }
}
