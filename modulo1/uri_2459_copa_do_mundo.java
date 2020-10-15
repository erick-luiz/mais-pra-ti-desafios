
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    	Scanner scanner = new Scanner(System.in);
        
        int nCidades = scanner.nextInt();
        int numeroDeFerrovias = scanner.nextInt();
        int numeroDeRodovias = scanner.nextInt();

        List<Cidade> cidades =  new ArrayList<>();
        for(int i = 0; i < nCidades; i++){
            cidades.add(new Cidade(i+1));
        }
        
        List<Via> ferrovias = new ArrayList<>();
        for(int i = 0; i < numeroDeFerrovias; i++){
            Cidade c1 = cidades.get(scanner.nextInt()-1);
            Cidade c2 = cidades.get(scanner.nextInt()-1);
            int custo = scanner.nextInt();
            ferrovias.add(new Ferrovia(c1,c2,custo));
            interliga(c2,c1);
        }
        
    	List<Via> rodovias = new ArrayList<>();
    	for(int i = 0; i < numeroDeRodovias; i++){
            Cidade c1 = cidades.get(scanner.nextInt()-1);
            Cidade c2 = cidades.get(scanner.nextInt()-1);
            int custo = scanner.nextInt();
            rodovias.add(new Ferrovia(c1,c2,custo));
            interliga(c2,c1);
        }

    	List<Via> viasSelecionadas = new ArrayList<>();
        // pegar o que tem o menor numero de destinos
        cidades.sort((a, b) -> a.numeroDeDestinos() - b.numeroDeDestinos());

        Set<Cidade> caminho = new HashSet<>(); 
        
        caminho.add(cidades.get(0));
    	cidades.remove(0);
    	
        while(!cidades.isEmpty()){

        	Via selecionada = pegaAMenorVia(caminho, rodovias, ferrovias);
            if(selecionada != null){
        	    viasSelecionadas.add(selecionada);
        	    caminho.add(selecionada.getCidadeA()); 
        	    caminho.add(selecionada.getCidadeB()); 
        	    cidades.remove(selecionada.getCidadeA());
        	    cidades.remove(selecionada.getCidadeB());
        	    limpaCaminhos(caminho, selecionada.getCidadeA(), rodovias, ferrovias);
        	    limpaCaminhos(caminho, selecionada.getCidadeB(), rodovias, ferrovias);
            }
        }
        
        System.out.println(viasSelecionadas.stream().mapToLong(Via::getCusto).sum());
    }
    
    // Remove as arestas que eu não quero mais para calculo
    private static void limpaCaminhos(Set<Cidade> caminho, Cidade cidade, List<Via> rodovias, List<Via> ferrovias){
        Set<Via> rodoviasParaRemover = new HashSet<>();
        Set<Via> ferroviasParaRemover = new HashSet<>();

        for(Cidade cidadeNoCaminho: caminho){
                for(Via rodovia: rodovias){
                    if(rodovia.vaiPara(cidadeNoCaminho, cidade)){
                        rodoviasParaRemover.add(rodovia);
                    }        
                }
                
                for(Via ferrovia: ferrovias){
                    if(ferrovia.vaiPara(cidadeNoCaminho, cidade)){
                        ferroviasParaRemover.add(ferrovia);
                    } 
                }
        }
        
        rodovias.removeAll(rodoviasParaRemover);
        ferrovias.removeAll(ferroviasParaRemover);
    }
    
    private static void interliga(Cidade a, Cidade b) {
    	a.adicionaDestino(b);
    	b.adicionaDestino(a);
    } 
    
    private static Via pegaAMenorVia(Set<Cidade> cidades, List<Via> rodovias, List<Via> ferrovias){
        
    	List<Via> l = ferrovias.stream().filter(r -> r.vaiPara(cidades)).collect(Collectors.toList());
    	if(!l.isEmpty()) {
    		l.sort((a, b) -> (int) (a.getCusto() - b.getCusto()));
    		ferrovias.remove(l.get(0));
    		return l.get(0);
    	}

    	l = rodovias.stream().filter(r -> r.vaiPara(cidades)).collect(Collectors.toList());
    	if(!l.isEmpty()) {
    		l.sort((a, b) -> (int) (a.getCusto() - b.getCusto()));
    		rodovias.remove(l.get(0));
            return l.get(0);
    	}
    	
    	return null;
    }
    
    
}

class Cidade {

    private final int id; 
    List<Cidade> destinos = new ArrayList<>();

    Cidade(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void adicionaDestino(Cidade destino) {
    	this.destinos.add(destino);
    }
    
    public int numeroDeDestinos() {
    	return this.destinos.size();
    }
}

abstract class Via {
    
    private final long custo;
    private final Cidade cidadeA; 
    private final Cidade cidadeB;
    
    Via(Cidade cidadeA, Cidade cidadeB, long custo){
        this.cidadeA = cidadeA;
        this.cidadeB = cidadeB;
        this.custo = custo;
    }
    
    public boolean vaiPara(Set<Cidade> cidades){
        return cidades.contains(cidadeA) || cidades.contains(cidadeB);
    }
    
    public boolean vaiPara(Cidade c1, Cidade c2){
        return (this.cidadeA.getId() == c1.getId() && this.cidadeB.getId() == c2.getId()) || (this.cidadeA.getId() == c2.getId() && this.cidadeB.getId() == c1.getId());
    }
    
    public long getCusto() {
    	return this.custo;
    }
    
    public Cidade getCidadeA() {
    	return this.cidadeA;
    }
    
    public Cidade getCidadeB() {
    	return this.cidadeB;
    }

}

class Rodovia extends Via{
    Rodovia(Cidade cidadeA, Cidade cidadeB, long custo){
        super(cidadeA, cidadeB, custo);
    }
}

class Ferrovia extends Via{
	Ferrovia(Cidade cidadeA, Cidade cidadeB, long custo){
        super(cidadeA, cidadeB, custo);
    }
}
