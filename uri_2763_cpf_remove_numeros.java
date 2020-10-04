import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* Dada a entrada de um cpf no formato XXX.YYY.ZZZ-AA deve ser impresso em tela apenas as sequencias numericas pulando a linha após cada impressão
* XXX \n YYY \n ZZZ \n AA
*/

public class Main{

    public static void main(String []args) throws IOException{
         
        var leitorDeTela = new LeitorDeTela();
        
        String[] cpf =  removeNumerosDoCPF(leitorDeTela.leProximaLinha());
        for(int i = 0; i < cpf.length; i++){
            System.out.println(cpf[i]);
        }
    }
     
    public static String[] removeNumerosDoCPF(String cpf){
        return cpf.split("[.|\\-]");
    }

}

class LeitorDeTela {

    private BufferedReader in;

    public LeitorDeTela(){
        InputStreamReader ir = new InputStreamReader(System.in);
        this.in = new BufferedReader(ir);
    }
    
    public String leProximaLinha() throws IOException {
        return this.in.readLine();
    }
}
