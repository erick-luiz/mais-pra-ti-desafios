import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws IOException {

		var leitorDeTela = new LeitorDeTela();
        List<Integer> tempos = new ArrayList<>();
        
        var numeroDePessoas = 0;
        while((numeroDePessoas = leitorDeTela.leProximoNumero()) != 0) {
            int[] valores = leitorDeTela.leSequenciaNumerica();
            int resultado = 10;
            for(int i = 1; i < valores.length; i++){
                var diferenca = valores[i] - valores[i-1];
                if(diferenca > 10){
                    resultado += 10; 
                }else{
                    resultado += diferenca;
                }
            }
            tempos.add(resultado);
            // impedir infinito
        }
        
        
        for(Integer tempo: tempos){
            System.out.println(tempo);
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
