package lab05;

import java.util.Date;

public class SeguroPF extends Seguro{
    private Veiculo veiculo;
    private ClientePF cliente;
    public SeguroPF(Date dataInicio, Date dataFim, Seguradora seguradora,
    	    int valorMensal, Veiculo veiculo, ClientePF cliente){
    	super(dataInicio, dataFim, seguradora, valorMensal);
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.valorMensal = calcularValor();
    }
    public boolean autorizarCondutor(){
    	return false;
    }
    public boolean desautorizarCondutor(){
    	return false;
    }
    public void gerarSinistro(){

    }
    public void calcularValor(){

    }
    public String toString(){
        return "{SeguroPF:{Veiculo:"+(this.veiculo.toString())+", \n"
                + "ClientePF: "+this.cliente.toString()+ "}}";
    
    }
}