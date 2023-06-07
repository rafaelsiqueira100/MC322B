//Nome: Rafael Andre Alves de Siqueira RA: 243360
//Classe que representa a entidade Sinistro
//package lab03;
package lab05;
public class Sinistro {
	private int id;
	private String data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;
	private static int ultimoId = -1;

	public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
		this.data = data;
		this.endereco = endereco;
		this.id = ++Sinistro.ultimoId;
		this.seguradora = seguradora;
		this.veiculo = veiculo;
		this.cliente = cliente;
	}
	public int getId() {
		return this.id;
	}
	public String getData() {
		return this.data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getEndereco() {
		return this.endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Cliente getCliente(){
		return this.cliente;
	}
	public void setCliente(Cliente cliente){
		if(cliente != null)
			this.cliente = cliente;
	}
	public Veiculo getVeiculo(){
		return this.getVeiculo();
	}
	public void setVeiculo(Veiculo veiculo){
		if(veiculo != null)
			this.veiculo = veiculo;
	}
	public Seguradora getSeguradora(){
		return this.getSeguradora();
	}
	public void setSeguradora(Seguradora seguradora){
		if(seguradora != null)
			this.seguradora = seguradora;
	}
	public String toString() {
		return "{Sinistro:{Id:"+Integer.toString(this.getId())+", \n"
				+ "Data: "+this.getData()+",\n"
				+ "Endereco: "+this.getEndereco()+",\n"
				+ "Seguradora: "+this.seguradora.toString()+",\n"
				+ "Veiculo: " +this.veiculo.toString()+",\n"
				+ "Cliente: "+this.cliente.toString()
				+ "}}";
	}
}
