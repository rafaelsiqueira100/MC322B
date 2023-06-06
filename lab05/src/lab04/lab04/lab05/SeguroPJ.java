package lab05;
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
    public void calcularValor(){

    }
    public String toString(){
        return "{SeguroPJ:{Frota:"+(this.frota.toString())+", \n"
                + "ClientePJ: "+this.cliente.toString()+ "}}";
    
    }
}