package lab03;

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


    public boolean validarCPF(String cpf) {
		cpf.replaceAll("", cpf);
		if(cpf.length() != 11)
			return false;
		boolean todosIguais = true;
		for(int i=1;i< cpf.length(); i++) {
			if(cpf.charAt(i-1) != cpf.charAt(i))
				todosIguais = false;
		}
		if(todosIguais)
			return false;
		String digitosVerif = descobrirDigitosVerificadores(cpf.substring(0, cpf.length()-2));
		if (digitosVerif.equals(cpf.substring(9,11)))
			return true;
		return false;
		
	}
	private String descobrirDigitosVerificadores(String cpf) {
		int primeiroDigito, segundoDigito;
		int multiplicador = 10;
		int somatoria = 0;
		for(int i=0;i< cpf.length(); i++) {
			somatoria += multiplicador * Integer.parseInt(""+cpf.charAt(i));
			multiplicador--;
		}
		int resto = somatoria % 11;
		primeiroDigito = 11 - resto;
		if(primeiroDigito > 9)
			primeiroDigito = 0;
		//cpf += (char) primeiroDigito;
		String cpf2 = cpf + (char)(primeiroDigito + '0');
		multiplicador = 11;
		somatoria = 0;
		for(int i=0;i< cpf2.length(); i++) {
			somatoria += multiplicador * Integer.parseInt(""+cpf2.charAt(i));
			multiplicador--;
		}
		resto = somatoria % 11;
		segundoDigito = 11 - resto;
		if(segundoDigito > 9)
			segundoDigito = 0;
		return (char)(primeiroDigito+'0') +"" +(char)(segundoDigito+'0');		
	}
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