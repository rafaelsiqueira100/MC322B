package lab05;
import java.util.Date;
import java.util.ArrayList;

public class Seguro{
    private final int Id;
    private Date dataInicio;
    private Date dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores;
    private int valorMensal;
    private static int ultimoId = -1;
    public Seguro(Date dataInicio, Date dataFim, Seguradora seguradora,
    int valorMensal){
        this.Id = ++ultimoId;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaCondutores = new ArrayList<Condutor>();
        //this.valorMensal = calcularValor
    }
    public void desautorizarCondutor() {
    	
    }
    public void autorizarCondutor() {
    	
    }
    public int calcularValor(Condutor contratanteSeguro){
    	return 0;
    }
    public Sinistro gerarSinistro() {
    	return null;
    }
    public String toString() {
    	
    }
}