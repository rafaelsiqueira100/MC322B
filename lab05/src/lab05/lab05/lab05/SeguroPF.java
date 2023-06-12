//package lab05;

import java.util.Date;

public class SeguroPF extends Seguro{
    private Veiculo veiculo;
    private ClientePF cliente;
    public SeguroPF(Date dataInicio, Date dataFim, Seguradora seguradora,
    	    double valorMensal, Veiculo veiculo, ClientePF cliente){
    	
        this.veiculo = veiculo;
        this.cliente = cliente;
        inicializarSeguro(dataInicio, dataFim, seguradora, calcularValor());
    }
    public boolean autorizarCondutor(){
    	return false;
    }
    public boolean desautorizarCondutor(){
    	return false;
    }
    public void gerarSinistro(){

    }
    public int calcularValor(){

    }
    public String toString(){
        return "{SeguroPF:{Veiculo:"+(this.veiculo.toString())+", \n"
                + "ClientePF: "+this.cliente.toString()+ "\n}}";
    
    }
    public ClientePF getCliente(){
        return this.cliente;
    }
    // gera um sinistro para um determinado veiculo e cliente para esta seguradora
	public boolean gerarSinistro(Date data, String endereco, Veiculo veiculo, Cliente cliente) {
		//data, endereco, seguradora, veiculo, cliente
		Sinistro sinistro = new Sinistro(data.toString(), endereco, (Seguradora)this, veiculo, cliente);
		System.out.println("Sinistro gerado com id "+ sinistro.getId());
		return listaSinistros.add(sinistro);

	}
    public double calcularValor(int qtdSinistrosCliente, int qtdSinistrosCondutor){
        double valor = cliente.calculaScore();
        valor *= (2+ qtdSinistrosCliente/10) * (5+ qtdSinistrosCondutor/10);
        return valor;

    }
    public double calcularPrecoSeguroCliente(Cliente clienteACalcular){
		double score = 0;
        score = clienteACalcular.calculaScore ();
		return score * (1 + tamanhoListaSinistros());
    }
}