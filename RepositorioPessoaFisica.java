package repositorios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tiposdepessoa.PessoaFisica;



public class RepositorioPessoaFisica implements IRepositorioPessoaFisica{

	ArrayList<PessoaFisica> listaPessoasFisicas = new ArrayList<PessoaFisica>();
	
	@Override
	public boolean salvaPessoaFisica(PessoaFisica pessoa) {
		boolean ok;
		try {
			ok=listaPessoasFisicas.add(pessoa);
			System.out.println("Pessoa salva. Jesus tá on.");
		} catch (Exception e) {
			ok=false;
			System.out.println("Pessoa não foi salva. Ocorreu um erro. Foi fumar um "
					+ "cigarro e não voltou.");
		}
		return ok;
	}/*fim do salvaPessoaFisica*/
	
	/*Método retorna as posições dos objetos na memória*/
	@Override
	public ArrayList<PessoaFisica> retornaListaPessoasFisicas() {
		try {
			for (int i = 0; i < listaPessoasFisicas.size(); i++) {
				System.out.println(listaPessoasFisicas.get(i).getDados());
			}
			
		} catch (Exception e) {
			System.out.println("Não há nenhum aluno matriculado.");
			
		}
		return listaPessoasFisicas;
	}
	@Override
	public boolean atualizaPessoaFisica(PessoaFisica pessoa) {
		/* try catch para descobrir se o aluno está matriculado */
		try {
			/*if else if para descobrir qual/quais dados estão errados*/
			if (listaPessoasFisicas.contains(pessoa) == true) {
				System.out.println("Digite qual dado deve ser alterado na pessoa: nome, cpf, ou todos.");
				String dadosErrados = new Scanner(System.in).nextLine();
				dadosErrados.toLowerCase();
				boolean attempt = false;
				/*while implementado para dar chance de erro de digitação ao user */
				while (attempt == false) {
					switch(dadosErrados)  {
						case "nome":
						System.out.println("Digite o novo nome:");
						String novoNome = new Scanner(System.in).nextLine();
						pessoa.setNome(novoNome);
						attempt = true;
						break;
						
						case "cpf":						
						System.out.println("Digite o novo cpf:");
						int novoCpf = new Scanner(System.in).nextInt();
						pessoa.setCpf(novoCpf);
						attempt = true;
						break;
																	
						default:						
						System.out.println("Digite o novo nome:");
						String novoNome2 = new Scanner(System.in).nextLine();
						pessoa.setNome(novoNome2);
						System.out.println("Digite o novo cpf:");
						int novoCpf2 = new Scanner(System.in).nextInt();
						pessoa.setCpf(novoCpf2);						
						attempt = true;
						break;
						
						
					} 
					} /*fim do while*/
				
			} /*fim do if else */
		} catch (Exception e) {
			return false;
		}
		return true;
	}/*fim do atualiza aluno*/
	
	@Override
	public boolean deletaPessoaFisica(PessoaFisica pessoa) {
	    try {
	        int index = -1; // Initialize with an invalid index
	        for (int i = 0; i < listaPessoasFisicas.size(); i++) {
	            if (listaPessoasFisicas.get(listaPessoasFisicas.indexOf(i)).getNome() == pessoa.getNome()) {
	            	listaPessoasFisicas.remove(pessoa); // Found the matching CPF
	                break;
	            }
	        }
	        System.out.println("A pessoa foi removida.");
	        return true;
	        
	    } catch (Exception e) {
	        System.out.println("Erro ao deletar a pessoa. Ela não consta em nossos registros.");
	        return false;
	    }
	}/*fim do deletaAluno */
	
	@Override
	public void visualizarPessoaFisica(PessoaFisica pessoa) {
		try {
			String pessoaALer = listaPessoasFisicas.get(listaPessoasFisicas.indexOf(pessoa)).getDados();
			System.out.println(pessoaALer);
						
		} catch (Exception e) {
			System.out.println("Não há pessoa com esse nome nos registros.");
			
	}
	}
}
