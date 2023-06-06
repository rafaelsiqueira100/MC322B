//Nome: Rafael Andre Alves de Siqueira RA:243360
//Classe que representa a entidade Seguradora
//package lab03;
package lab05;
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
// gera um sinistro para um determinado veiculo e cliente para esta seguradora
	public boolean gerarSinistro(Date data, String endereco, Veiculo veiculo, Cliente cliente) {
		//data, endereco, seguradora, veiculo, cliente
		Sinistro sinistro = new Sinistro(data.toString(), endereco, (Seguradora)this, veiculo, cliente);
		System.out.println("Sinistro gerado com id "+ sinistro.getId());
		return listaSinistros.add(sinistro);

	}
	public boolean removerSinistro(int id){
		Sinistro aRemover = listaSinistros.stream().filter(o -> o.getId() == id).findFirst().get();
		return listaSinistros.remove(listaSinistros.indexOf(aRemover)) != null;
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
	public boolean visualizarSinistro(Cliente cliente){
		if(cliente == null)
			return false;
		ListIterator<Sinistro> iterador = listaSinistros.listIterator(0);
		boolean printou = false;
		while(iterador.hasNext()){
			Sinistro atual = iterador.next();
			if(atual.getCliente().equals(cliente)){
				System.out.println(atual.toString());
				printou = true;
			}
		}
		return printou;
	}
	public boolean visualizarSinistro(String codigo, boolean ehPF) {
		if(codigo == null || codigo.equals(""))
			return false;
		ListIterator<Sinistro> iterador = listaSinistros.listIterator(0);
		boolean printou = false;
		while(iterador.hasNext()){
			Sinistro atual = iterador.next();
			Cliente clienteAtual = atual.getCliente();
			if(ehPF && clienteAtual instanceof ClientePF){
				if(((ClientePF)clienteAtual).getCpf().equals(codigo)){
					System.out.println(atual.toString());
					printou = true;
				}
			}
			if(!ehPF && clienteAtual instanceof ClientePJ){
				if(((ClientePJ)clienteAtual).getCNPJ().equals(codigo)){
					System.out.println(atual.toString());
					printou = true;
				}
			}

		}
		return printou;
	}
// percorre e printa a lista de sinistros da seguradora
	public void listarSinistros() {
		ListIterator<Sinistro> iterador = listaSinistros.listIterator(0);
		while(iterador.hasNext()){
			System.out.println(iterador.next().toString());
		}
	}
	public double calcularPrecoSeguroCliente(Cliente clienteACalcular){
		double score = 0;
		if(clienteACalcular instanceof ClientePF)
			score = ((ClientePF)clienteACalcular).calculaScore ();
		if(clienteACalcular instanceof ClientePJ)
			score = ((ClientePJ)clienteACalcular).calculaScore();
		return score * (1 + this.listaSinistros.size());
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