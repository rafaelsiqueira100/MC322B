package lab05;
import java.util.ArrayList;
public class Frota{
    private String code;
    private ArrayList<Veiculo> listaVeiculos;
    private SeguroPJ seguro;
    public Frota(String code, SeguroPJ seguro){
        this.code = code;
        this.seguro = seguro;
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