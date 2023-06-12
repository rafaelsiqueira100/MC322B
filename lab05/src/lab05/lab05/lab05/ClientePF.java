//Nome: Rafael Andre Alves de Siqueira RA: 243360
// Classe que representa a entidade ClientePF
//package lab04;
//package lab05;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

//import lab05.Veiculo;

public class ClientePF extends Cliente{
    public ClientePF(String nome, String cpf, Date dataNascimento, String endereco, String genero, Date dataLicenca, String educacao, String classeEconomica) {
    	this.setNome(nome);
		this.setEndereco(endereco);
    	this.CPF = cpf;
    	this.genero = genero;
    	this.dataLicenca = dataLicenca;
    	this.educacao = educacao;
    	this.dataNascimento = dataNascimento;
    	this.classeEconomica = classeEconomica;
		this.listaSeguros = new ArrayList<SeguroPF>();
		iniciarListaVeiculo();
	}

	private final String CPF;
    private String genero;
    private Date dataLicenca;
    private String educacao;
    private Date dataNascimento;
    private String classeEconomica;
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
	public boolean removerVeiculo(Veiculo veiculo){
		return listaVeiculos.remove(listaVeiculos.indexOf(veiculo)) != null;
	}
	public void listarVeiculos() {
		ListIterator<Veiculo> iterador = listaVeiculos.listIterator(0);
		while(iterador.hasNext()){
			System.out.println(iterador.next().toString());
		}
	}
//método toString marcado com override pois foi sobrescito em relação ao método da classe Cliente
	@Override
	public String toString() {
		return "{ClientePF:{Nome:"+this.getNome()+", \n CPF: "+this.getCpf()+",\n"
				+ "Data de Nascimento: "+this.getDataNascimento().toString()+",\n"
				+ "Genero: "+this.getGenero()+",\n"
				+ "Data da Licença: "+this.getDataLicenca().toString()+",\n"
				+ "Educacao: "+this.getEducacao()+",\n"
				+ "Classe Econômica: "+this.getClasseEconomica()+",\n"
				+ "Endereco:"+this.getEndereco()+ "}}";
	}

	public String getCpf(){
		return this.CPF;
	}
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Date getDataLicenca() {
		return dataLicenca;
	}
	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
	}
	public String getEducacao() {
		return educacao;
	}
	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}
	public String getClasseEconomica() {
		return classeEconomica;
	}
	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	private int getIdade(){
		Date dataAtual = new Date(System.currentTimeMillis());
		long diffInMillies = Math.abs(dataAtual.getTime() - this.dataNascimento.getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		return (int) Math.floor((double)diff/365.25);
	}
	public double calculaScore(){
		CalcSeguro fator_idade ;
		int idade = getIdade();
		if (idade < 30)
			fator_idade = CalcSeguro.FATOR_18_30;
		else if (idade < 60)
			fator_idade = CalcSeguro.FATOR_30_60;
		else
			fator_idade = CalcSeguro.FATOR_60_90;
		return CalcSeguro.VALOR_BASE.getFator() * fator_idade.getFator() * 1/(super.numeroVeiculos()+2); 
	}
}