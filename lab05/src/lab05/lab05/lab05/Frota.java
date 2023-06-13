package lab05;
import java.util.ArrayList;
public class Frota{
    private String code;
    private static int ultimoId = -1;
    private ArrayList<Veiculo> listaVeiculos;
    public Frota(){
        this.code = Integer.toString(++ultimoId);
        this.listaVeiculos = new ArrayList<Veiculo>();
    }
    public int qtdVeiculos(){
        return listaVeiculos.size();
    }
    public boolean addVeiculo(Veiculo aAdicionar){
    	return this.listaVeiculos.add(aAdicionar);
    }
    public boolean removeVeiculo(Veiculo aRemover){
    	return this.listaVeiculos.remove(aRemover);
    }
    public String toString() {
		return "{Frota:{Código:"+this.code+",\n"
				+ "SeguroPJ:"+this.seguro+ "\n"
				+"}}";
	}
}