package tiposdepessoa;

public class PessoaFisica extends Pessoa {
    private int cpf;

    /* Método Construtor nome mandatory */
    public PessoaFisica(String nome) {
        super(nome);
    }

    /* Métodos Get e Set */
    public int getCpf() {
        return this.cpf;
    }

    public void setCpf(int val) {
        this.cpf = val;
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
        String dados = "Nome: " + this.getNome() + " - CPF: " + this.getCpf() + "\n";
        return dados;
    }
}
