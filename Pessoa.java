package tiposdepessoa;

public class Pessoa {
	private String nome;
	
	/*Construtor com nome*/
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	/*Métodos Get e Set*/
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String val) {
		this.nome = val;
	}
	
	
}
