package repositorios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tiposdepessoa.PessoaFisica;
import tiposdepessoa.PessoaJuridica;

public class RepositorioPessoaJuridica implements IRepositorioPessoaJuridica{

	ArrayList<PessoaJuridica> listaPessoasJuridicas = new ArrayList<PessoaJuridica>();
	
	@Override
	public boolean salvaPessoaJuridica(PessoaJuridica empresa) {
		boolean ok;
		try {
			ok=listaPessoasJuridicas.add(empresa);
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
	public ArrayList<PessoaJuridica> retornaListaPessoasJuridicas() {
		try {
			for (int i = 0; i < listaPessoasJuridicas.size(); i++) {
				System.out.println(listaPessoasJuridicas.get(i).getDados());
			}
			
		} catch (Exception e) {
			System.out.println("Não há nenhum aluno matriculado.");
			
		}		
		return listaPessoasJuridicas;
	}
	
	@Override
	public boolean atualizaPessoaJuridica(PessoaJuridica empresa) {
		/* try catch para descobrir se o aluno está matriculado */
		try {
			/*if else if para descobrir qual/quais dados estão errados*/
			if (listaPessoasJuridicas.contains(empresa) == true) {
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
						empresa.setNome(novoNome);
						attempt = true;
						break;
						
						case "cnpj":						
						System.out.println("Digite o novo cnpj:");
						int novoCnpj = new Scanner(System.in).nextInt();
						empresa.setCnpj(novoCnpj);
						attempt = true;
						break;
																	
						default:						
						System.out.println("Digite o novo nome:");
						String novoNome2 = new Scanner(System.in).nextLine();
						empresa.setNome(novoNome2);
						System.out.println("Digite o novo cnpj:");
						int novoCnpj2 = new Scanner(System.in).nextInt();
						empresa.setCnpj(novoCnpj2);						
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
	public boolean deletaPessoaJuridica(PessoaJuridica empresa) {
	    
	    	try {
		        
		        for (int i = 0; i < listaPessoasJuridicas.size(); i++) {
		            if (listaPessoasJuridicas.get(listaPessoasJuridicas.indexOf(i)).getNome() == empresa.getNome()) {
		            	listaPessoasJuridicas.remove(empresa); // Found the matching CPF
		                break;
		            }
		        }
		        System.out.println("A empresa foi removida.");
		        return true;
		        
		    } catch (Exception e) {
		        System.out.println("Erro ao deletar a empresa. Ela não consta em nossos registros.");
		        return false;
		    }
	    	
	    	}/*fim do deletaPJ */
	
	@Override	
	public void visualizarPessoaJuridica(PessoaJuridica empresa) {
		try {
			String empresaALer = listaPessoasJuridicas.get(listaPessoasJuridicas.indexOf(empresa)).getDados();
			System.out.println(empresaALer);
						
		} catch (Exception e) {
			System.out.println("Não há empresa com esse nome nos registros.");
			
	}
	}
}