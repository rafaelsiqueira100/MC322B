package lab02;

public class Sinistro {
	private int id;
	private String data;
	private String endereco;
	public Sinistro(String data, String endereco) {
		this.data = data;
		this.endereco = endereco;
		double min = 1;
		double max = 2147483647;
		this.id = (int) Math.floor(Math.random() *(max - min + 1) + min);
	}
	public int getId() {
		return this.id;
	}
	public void setId(int novoId) {
		if (novoId > 0)
			this.id = novoId;
	}
	public String getData() {
		return this.data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getEndereco() {
		return this.endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
