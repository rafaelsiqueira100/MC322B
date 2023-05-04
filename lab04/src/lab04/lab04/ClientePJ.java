//Nome: Rafael Andre Alves de Siqueira RA: 243360

//package lab03;

import java.util.Date;
// Classe que representa a entidade ClientePj
public class ClientePJ extends Cliente{
    public ClientePJ(String nome, String cnpj, Date dataFundacao, String endereco) {
		super(nome, endereco);
		this.CNPJ = cnpj;
		this.dataFundacao = dataFundacao;
	}
	private final String CNPJ;
    private Date dataFundacao;

//método toString marcado com override pois foi sobrescrito em relação ao método da classe Cliente
	@Override
    public String toString() {
		return "{ClientePJ:{Nome:"+this.getNome()+", \n"
				+ "Data de Fundacao: "+this.getDataFundacao().toString()+",\n"
				+ "CNPJ: "+this.CNPJ+",\n"
				+ "Endereco:"+this.getEndereco()+ "}}";
	
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

}