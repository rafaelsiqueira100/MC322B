//Nome: Rafael Andre Alves de Siqueira RA:243360
//Classe que representa a entidade Seguradora
//package lab03;
package lab05;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private LinkedList<Cliente> listaClientes;
	private LinkedList<Seguro> listaSeguros;
	
	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaClientes = new LinkedList<Cliente>();
		this.listaSeguros = new LinkedList<Seguro>();
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
//Adiciona um cliente na lista de clientes da seguradora
	public boolean cadastrarCliente(Cliente cliente){
		return listaClientes.add(cliente);
	}
// Remove um cliente na lista de clientes da seguradora
	public boolean removerCliente(String cliente){
	    ListIterator<Cliente> iterador = listaClientes.listIterator(0);
	    int i=0;
	    while(iterador.hasNext()){
	        Cliente atual = iterador.next();
	        if(atual.getNome().equals(cliente)){
	            
	            listaClientes.remove(i);
	            return true;
	        }
	        i++;
	    }
		return false;		
	}
	public boolean removerCliente(Cliente cliente){
	    return listaClientes.remove(listaClientes.indexOf(cliente)) != null;
	}
// Percorre e printa a lista de clientes da seguradora
	public void listarClientes(String tipoCliente) {
		ListIterator<Cliente> iterador = listaClientes.listIterator(0);
		System.out.println("Clientes do tipo"+tipoCliente+":{");
		while(iterador.hasNext()){
			Cliente atual = iterador.next();
			if(tipoCliente.equals("PF") && atual instanceof ClientePF){
				System.out.println(atual.toString());
			}
			if(tipoCliente.equals("PJ") && atual instanceof ClientePJ){
				System.out.println(atual.toString());
			}
		}
		System.out.println("}");
	}
	public void listarVeiculos(){
		ListIterator<Cliente> iteradorCliente = listaClientes.listIterator(0);
		while(iteradorCliente.hasNext()){
			Cliente atual = iteradorCliente.next();
			atual.listarVeiculos();
		}
	}

	public ArrayList < Seguro > getSegurosPorCliente ( Cliente cliente ) {
		ArrayList < Seguro > segurosCliente = new ArrayList < >() ;
		for ( Seguro seguro : listaSeguros ) {
			if ( seguro . getCliente () . equals ( cliente )) {
				segurosCliente . add ( seguro );
			}
		}
		return segurosCliente ;
	}
	
	
	public double calcularReceita(){
		double receitaAtual = 0;
		ListIterator<Cliente> iterador = listaClientes.listIterator(0);
		System.out.println("{Receita da seguradora "+this.getNome()+":{");
		while(iterador.hasNext()){
			Cliente atual = iterador.next();
			double precoSeguroCliente = calcularPrecoSeguroCliente(atual);
			System.out.println(atual.getNome() +": R$ "+ precoSeguroCliente);
			receitaAtual += precoSeguroCliente;
		}
		System.out.println("}");
		System.out.println("Total: R$ "+receitaAtual+"}");
		return receitaAtual;
	}
	public String toString(){
		return "{Seguradora:{Nome:"+this.getNome()+", \n"
				+ "Telefone: "+this.getTelefone()+",\n"
				+ "Email: "+this.getEmail()+",\n"
				+ "Endereco:"+this.getEndereco()+"\n"
				+ "}}";
	}
}