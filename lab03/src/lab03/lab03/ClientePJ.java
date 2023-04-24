package lab03;

import java.util.Date;

public class ClientePJ extends Cliente{
    public ClientePJ(String nome, String cnpj, Date dataFundacao, String endereco) {
		super(nome, endereco);
		this.CNPJ = cnpj;
		this.dataFundacao = dataFundacao;
	}
	private final String CNPJ;
    private Date dataFundacao;
    public boolean validarCNPJ(String cnpj){
		cnpj.replaceAll("", cnpj);
		if(cnpj.length() != 14)
			return false;
		String digitosVerifOriginais = cnpj.substring(12,14);
		String cnpjCalculo = cnpj.substring(0,12);
		int[] digitosVerif = new int[2];
		int[] pesos = {6,5,4,3,2,9,8,7,6,5,4,3,2};
		int somatoriaPrimeiroDigito = 0;
		for(int i=0; i < cnpjCalculo.length(); i++)
			somatoriaPrimeiroDigito += pesos[i+1]*Integer.parseInt(cnpjCalculo.charAt(i)+"");
	
		int resto = somatoriaPrimeiroDigito % 11;
		int quociente = somatoriaPrimeiroDigito / 11;
		if(resto<2)
			digitosVerif[0] = 0;
		else
			digitosVerif[0] = 11 - resto;
		cnpjCalculo += (char)(digitosVerif[0]+'0');
		int somatoriaSegundoDigito = 0;
		for(int i=0; i < cnpjCalculo.length(); i++){
			somatoriaSegundoDigito += pesos[i]*Integer.parseInt(cnpjCalculo.charAt(i)+"");
		}
		resto = somatoriaSegundoDigito % 11;
		quociente = somatoriaSegundoDigito / 11;
		digitosVerif[1] = 11 - resto;
		if(resto<2)
			digitosVerif[1] = 0;
		else
			digitosVerif[0] = 11 - resto;
		for(int i=0; i<2; i++){
			if(Integer.parseInt(digitosVerifOriginais.charAt(i)+"") != digitosVerif[i])
				return false;
		}
		return true;
    }
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