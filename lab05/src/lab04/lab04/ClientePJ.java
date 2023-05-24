//Nome: Rafael Andre Alves de Siqueira RA: 243360

//package lab03;

import java.util.Date;
// Classe que representa a entidade ClientePj
public class ClientePJ extends Cliente{
    public ClientePJ(String nome, String cnpj, Date dataFundacao, String endereco, int qtdFuncionarios) {
		super(nome, endereco);
		this.CNPJ = cnpj;
		this.dataFundacao = dataFundacao;
		this.qtdFuncionarios = qtdFuncionarios;
	}
	private final String CNPJ;
    private Date dataFundacao;
	private int qtdFuncionarios;

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
	public int getQtdFuncionarios(){
		return this.qtdFuncionarios;
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
		return CalcSeguro.VALOR_BASE.getFator() * (1+this.qtdFuncionarios)* super.numeroVeiculos(); 
	}
}