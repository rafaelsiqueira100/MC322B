package lab03;

public class ClientePF extends Cliente{
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
    public String toString(){
        
    }
}