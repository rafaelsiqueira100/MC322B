package lab03;

import java.util.List;
import java.util.ListIterator;
import java.util.Date;
import java.util.LinkedList;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private LinkedList<Cliente> listaClientes;
	private LinkedList<Sinistro> listaSinistros;
	
	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaClientes = new LinkedList<Cliente>();
		this.listaSinistros = new LinkedList<Sinistro>();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public boolean cadastrarCliente(Cliente cliente){
		return listaClientes.add(cliente);
	}
	public boolean removerCliente(String cliente){
		return listaClientes.remove(cliente);		
	}
	public void listarClientes(String tipoCliente) {
		ListIterator<Cliente> iterador = listaClientes.listIterator(0);
		while(iterador.hasNext()){
			Cliente atual = iterador.next();
			if(tipoCliente == "PF" && atual instanceof ClientePF){
				System.out.println(atual.toString());
			}
			if(tipoCliente == "PJ" && atual instanceof ClientePJ){
				System.out.println(atual.toString());
			}
		}
	}
	public boolean gerarSinistro(Date data, String endereco, Veiculo veiculo, Cliente cliente) {
		//data, endereco, seguradora, veiculo, cliente
		Sinistro sinistro = new Sinistro(data.toString(), endereco, (Seguradora)this, veiculo , cliente);
		return listaSinistros.add(sinistro);
	}
	public boolean visualizarSinistro(String cliente) {
		if(cliente == null || cliente.equals(""))
			return false;
		ListIterator<Sinistro> iterador = listaSinistros.listIterator(0);
		boolean printou = false;
		while(iterador.hasNext()){
			Sinistro atual = iterador.next();
			if(atual.getCliente().getNome().equals(cliente)){
				System.out.println(atual.toString());
				printou = true;
			}
		}
		return printou;
	}
	public void listarSinistros() {
		ListIterator<Sinistro> iterador = listaSinistros.listIterator(0);
		while(iterador.hasNext()){
			System.out.println(iterador.next().toString());
		}
	}
	public String toString(){
		return "{Seguradora:{Nome:"+this.getNome()+", \n"
				+ "Telefone: "+this.getTelefone()+",\n"
				+ "Email: "+this.getEmail()+",\n"
				+ "Endereco:"+this.getEndereco()+"\n"
				+ "}}";
	}
}
