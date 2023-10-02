package repositorios;

import java.util.ArrayList;
import java.util.List;

import tiposdepessoa.Pessoa;
import tiposdepessoa.PessoaFisica;
import tiposdepessoa.PessoaJuridica;

public interface IRepositorioPessoaFisica {

		public boolean salvaPessoaFisica(PessoaFisica pessoa);
		public ArrayList<PessoaFisica> retornaListaPessoasFisicas();
		public boolean atualizaPessoaFisica(PessoaFisica pessoa);
		public boolean deletaPessoaFisica(PessoaFisica pessoa);
		public void visualizarPessoaFisica(PessoaFisica pessoa);
	
}
