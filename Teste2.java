package tiposdepessoa;

import java.util.ArrayList;
import java.util.Scanner;

import repositorios.IRepositorioPessoaFisica;
import repositorios.IRepositorioPessoaJuridica;
import repositorios.RepositorioPessoaFisica;
import repositorios.RepositorioPessoaJuridica;

public class Teste2 {
    @SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
    	        
        // Criando instancias dos repositorios
        IRepositorioPessoaFisica repoPessoaFisica = new RepositorioPessoaFisica();
        IRepositorioPessoaJuridica repoPessoaJuridica = new RepositorioPessoaJuridica();
        
        ArrayList<PessoaJuridica> pessoasJuridicas = repoPessoaJuridica.retornaListaPessoasJuridicas();
        ArrayList<PessoaFisica> pessoasFisicas = repoPessoaFisica.retornaListaPessoasFisicas();
        
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        String tipoPessoa = null;

        while (!exit) {
            
        	 if (tipoPessoa == null) {
                 System.out.println("Escolha um dos tipos:");
                 System.out.println("A. Pessoa Física");
                 System.out.println("B. Pessoa Jurídica");
                 System.out.println("X. Sair");
                 System.out.print("Digite a sua escolha: ");

                 String escolha = scanner.nextLine().toUpperCase();

                 switch (escolha) {
                     case "A":                        
                         tipoPessoa = "Pessoa Física";
                         break;
                     case "B":                        
                         tipoPessoa = "Pessoa Juridica";
                         break;
                     case "X":
                         exit = true;
                         break;
                     default:
                         System.out.println("Escolha inválida. Por favor escolha uma das opções.");
                         continue;
                 }
        	 } else {
                 System.out.println("Menu CRUD:");
                 System.out.println("1. Criar/Novo");
                 System.out.println("2. Visualizar/Ler");
                 System.out.println("3. Atualizar");
                 System.out.println("4. Deletar");
                 System.out.println("5. Imprimir Lista Completa");
                 System.out.println("6. Voltar para Seleção de Tipos");
                 System.out.println("7. Sair");
                 System.out.print("Digite sua escolha: ");

                 int escolha;
                 if (scanner.hasNextInt()) {
                     escolha = scanner.nextInt();
                     scanner.nextLine(); // Consume the newline character
                 } else {
                     System.out.println("Invalid input. Please enter a number.");
                     scanner.nextLine(); // Consume the invalid input
                     continue; // Restart the loop
                 }
        	
        	
        	switch (escolha) {
                case 1:
                    
                    if (tipoPessoa.equals("Pessoa Física")) {
                    	
                        System.out.println("Digite o nome da pessoa:");
                        String primeiroNome = scanner.nextLine();
                        PessoaFisica pessoaFisica = new PessoaFisica(primeiroNome);
                        System.out.println("Digite o cpf da pessoa:");
                        int cpfNovo = scanner.nextInt();
                        pessoaFisica.setCpf(cpfNovo);
                        repoPessoaFisica.salvaPessoaFisica(pessoaFisica);
                        System.out.println("Pessoa salva com sucesso!");
                        
                    } else {
                    	
                    	System.out.println("Digite o nome da empresa:");
                        String nomeEmpresa = scanner.nextLine();
                        PessoaJuridica empresa = new PessoaJuridica(nomeEmpresa);
                        System.out.println("Digite o cnpj da empresa:");
                        int cnpjNovo = scanner.nextInt();
                        empresa.setCnpj(cnpjNovo);
                        repoPessoaJuridica.salvaPessoaJuridica(empresa);
                        System.out.println("Pessoa salva com sucesso!");
                    }//fim if-else case 1
                    
                    System.out.println("Criação ou Geração.");
                    break;

                case 2:
                    
                    if (tipoPessoa.equals("Pessoa Física")) {
                        
                        System.out.println("Digite o nome da pessoa que você busca:");
                        String pessoaALer = scanner.nextLine();
                        for (PessoaFisica pessoa : pessoasFisicas) {
                            if (pessoa.getNome().equals(pessoaALer)) {
                                System.out.println(pessoa.getDados());
                                break;
                            }
                        }
                        
                    } else {
                        
                    	System.out.println("Digite o nome da empresa que você busca:");
                        String empresaALer = scanner.nextLine();
                        for (PessoaJuridica empresa : pessoasJuridicas) {
                            if (empresa.getNome().equals(empresaALer)) {
                                System.out.println(empresa.getDados());
                                break;
                            }
                        }
                    } //fim if-else case 2
                    
                    System.out.println("Leitura ou Visualização.");
                    break;
                    
                case 3:
                	
                	if (tipoPessoa.equals("Pessoa Física")) {
                		
                		System.out.println("Digite o nome da pessoa que você busca:");
                        String pessoaALer = scanner.nextLine();
                        for (PessoaFisica pessoa : pessoasFisicas) {
                            if (pessoa.getNome().equals(pessoaALer)) {
                            	repoPessoaFisica.atualizaPessoaFisica(pessoa);
                                break;
                            }
                        }
                		
                	} else {
                		
                		System.out.println("Digite o nome da empresa que você busca:");
                        String empresaALer = scanner.nextLine();
                        for (PessoaJuridica empresa : pessoasJuridicas) {
                            if (empresa.getNome().equals(empresaALer)) {
                            	repoPessoaJuridica.atualizaPessoaJuridica(empresa);
                                break;
                            }
                        }
                		
                	} //fim if-else case 3
                	
                	System.out.println("Update ou Atualização.");
                    break;
                	
                case 4:
                	
                	if (tipoPessoa.equals("Pessoa Física")) {
                		
                		System.out.println("Digite o nome da pessoa que você quer deletar:");
                		String pessoaALer = scanner.nextLine();
                		for (PessoaFisica pessoa : pessoasFisicas) {
                            if (pessoa.getNome().equals(pessoaALer)) {
                            	System.out.println("Tem certeza que quer deletar? S/N");
                            	Character deleteConfirmado = scanner.next().charAt(0);
                            	if (deleteConfirmado.equals('S')) {
                            		repoPessoaFisica.deletaPessoaFisica(pessoa);
                            		System.out.println("A pessoa foi apagada dos registros.");
                                break;
                            } else {
                            	System.out.println("A pessoa foi mantida dos registros.");
                            	continue;
                            }
                            }
                		}
                		
                	} else {
                		
                		System.out.println("Digite o nome da empresa que você quer deletar:");
                		String empresaALer = scanner.nextLine();
                		for (PessoaJuridica empresa : pessoasJuridicas) {
                            if (empresa.getNome().equals(empresaALer)) {
                            	System.out.println("Tem certeza que quer deletar? S/N");
                            	Character deleteConfirmado = scanner.next().charAt(0);
                            	if (deleteConfirmado.equals('S')) {
                            	repoPessoaJuridica.deletaPessoaJuridica(empresa);
                            	System.out.println("A empresa foi apagada dos registros.");
                                break;
                            } else {
                            	System.out.println("A empresa foi mantida dos registros.");
                            	continue;
                            }
                            }
                		}
                		
                	} //fim if-else case 4
                	
                	System.out.println("Deletar ou Apagar.");
                    break;
                    
                case 5:
                    if (tipoPessoa.equals("Pessoa Física")) {
                        // Assign the returned list to a variable and print it
                        
                        for (PessoaFisica pessoa : pessoasFisicas) {
                            System.out.println(pessoa.getDados());
                        }
                    } else {
                        // Assign the returned list to a variable and print it
                        
                        for (PessoaJuridica empresa : pessoasJuridicas) {
                            System.out.println(empresa.getDados());
                        }
                    }
                    break;
                	
                case 6:
                	
                	tipoPessoa = null; // Back to Type Selection
                    break;
                    
                case 7:
                	
                	exit = true;
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                	
            } //fim do switch(choice)
        }

        
    }
        scanner.close();
    }

}