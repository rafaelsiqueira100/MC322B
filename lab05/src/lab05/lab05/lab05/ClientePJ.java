//Nome: Rafael Andre Alves de Siqueira RA: 243360

//package lab05;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
// Classe que representa a entidade ClientePj
public class ClientePJ extends Cliente{
    public ClientePJ(String nome, String cnpj, Date dataFundacao, String endereco, int qtdFuncionarios) {
		this.setNome(nome);
		this.setEndereco(endereco);
		this.CNPJ = cnpj;
		this.dataFundacao = dataFundacao;
		this.qtdFuncionarios = qtdFuncionarios;
		this.seguros  = new ArrayList<SeguroPJ>();
		this.frotas = new ArrayList<Frota>();
	}
	private final String CNPJ;
    private Date dataFundacao;
	private int qtdFuncionarios;
	private ArrayList<SeguroPJ> seguros;
	private ArrayList<Frota> frotas;
//método toString marcado com override pois foi sobrescrito em relação ao método da classe Cliente
	@Override
    public String toString() {
		return "{ClientePJ:{Nome:"+this.getNome()+", \n"
				+ "Data de Fundacao: "+this.getDataFundacao().toString()+",\n"
				+ "CNPJ: "+this.CNPJ+",\n"
				+ "Endereco:"+this.getEndereco()+ ", \n"
				+"Quantidade de Funcionarios:"+this.qtdFuncionarios+"\n"
				+"}}";
	
	}
	public int anosFundacao(){
		Date dataAtual = new Date(System.currentTimeMillis());
		long diffInMillies = Math.abs(dataAtual.getTime() - this.dataFundacao.getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		return (int) Math.floor((double)diff/365.25);
	}
	public int getQtdFuncionarios(){
		return this.qtdFuncionarios;
	}
	public int qtdVeiculos(){
		int numeroVeiculos = 0;
		ListIterator<Frota> iteradorFrotas = frotas.listIterator(0);
		while(iteradorFrotas.hasNext()){
			Frota atual = iteradorFrotas.next();
			numeroVeiculos += atual.qtdVeiculos();
		}
		return numeroVeiculos;
	}
	public void setQtdFuncionarios(int novaQtd){
		this.qtdFuncionarios = novaQtd;
	}
	public String getCNPJ(){
		return this.CNPJ;
	}
	public Date getDataFundacao() {
		return dataFundacao;
	}
	
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public double calculaScore(){
		return CalcSeguro.VALOR_BASE.getFator() * (10+(this.qtdFuncionarios/10))* 
		(1+1/(this.qtdVeiculos()+2))* (1+1/(anosFundacao()+2)); 
	}
	public boolean cadastrarFrota(Frota nova){
		return frotas.add(nova);
	}
	public boolean atualizarFrota(){
		
	}
	public boolean getVeiculosPorFrota(){

	}
}