package lab05;
import java.util.ArrayList;
public class Frota{
    private String code;
    private ArrayList<Veiculo> listaVeiculos;
    public Frota(String code){
        this.code = code;
        this.listaVeiculos = new ArrayList<Veiculo>();
    }
    public boolean addVeiculo(Veiculo aAdicionar){
    	return this.listaVeiculos.add(aAdicionar);
    }
    public boolean removeVeiculo(Veiculo aRemover){
    	return this.listaVeiculos.remove(aRemover);
    }
}