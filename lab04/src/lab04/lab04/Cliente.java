//Nome: Rafael Andre Alves de Siqueira RA: 243360
//package lab03;

import java.util.List;
import java.util.ListIterator;
import java.util.LinkedList;
//Classe que representa a entidade Cliente

public class Cliente {
	private String nome;
	private String endereco;
	private double valorSeguro;
	private List<Veiculo> listaVeiculos;

	public Cliente(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = new LinkedList<Veiculo>();
	}
	public int numeroVeiculos(){
		return listaVeiculos.size();
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
		return "{Cliente:{Nome:"+this.getNome()
				+ "Endereco:"+this.getEndereco()+ "}}";
	
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
	public double calculaScore(){
		return 0;
	}

	public boolean transferirSeguro(Cliente aReceber){
		if(aReceber == null)
			return false;
		if(aReceber.listaVeiculos == null)
			aReceber.listaVeiculos = new LinkedList<Veiculo>();
		ListIterator<Veiculo> iterador = aReceber.listaVeiculos.listIterator(0);
		while(iterador.hasNext()){
			this.listaVeiculos.add(iterador.next());
		}
		this.listaVeiculos.clear();
		return true;
	}

}
