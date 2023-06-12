//package lab05;
public class SeguroPJ extends Seguro{
    private Frota frota;
    private ClientePJ cliente;
    public SeguroPJ(Frota frota, ClientePF cliente){
        this.frota = frota;
        this.cliente = cliente;
    }
    public boolean autorizarCondutor(){

    }
    public boolean desautorizarCondutor(){

    }
    public void gerarSinistro(){

    }
    public double calcularValor(int qtdSinistrosCliente, int qtdSinistrosCondutor){
        double score = cliente.calculaScore();
        score *= (2 + qtdSinistrosCliente/10)*(5+qtdSinistrosCondutor/10);
        return score;
    }
    
    public String toString(){
        return "{SeguroPJ:{Frota:"+(this.frota.toString())+", \n"
                + "ClientePJ: "+this.cliente.toString()+ "\n}}";
    
    }
    public ClientePJ getCliente(){
        return this.cliente;
    }
    public double calcularPrecoSeguroCliente(){
		double score = 0;
        score = cliente.calculaScore();
		return score * (1 + tamanhoListaSinistros());
	}
}