import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {

		var leitorDeTela = new LeitorDeTela();
        int[] valores = leitorDeTela.leSequenciaNumerica();
        if(valores[0] > valores[1]) {
            System.out.println(valores[0]);
        }else{
            System.out.println(valores[1]);
        }
	}
}

// Proteger Leitor
class LeitorDeTela {

	private BufferedReader in;

	public LeitorDeTela() {
		InputStreamReader ir = new InputStreamReader(System.in);
		this.in = new BufferedReader(ir);
	}

	public String leProximaLinha() throws IOException {
		return this.in.readLine();
	}
	
	public int leProximoNumero() throws IOException {
		return Integer.valueOf(this.leProximaLinha());
	}
	
	public int[] leSequenciaNumerica() throws IOException {
	    // Proteger Leitor
	    String entrada = this.leProximaLinha();
        String valores[] = entrada.split(" ");
		int[] resultadoDaLeitura = new int[valores.length];
		
		for(int i = 0; i < valores.length; i++){
		  resultadoDaLeitura[i] = Integer.valueOf(valores[i]);
		}
		
		return resultadoDaLeitura;
	}
}
