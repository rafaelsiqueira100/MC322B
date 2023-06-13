//package lab05;
import java.util.Date;
import java.util.ArrayList;
public class Condutor{
    private final String cpf;
    private String nome;
    private String endereco;
    private String email;
    private String telefone;
    private Date dataNasc;
    private ArrayList<Sinistro> listaSinistros;
    public Condutor(String cpf, String nome, String telefone, String endereco, String email,
     Date dataNasc){
        this.cpf = cpf;
        this.nome = nome; 
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.listaSinistros = new ArrayList<Sinistro>();

    }
    public void adicionarSinistro(Sinistro aAdicionar){
        this.listaSinistros.add(aAdicionar);
    }
    public String toString() {
		return "{Condutor:{Nome:"+this.nome+",\n"
				+ "Endereco:"+this.endereco+ ",\n"
				+ "E-mail:"+this.email + ",\n"
				+ "Telefone: "+this.telefone +",\n"
                + "DataNasc" + this.dataNasc.toString() + "\n"
				+"}}";
	}
    
}