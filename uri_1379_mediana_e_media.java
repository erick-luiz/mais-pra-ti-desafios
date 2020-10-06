import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private final static long MIN = 1;
	private final static Long MAX = 10_000_000_000L;

	public static void main(String... args) throws IOException {

		var leitorDeTela = new LeitorDeTela();
		List<Long> resultados = new ArrayList<>();
		
        String[] entrada = leitorDeTela.leProximaLinha().split(" ");
		int a = Integer.parseInt(entrada[0]);
		int b = Integer.parseInt(entrada[1]);
		while(a != 0 && b != 0){
            try{
		        resultados.add(calc(a, b));
            } catch(IllegalArgumentException iae){
                // fazer algo
            }    
            entrada = leitorDeTela.leProximaLinha().split(" ");
	    	a = Integer.parseInt(entrada[0]);
		    b = Integer.parseInt(entrada[1]);
		}

        for(Long resultado: resultados){
		    System.out.println(resultado);
        }
        
    }

	public static long calc(long a, long b) {
		if (!saoValoresValidos(a, b)) {
			throw new IllegalArgumentException("Valores invalidos");
		}

		return (3 * a) - (a + b);
	}

	private static boolean saoValoresValidos(long a, long b) {
		return estaNoLimite(a) && estaNoLimite(b) && (a <= b);
	}

	private static boolean estaNoLimite(long x) {
		return x >= MIN && x <= MAX;
	}
}

class LeitorDeTela {

	private BufferedReader in;

	public LeitorDeTela() {
		InputStreamReader ir = new InputStreamReader(System.in);
		this.in = new BufferedReader(ir);
	}

	public String leProximaLinha() throws IOException {
		return this.in.readLine();
	}
}
