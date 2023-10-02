package repositorios;

import java.util.ArrayList;

import tiposdepessoa.Pessoa;
import tiposdepessoa.PessoaFisica;
import tiposdepessoa.PessoaJuridica;

public interface IRepositorioPessoaJuridica {

		public boolean salvaPessoaJuridica(PessoaJuridica empresa);
		public ArrayList<PessoaJuridica> retornaListaPessoasJuridicas();
		public boolean atualizaPessoaJuridica(PessoaJuridica empresa);
		public boolean deletaPessoaJuridica(PessoaJuridica empresa);
		public void visualizarPessoaJuridica(PessoaJuridica empresa);
	
}

