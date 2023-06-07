//package lab05;
import java.util.Date;
import java.util.ListIterator;
import java.util.ArrayList;

public abstract class Seguro{
    private final int Id;
    private Date dataInicio;
    private Date dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores;
    private int valorMensal;
    private static int ultimoId = -1;
    public void inicializarSeguro(Date dataInicio, Date dataFim, Seguradora seguradora,
    int valorMensal){
        this.Id = ++ultimoId;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaCondutores = new ArrayList<Condutor>();
    }
    public int tamanhoListaSinistros(){
        return this.listaSinistros.size();
    }
    public abstract void desautorizarCondutor();
    public abstract void autorizarCondutor() ;
    public int calcularValor(Condutor contratanteSeguro){
    	return 0;
    }
    public Sinistro gerarSinistro() {
    	return null;
    }
    public abstract String toString();
    public abstract Cliente getCliente();
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
}