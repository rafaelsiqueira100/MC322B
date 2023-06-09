//Nome: Rafael Andre Alves de Siqueira RA: 243360
//package lab03;
//package lab05;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.LinkedList;
//Classe que representa a entidade Cliente

public abstract class Cliente {
	private String nome;
	private String endereco;
	private double valorSeguro;
	private ArrayList<Veiculo> listaVeiculos;
	public void iniciarListaVeiculo(){
		this.listaVeiculos = new ArrayList<Veiculo>();
	}
	public int numeroVeiculos(){
		return this.listaVeiculos.size();
	}
// adiciona um veículo na lista de veículos
	public boolean cadastrarVeiculo(Veiculo aCadastrar){
		return listaVeiculos.add(aCadastrar);
	}
	public void setValorSeguro(double novo){
		this.valorSeguro = novo;
	}
	public boolean removerVeiculo(Veiculo veiculo){
		return listaVeiculos.remove(listaVeiculos.indexOf(veiculo)) != null;
	}
	public void listarVeiculos() {
		ListIterator<Veiculo> iterador = listaVeiculos.listIterator(0);
		while(iterador.hasNext()){
			System.out.println(iterador.next().toString());
		}
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String toString() {
		return "{Cliente:{Nome:"+this.getNome()+",\n"
				+ "Endereco:"+this.getEndereco()+ ",\n"
				+ "Valor do Seguro:"+this.valorSeguro + ",\n"
				+"}}";
	
	}
	public boolean equals(Object object){
		if (object == null)
			return false;
		if(this == object)
			return true;
		if(getClass() != object.getClass())
			return false;
		final Cliente other = (Cliente) object;
		if(this.nome.equals(other.nome))
			return true;
		return false;
	}

	public boolean transferirSeguro(Cliente aReceber){
		if(aReceber == null)
			return false;
		if(aReceber.listaVeiculos == null)
			aReceber.listaVeiculos = new ArrayList<Veiculo>();
		ListIterator<Veiculo> iterador = aReceber.listaVeiculos.listIterator(0);
		while(iterador.hasNext()){
			this.listaVeiculos.add(iterador.next());
		}
		this.listaVeiculos.clear();
		return true;
	}
	public abstract double calculaScore();

}
