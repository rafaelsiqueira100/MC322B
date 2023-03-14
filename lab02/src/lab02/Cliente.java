package lab02;

public class Cliente {
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.endereco = endereco;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String toString() {
		return "";
	}
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
			somatoria += multiplicador * (int) cpf.charAt(i);
			multiplicador--;
		}
		int resto = somatoria % 11;
		if(resto < 2)
			primeiroDigito = 0;
		else
			primeiroDigito = 11 - resto;
		cpf += (char) primeiroDigito;
		multiplicador = 11;
		somatoria = 0;
		for(int i=0;i< cpf.length(); i++) {
			somatoria += multiplicador * (int) cpf.charAt(i);
			multiplicador--;
		}
		resto = somatoria % 11;
		if(resto <2)
			segundoDigito = 0;
		else
			segundoDigito = 11-resto;
		return (char)primeiroDigito +""+ (char)segundoDigito;
			
			
	}

}
