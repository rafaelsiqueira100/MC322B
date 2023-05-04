//Nome: Rafael Andre Alves de Siqueira RA: 243360
// Classe que representa a entidade ClientePF
//package lab04;

import java.util.Date;

public class ClientePF extends Cliente{
    public ClientePF(String nome, String cpf, Date dataNascimento, String endereco, String genero, Date dataLicenca, String educacao, String classeEconomica) {
    	super(nome, endereco);
    	this.CPF = cpf;
    	this.genero = genero;
    	this.dataLicenca = dataLicenca;
    	this.educacao = educacao;
    	this.dataNascimento = dataNascimento;
    	this.classeEconomica = classeEconomica;
	}
	private final String CPF;
    private String genero;
    private Date dataLicenca;
    private String educacao;
    private Date dataNascimento;
    private String classeEconomica;


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
}