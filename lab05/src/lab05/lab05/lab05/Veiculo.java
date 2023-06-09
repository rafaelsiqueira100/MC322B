//Nome: Rafael Andre Alves de Siqueira
//RA: 243360
//Classe que representa a entidade Veículo
package lab05;
public class Veiculo {
	private String placa;
	private String marca;
	private String modelo;
	private int anoFabricacao;
	public Veiculo (String placa, String marca, String modelo, int anoFabricacao) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String toString() {
		return "{Veiculo:{Placa:"+this.getPlaca()+", \n"
				+" Marca: "+this.getMarca()+",\n"
				+ "Modelo: "+this.getModelo()+", \n"
				+ "Ano de Fabricação: "+Integer.toString(anoFabricacao)
				+ "}}";
	}
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public boolean equals(Object o) {
		if(this == o) 
			return true;
		if(o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		final Veiculo v = (Veiculo) o;
		if(v.getPlaca().equals(placa))
			return true;
		return false;		
	}
	
}