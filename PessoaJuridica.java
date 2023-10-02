package tiposdepessoa;

public class PessoaJuridica extends Pessoa {
    
	public PessoaJuridica(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	private int cnpj;

    
    public int getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(int val) {
        this.cnpj = val;
    }

    @Override
    public String getNome() {
        return super.getNome(); // Call the superclass's getNome method
    }

    @Override
    public void setNome(String val) {
        super.setNome(val); // Call the superclass's setNome method
    }

    public String getDados() {
        String dados = "Nome: " + this.getNome() + " - CNPJ: " + this.getCnpj() + "\n";
        return dados;
    }
}
