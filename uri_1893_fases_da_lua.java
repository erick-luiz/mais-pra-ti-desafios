import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
    // Tratar e defender entrada
		var leitorDeTela = new LeitorDeTela();
		String entrada = leitorDeTela.leProximaLinha();
        String valores[] = entrada.split(" ");

        var percentualDosDiasAnteriores = Integer.valueOf(valores[0]);
        var percentualDaNoiteAnterior = Integer.valueOf(valores[1]);
        
        // Strategy e encapsular comportamento
        
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
