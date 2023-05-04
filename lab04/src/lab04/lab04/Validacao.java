public class Validacao{

    // algoritmo para validar CPF
    public static boolean validarCPF(String cpf) {
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
//algoritmo para descobrir digitos verificadores de determinado cpf
	private static String descobrirDigitosVerificadores(String cpf) {
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
//algoritmo de validar CNPJ
    public static boolean validarCNPJ(String cnpj){
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

    public static boolean validaNome(String nome){
        for (int i=0; i< nome.length(); i++){
            char caractere = nome.charAt(i);
            if((caractere < 'A' || caractere > 'z') && caractere != ' ' ){
                return false;
            }
        }
        return true;
    }
}