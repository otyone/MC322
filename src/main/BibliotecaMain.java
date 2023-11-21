package main;

import biblioteca.controllers.*;
import biblioteca.models.*;
import biblioteca.views.*;
import biblioteca.models.Membros.*;
import biblioteca.models.Pedidos.*;
import biblioteca.models.ItemMulti.*;
import Generics.*;
import Factory.*;
import SRP.*;
import OCP.*;
import ObserverDesign.*;
import TypesExceptions.*;
import biblioteca.models.SistemaBiblioteca.*;

import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class BibliotecaMain {
    private static BibliotecaController bibliotecaController;
    private static MembroController membroController;
    private static RelatorioController relatorioController;

    public static void main(String[] args) {
        bibliotecaController = new BibliotecaControllerImpl();
        membroController = new MembroControllerImpl(); 
        relatorioController = new RelatorioControllerImpl();

        BibliotecaView bibliotecaView = new BibliotecaViewImpl(bibliotecaController);
        MembroView membroView = new MembroViewImpl(membroController);
        RelatorioView relatorioView = new RelatorioViewImpl(relatorioController);

        Scanner scanner = new Scanner(System.in);
        
        List<MembroM> membros = membroController.listarMembros(); //lista de membros
        List<Item> itens = bibliotecaController.consultarItensDisponiveis(); //lista de itens disponíveis (não emprestados/reservados)
        Map<String, Item> itensTotal = new HashMap<>(); //map de itens totais
        
        Set<Categoria> Categorias = new HashSet<>();//Set de Categorias
        Categoria Artes = new Categoria("Artes"); Categoria Tecnologia = new Categoria("Tecnologia"); //criando Categorias-Exemplo
        Categorias.add(Tecnologia); Categorias.add(Artes); //adicionando categorias
        
        Set<Empréstimo> Empréstimos = new HashSet<>(); //set de Empréstimos
        List<Reserva> Reservas = new LinkedList<>(); //lista de reservas de itens
        List<Multa> Multas = new LinkedList<>(); //lista de multas
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Teste para classes genéricas: ");
        
        DVD dvd = new DVD();  Outros outro = new Outros(); ReservaSala Sala1 = new ReservaSala(2509, 11, 14); ReservaSala.SalaIndividual SalaI = Sala1.new SalaIndividual(10,true); //instanciando objetos para testar as classes genéricas
        
        ItemBiblioteca<DVD> itemB = new ItemBibliotecaImpl<DVD>(); ItemBiblioteca<Outros> itemB2 = new ItemBibliotecaImpl<Outros>(); //instanciando dois tipos de ItemBiblioteca
        itemB.ReservarItem(dvd); itemB.DevolverItem(dvd); itemB2.EmprestarItem(outro); itemB2.DevolverItem(outro); //testando métodos
        
        ListaReserva<ReservaSala.SalaIndividual> ListaR = new ListaReservaImpl<ReservaSala.SalaIndividual>(); ListaReserva<ItemMultimidia> ListaR2 = new ListaReservaImpl<ItemMultimidia>(); //instanciando dois tipos de Lista Reserva
        ListaR.Reservar(SalaI); ListaR.Reservar(SalaI); ListaR.mostrarReservas(); ListaR.Remover(SalaI); ListaR.mostrarReservas(); //testando métodos
        ListaR2.Reservar(dvd); ListaR2.Reservar(outro); ListaR2.mostrarReservas(); ListaR2.Remover(dvd); ListaR2.mostrarReservas(); //testando métodos comprovando diferentes tipos de itens
        
        ListaEmpréstimos<DVD> ListaE = new ListaEmpréstimosImpl<DVD>(); ListaEmpréstimos<ItemMultimidia> ListaE2 = new ListaEmpréstimosImpl<ItemMultimidia>(); //instanciando dois tipos de Lista Empréstimos
        ListaE.Emprestar(dvd); ListaE.Emprestar(dvd); ListaE.mostrarEmpréstimos(); ListaE.Remover(dvd); ListaE.mostrarEmpréstimos(); //testando métodos
        ListaE2.Emprestar(outro); ListaE2.Emprestar(dvd); ListaE2.mostrarEmpréstimos(); ListaE2.Remover(outro); ListaE2.mostrarEmpréstimos(); //testando métodos comprovando diferentes tipos de itens
        
        System.out.println("        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n"
        		+ "");
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Teste para reflexão: ");
        
        CReflection<List<MembroM>> reflection = new CReflection<List<MembroM>>(); //instanciando uma reflection de tipo Lista Membro
        MembroM membroteste = new MembroM(); Item itemteste = new Item(); //instanciando objetos teste de tipo Membro e Item
        
        reflection.imprimirAtributos(membroteste, itemteste); //imprimindo atributos 
        reflection.imprimirMetodos(membroteste, itemteste); //imprimindo métodos
        reflection.imprimirInfo(membros);// imprimir tamanho da lista através de invoke
        
        System.out.println("        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n"
        		+ "");
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Teste para padrão Singleton: ");
        
        CSingleton singleton1 = CSingleton.getInstance("chocolate"); //criando instancia de CSingleton
        CSingleton singleton2 = CSingleton.getInstance("suco"); //"criando" instancia de Singleton novamente
        System.out.println(singleton1.texto); //provando que apenas uma instancia é possivel
        System.out.println(singleton2.texto);
        System.out.println();
        
        System.out.println("        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n"
        		+ "");
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Teste para padrão Observer: ");
        
        Subject observable = new Subject(); //instanciando observado
        CObserver observer = new CObserver(); //instanciando observador
        
        observable.addOb(observer); //adicionando observado
        observable.setNotificar(itemteste); //testando
        System.out.println("Item notificado: " +observer.getNews().getTitulo());
        System.out.println();
        
        System.out.println("        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n"
        		+ "");
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Teste para padrão Factory: ");
        
        ItemMultimedia livro = ItemMultimedia.getItemMultimedia("Livro", "nome do livro"); //fabricar instância livro
        ItemMultimedia musica = ItemMultimedia.getItemMultimedia("Musica", "nome da musica"); //fabricar instância musica
        System.out.println("Items: " +livro.getTexto() +" ; " +musica.getTexto()); //test
        System.out.println();
        
        System.out.println("        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n"
        		+ "");
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Teste para primeiro princípio SOLID - Single Responsibility Principle: ");
        
        Mostrar mostrar = new Console(); //instanciando classe para um único proposito
        mostrar.display(itemteste.getTitulo(), itemteste.getAutorArtista(), itemteste.getDetalhes()); //classe unicamente para mostrar informações de um item, sem criar uma função na própria classe de item
        
        System.out.println("        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n"
        		+ "");
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Teste para segundo princípio SOLID - Open Closed Principle: ");
        
        Relatório relatório = new Relatório(); //instanciando classe apropriada
        relatório.setNome("Relatório de Item"); relatório.setCodigo(251);
        relatório.display(itemteste.getTitulo(), itemteste.getAutorArtista(), itemteste.getDetalhes()); //imprimindo outras informações pertinentes sem alterar interface original
        
        System.out.println("        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n"
        		+ "");
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        while (true) {
            System.out.println("---- Menu Biblioteca ----");
            System.out.println();
            System.out.println("1. Gerenciamento de Itens");
            System.out.println("2. Gerenciamento de Membros");
            System.out.println("3. Geração de Relatórios e Estatísticas");
            System.out.println("4. Administração de Funcionários");
            System.out.println("5. Sair");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Menu de Gerenciamento de Itens
                    menuGerenciamentoItens(scanner, bibliotecaView, Reservas, itens, itensTotal, Empréstimos, Multas, membros);
                    break;
                case 2:
                    // Menu de Gerenciamento de Membros
                    menuGerenciamentoMembros(scanner, membroView, membros);
                    break;
                case 3:
                    // Menu de Geração de Relatórios e Estatísticas
                    menuRelatoriosEstatisticas(scanner, relatorioView);
                    break;
                case 4:
                    // Menu de Administração de Funcionários
                    menuAdministracaoFuncionarios(scanner);
                    break;
                case 5:
                    System.out.println("Saindo do menu. Até logo!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
                    System.out.println();
            }
        }
    }

    private static void menuGerenciamentoItens(Scanner scanner, BibliotecaView bibliotecaView, List<Reserva> Reservas, List<Item> itens, Map<String, Item> itensTotal, Set<Empréstimo> Empréstimos, List<Multa> Multas, List<MembroM> membros) {
        while (true) {
            System.out.println("---- Menu Gerenciamento de Itens ----");
            System.out.println();
            System.out.println("1. Listar Itens Disponíveis");
            System.out.println("2. Adicionar Item");
            System.out.println("3. Editar Item");
            System.out.println("4. Remover Item");
            System.out.println("5. Empréstimo de Itens");
            System.out.println("6. Renovação de Empréstimos");
            System.out.println("7. Reservas de Itens");
            System.out.println("8. Retornar um item");
            System.out.println("9. Voltar");
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoItens = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoItens) {
                case 1:
                    bibliotecaView.mostrarItensDisponiveis(itens);
                    break;
                case 2:
                    adicionarItem(scanner, itensTotal, itens, membros);
                    break;
                case 3:
                    editarItem(scanner);
                    break;
                case 4:
                    removerItem(scanner, itens, itensTotal);
                    break;
                case 5:
                	try {
                    realizarEmprestimo(scanner, itens, itensTotal, membros, Empréstimos, Reservas, Multas);
                	} catch(ExcecaoLimiteEmprestimo e) {
                		System.err.println("Erro ao realizar empréstimo: " + e.getMessage());
                		System.out.println();
                	} catch(ExcecaoMultaPendente m) {
                		System.err.println("Erro ao realizar empréstimo: " + m.getMessage());
                		System.out.println();
                	} catch(ExcecaoItemND i) {
                		System.err.println("Erro ao realizar empréstimo: " + i.getMessage());
                		System.out.println();
                	}
                	finally {
                		System.out.println("Por favor, realize novamente o empréstimo:");
                		System.out.println();
                	}
                    break;
                case 6:
                    realizarRenovacao(scanner);
                    break;
                case 7:
                	fazerReservaPadrão(scanner, itens, itensTotal, membros, Reservas);
                    break;
                case 8:
				try {
					devolverItem(scanner, Empréstimos, itens);
				} catch (ExcecaoItemNEmp e) {
					System.err.println("Erro ao devolver: " + e.getMessage());
            		System.out.println();
				} catch (ExcecaoItemDanificado e) {
					System.err.println("Erro ao devolver: " + e.getMessage());
            		System.out.println();
				}
				finally {
            		System.out.println("Por favor, realize novamente a devolução");
            		System.out.println();
            	}
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
                    System.out.println();
            }
        }
    }

    private static void menuGerenciamentoMembros(Scanner scanner, MembroView membroView, List<MembroM> membros) {
        while (true) {
            System.out.println("---- Menu Gerenciamento de Membros ----");
            System.out.println();
            System.out.println("1. Listar Membros");
            System.out.println("2. Adicionar Membro");
            System.out.println("3. Editar Membro");
            System.out.println("4. Remover Membro");
            System.out.println("5. Buscar membro");
            System.out.println("6. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoMembros = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoMembros) {
                case 1:
                    membroView.mostrarListaMembros(membros);
                    break;
                case 2:
                    adicionarMembro(scanner, membros);
                    break;
                case 3:
                    editarMembro(scanner, membros);
                    break;
                case 4:
                    removerMembro(scanner, membros);
                    break;
                case 5:
                    buscarMembroPorID(scanner);
                    break;
                case 6:
                	return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
                    System.out.println();
            }
        }
    }

    private static void menuRelatoriosEstatisticas(Scanner scanner, RelatorioView relatorioView) {
        while (true) {
            System.out.println("---- Menu Relatórios e Estatísticas ----");
            System.out.println();
            System.out.println("1. Gerar Relatório de Atividades de Membros");
            System.out.println("2. Gerar Relatório de Uso de Itens Multimídia");
            System.out.println("3. Gerar Relatório de Multas e Pagamentos");
            System.out.println("4. Gerar Relatório de Disponibilidade de Itens");
            System.out.println("5. Gerar Estatísticas de Uso por Perfil de Membro");
            System.out.println("6. Gerar Relatório de Itens Mais Populares");
            System.out.println("7. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoRelatorios = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoRelatorios) {
                case 1:
                    gerarRelatorioAtividadesMembros();
                    break;
                case 2:
                    gerarRelatorioUsoItens();
                    break;
                case 3:
                    gerarRelatorioMultas();
                    break;
                case 4:
                    gerarRelatorioDisponibilidadeItens();
                    break;
                case 5:
                    gerarEstatisticasUsoPorPerfil();
                    break;
                case 6:
                    gerarRelatorioItensPopulares();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuAdministracaoFuncionarios(Scanner scanner) {
        while (true) {
            System.out.println("---- Menu Administração de Funcionários ----");
            System.out.println();
            System.out.println("1. Administradores");
            System.out.println("2. Atendentes");
            System.out.println("3. Gerentes");
            System.out.println("4. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoFuncionarios = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoFuncionarios) {
                case 1:
                    // Menu de Administração de Administradores
                    menuAdministradores(scanner);
                    break;
                case 2:
                    // Menu de Administração de Atendentes
                    menuAtendentes(scanner);
                    break;
                case 3:
                    // Menu de Administração de Gerentes
                    menuGerentes(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuAdministradores(Scanner scanner) {
        // Lógica para administração de administradores
    }

    private static void menuAtendentes(Scanner scanner) {
        // Lógica para administração de atendentes
    }

    private static void menuGerentes(Scanner scanner) {
        // Lógica para administração de gerentes
    }
    
    private static void devolverItem(Scanner scanner, Set<Empréstimo> Empréstimos, List<Item> itens) throws ExcecaoItemNEmp, ExcecaoItemDanificado{
        System.out.println("Qual Item deseja devolver? (Digite o Nome)"); //descobrir item
        System.out.println();
    	String Titulo = scanner.nextLine();
    	scanner.nextLine();
    	Item itest = buscaItem(itens, Titulo); //buscar item
    	if(itest == null) { //verificar se item existe
    		System.out.println("Item não existe");
            System.out.println();
    	}
    	Iterator<Empréstimo> it = Empréstimos.iterator(); //definir iterator
    	while(it.hasNext()) {
    		Empréstimo check = it.next();
    		if(check.getObjeto() == itest) { //verificar se existe Item no Set de Empréstimos
    			Empréstimos.remove(check); //remover item do Set
    			itens.add(itest); //adicionar item aos Itens Disponíveis
    			System.out.println("Item devolvido!");
    			System.out.println();
    		}
    	}
		System.out.println("Item não consta como emprestado!");
		System.out.println();
    }
    
    private static void buscarMembroPorID(Scanner scanner) {
        System.out.println("Qual Membro deseja buscar? (Digite o Nome)"); //descobrir Membro
        System.out.println();
    	String Nome = scanner.nextLine();
    	scanner.nextLine();
    	Membro test = membroController.buscarMembroPorIdentificacao(Nome); //achar membro
    	if(test == null) { //check
    		System.out.println("Membro não encontrado");
    		System.out.println();
    	}else {
    		System.out.println("Membro encontrado");
    		System.out.println();
    	}
    }
    
    private static boolean buscaReserva(List<Reserva> reservas, Item itest) { //verificar se item está reservado
    	if(reservas == null) { //se lista de reservas não existir, não há item reservado
    		return false;
    	}
    	Item Objeto = itest;
        Iterator<Reserva> it = reservas.iterator();
        while(it.hasNext()) {
        	Reserva test = it.next();
        	if(test.getObjeto() == Objeto) { //check se item está reservado
        		return true;
        	}
        }
    	return false; //item não está reservado
    }
    
    private static Item buscaItem(List<Item> itens, String titulo) { //buscar item disponível
    	if(itens == null) { //se lista de itens disponíveis for null, não há item
    		System.out.println("Item não existe");
    		System.out.println();
    		return null;
    	}
        String Titulo = titulo;
        Iterator<Item> it = itens.iterator();
        while(it.hasNext()) {
        	Item test = it.next();
        	if(test.getTitulo() == Titulo) { //check se há o item
        		return test;
        	}
        }
    	System.out.println("Item não está disponível"); //item não está disponível, porém pode existir
    	System.out.println();
    	return null;
    }
    
    private static MembroM buscaM(List<MembroM> membros, String nome) { //buscar membro
    	if(membros == null) {//se lista de membros está nula, não há membros
    		System.out.println("Membro não existe");
    		System.out.println();
    		return null;
    	}
        String Nome = nome;
        Iterator<MembroM> it = membros.iterator();
        while(it.hasNext()) {
        	MembroM test = it.next();
        	if(test.getNome() == Nome) { //check se membro existe
        		return test;
        	}
        }
        System.out.println("Membro não existe");//membro não existe
        System.out.println();
    	return null;
    }
    
    private static boolean checkReserva(String titulo, MembroM membro, Item Itest, Map<String, Item> itensTotal, List<Reserva> reservas) { //checar se Item está na reserva
    	if(Itest == null) { //se Itest for null, significa que ele não está disponível
    		if(itensTotal == null) { //se itensTotal é null, não há item nenhum na biblioteca
    			System.out.println("Não há itens na Biblioteca");
    			System.out.println();
    			return false;
    		}
    		Itest = itensTotal.get(titulo);
    		boolean test = buscaReserva(reservas, Itest); //busca se está na reserva
    		if(test == true) {
    			System.out.println("Item já está reservado"); //item ja está na reserva
    			System.out.println();
    			return false;
    		}else {
    			fazerReserva(reservas, membro, Itest); //faz a reserva
    		}
    	}
    	return true; //reserva feita
    }
    
    private static void fazerReservaPadrão(Scanner scanner, List<Item> itens, Map<String, Item> itensTotal, List<MembroM> membros, List<Reserva> reservas) {
        // Lógica para realizar uma reserva
        System.out.println("Operação de Reserva de Itens");
        System.out.println();
    	System.out.println("Quem está requerindo o Item? (Digite o Nome)"); //descobrir membro
    	System.out.println();
    	String Nome = scanner.nextLine();
    	scanner.nextLine();
    	MembroM Mtest = buscaM(membros, Nome); //buscar membro
    	if(Mtest == null) { //membro não existe
    		return;
    	}
        System.out.println("Qual Item deseja realizar a Reserva? (Digite o Título)"); //descobrir Item
        System.out.println();
    	String Titulo = scanner.nextLine();
    	scanner.nextLine();
    	Item Itest = buscaItem(itens, Titulo); //buscar Item
    	boolean check = checkReserva(Titulo, Mtest, Itest, itensTotal, reservas); //verificar se está reservado
    	if(check == false) { //já está reservado 
    		return;
    	}
    }

    // Métodos para realizar empréstimo
    private static void realizarEmprestimo(Scanner scanner, List<Item> itens, Map<String, Item> itensTotal, List<MembroM> membros, Set<Empréstimo> empréstimos, List<Reserva> reservas, List<Multa> Multas) throws ExcecaoLimiteEmprestimo, ExcecaoItemND, ExcecaoMultaPendente{
        // Lógica para realizar um empréstimo
        System.out.println("Operação de Empréstimo de Itens");
        System.out.println();
    	System.out.println("Quem está requerindo o Item? (Digite o Nome)"); //descobrir membro
    	System.out.println();
    	String Nome = scanner.nextLine();
    	scanner.nextLine();
    	MembroM Mtest = buscaM(membros, Nome); //buscar membro
    	if(Mtest == null) { //membro não existe
    		return;
    	}
        System.out.println("Qual Item deseja realizar o Empréstimo? (Digite o Título)"); //descobrir Item
        System.out.println();
    	String Titulo = scanner.nextLine();
    	scanner.nextLine();
    	Item Itest = buscaItem(itens, Titulo); //buscar Item
    	boolean check = checkReserva(Titulo, Mtest, Itest, itensTotal, reservas); //verificar se está reservado
    	if(check == false) { //já está reservado 
    		return;
    	}if(itens.contains(Itest) != true) {
    		throw new ExcecaoItemND("Item não está disponível!");
    	}
    	Empréstimo emprestimo = new Empréstimo(Itest, Mtest);
    	if(empréstimos.contains(emprestimo)) { //verificar se já está emprestado
    		System.out.println("Empréstimo já realizado");
    		System.out.println();
    	}
    	empréstimos.add(emprestimo); //adicionar no Set
    	itens.remove(Itest); //remover de itens disponíveis
    	bibliotecaController.emprestarItem(Mtest, Itest); //adicionar no histórico de empréstimos do membro
    	return;
    }
    

    private static void realizarRenovacao(Scanner scanner) {
        // Lógica para realizar uma renovação de empréstimo
        System.out.println("Operação de Renovação de Empréstimos");
    }

    private static void fazerReserva(List<Reserva> reservas, MembroM membro, Item Itest) {
        // Lógica para fazer uma reserva de item
        System.out.println("Operação de Reserva de Itens");
        System.out.println();
        Reserva reserva = new Reserva(Itest, membro);
        reservas.add(reserva); //adicionar na lista de reservas
        return;
    }

    // Métodos para adicionar, editar e remover itens e membros
    private static void adicionarItem(Scanner scanner, Map<String, Item> itensTotal, List<Item> itens, List<MembroM> membros) {
        // Lógica para adicionar um novo item
    	while(true) {
    		String Titulo, AutorArtista, Detalhes, EditoraGravadora, Genero, Sinopse, imgPath;
    		int AnoPub;
 	        System.out.println("Operação de Adição de Item");
	        System.out.println();
	        System.out.println("1. CD de Áudio");
	        System.out.println("2. DVD");
	        System.out.println("3. Livro Eletrônico");
	        System.out.println("4. Livro Físico");
	        System.out.println("5. Outros");
	        System.out.println("6. Retorna");
	        System.out.println();
	        int decisao = scanner.nextInt(); 
	        scanner.nextLine();
	        switch(decisao) {
	        case 1:
	        	System.out.println("Por favor, digite:");
	        	System.out.println();
	        	System.out.println("Título:");
	        	Titulo = scanner.nextLine();
	        	scanner.nextLine();        	
	        	System.out.println("Autor ou Artista responsável:"); //preenchendo variáveis da classe
	        	AutorArtista = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Detalhes:");
	        	Detalhes = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Editora ou Gravadora:");
	        	EditoraGravadora = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Genêro:");
	        	Genero = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Sinopse:"); 
	        	Sinopse = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Ano de publicação:");
	        	AnoPub = scanner.nextInt();
	        	scanner.nextLine();
	        	System.out.println("URL de Imagem para Capa:");
	        	imgPath = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Lista de músicas:");
	        	String Lista = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Duração:");
	        	String Duracao = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Estado do item:"); 
	        	String Estado = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Número total do item:");
	        	int NumTot = scanner.nextInt();
	        	scanner.nextLine();
	        	System.out.println("Número disponível do item:");
	        	int NumDisp = scanner.nextInt();
	        	scanner.nextLine();
	        	System.out.println("Deseja adicionar algum comentário sobre o item?");
	        	scanner.nextLine();
	        	System.out.println("1. Sim");
	            System.out.println("2. Não");
	            System.out.println();
	            decisao = scanner.nextInt(); 
	            scanner.nextLine();
	            switch(decisao) {
	            case 1:
	            	while(true) {
	            		System.out.println("Qual membro está escrevendo o comentário? (Digite o Nome)");
	                	scanner.nextLine();
	                	String Nome = scanner.nextLine();
	                	scanner.nextLine();
	                	boolean test = buscarMembro(membros, Nome);
	                	if(test == true) {
	                		System.out.println("Qual o comentário?");
	                    	scanner.nextLine();
	                    	String Texto = scanner.nextLine();
	                    	scanner.nextLine();
	                    	Comentario newComentario = new Comentario(Nome, Titulo, Texto);
	                    	CDAudio newCD = new CDAudio(Titulo, AutorArtista, Detalhes, EditoraGravadora, Genero, Sinopse, imgPath, AnoPub, null, Lista, Duracao, Estado, NumTot, NumDisp);
	                    	newCD.adicionar(newComentario);
	                    	itens.add(newCD);
	                    	itensTotal.put(Titulo, newCD);
	                    	break;
	                	}else {
	                		System.out.println("Membro não existe!");
	                		scanner.nextLine();
	                		break;
	                	}
	            	}
	            case 2:
	            	CDAudio newCD = new CDAudio(Titulo, AutorArtista, Detalhes, EditoraGravadora, Genero, Sinopse, imgPath, AnoPub, null, Lista, Duracao, Estado, NumTot, NumDisp);
	            	itens.add(newCD);
	            	itensTotal.put(Titulo, newCD);
	            	break;
	            }
	        	break;
	        case 2:
	        	System.out.println("Por favor, digite:");
	        	System.out.println();
	        	System.out.println("Título:");
	        	Titulo = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Autor ou Artista responsável:"); //preenchendo variáveis da classe
	        	AutorArtista = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Detalhes:");
	        	Detalhes = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Editora ou Gravadora:");
	        	EditoraGravadora = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Genêro:");
	        	Genero = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Sinopse:"); 
	        	Sinopse = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Ano de publicação:");
	        	AnoPub = scanner.nextInt();
	        	scanner.nextLine();
	        	System.out.println("URL de Imagem para Capa:");
	        	imgPath = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Elenco:");
	        	String Elenco = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Duração:");
	        	String Duracao2 = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Linguagem Legenda e Áudio:");
	        	String LegendaAudio = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Estado do item:"); 
	        	String Estado2 = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Número total do item:");
	        	int NumTot2 = scanner.nextInt();
	        	scanner.nextLine();
	        	System.out.println("Número disponível do item:");
	        	int NumDisp2 = scanner.nextInt();
	        	scanner.nextLine();
	        	System.out.println("Deseja adicionar algum comentário sobre o item?");
	        	scanner.nextLine();
	        	System.out.println("1. Sim");
	            System.out.println("2. Não");
	            System.out.println();
	            decisao = scanner.nextInt(); 
	            scanner.nextLine();
	            switch(decisao) {
	            case 1:
	            	while(true) {
	            		System.out.println("Qual membro está escrevendo o comentário? (Digite o Nome)");
	                	scanner.nextLine();
	                	String Nome = scanner.nextLine();
	                	scanner.nextLine();
	                	boolean test = buscarMembro(membros, Nome);
	                	if(test == true) {
	                		System.out.println("Qual o comentário?");
	                    	scanner.nextLine();
	                    	String Texto = scanner.nextLine();
	                    	scanner.nextLine();
	                    	Comentario newComentario = new Comentario(Nome, Titulo, Texto);
	                    	DVD newDVD = new DVD(Titulo, AutorArtista, Detalhes, EditoraGravadora, Genero, Sinopse, imgPath, AnoPub, null, Elenco, Duracao2, LegendaAudio, Estado2, NumTot2, NumDisp2);
	                    	newDVD.adicionar(newComentario);
	                    	itens.add(newDVD);
	                    	itensTotal.put(Titulo, newDVD);
	                    	break;
	                	}else {
	                		System.out.println("Membro não existe!");
	                		scanner.nextLine();
	                		break;
	                	}
	            	}
	            case 2:
	            	DVD newDVD = new DVD(Titulo, AutorArtista, Detalhes, EditoraGravadora, Genero, Sinopse, imgPath, AnoPub, null, Elenco, Duracao2, LegendaAudio, Estado2, NumTot2, NumDisp2);
                	itens.add(newDVD);
                	itensTotal.put(Titulo, newDVD);
	            	break;
	            }
	        	break;
	        case 3:
	        	System.out.println("Por favor, digite:");
	        	System.out.println();
	        	System.out.println("Título:");
	        	Titulo = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Autor ou Artista responsável:"); //preenchendo variáveis da classe
	        	AutorArtista = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Detalhes:");
	        	Detalhes = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Editora ou Gravadora:");
	        	EditoraGravadora = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Genêro:");
	        	Genero = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Sinopse:"); 
	        	Sinopse = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Ano de publicação:");
	        	AnoPub = scanner.nextInt();
	        	scanner.nextLine();
	        	System.out.println("URL de Imagem para Capa:");
	        	imgPath = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Formato:");
	        	String Formato = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Formato do Arquivo:");
	        	String FormatoArq = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("URL:"); 
	        	String URL = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Requisitos:"); 
	        	String Requisitos = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Número de licenças:");
	        	int NumLic = scanner.nextInt();
	        	scanner.nextLine();
	        	System.out.println("Data:");
	        	int Data = scanner.nextInt();
	        	scanner.nextLine();
	        	System.out.println("Deseja adicionar algum comentário sobre o item?");
	        	scanner.nextLine();
	        	System.out.println("1. Sim");
	            System.out.println("2. Não");
	            System.out.println();
	            decisao = scanner.nextInt(); 
	            scanner.nextLine();
	            switch(decisao) {
	            case 1:
	            	while(true) {
	            		System.out.println("Qual membro está escrevendo o comentário? (Digite o Nome)");
	                	scanner.nextLine();
	                	String Nome = scanner.nextLine();
	                	scanner.nextLine();
	                	boolean test = buscarMembro(membros, Nome);
	                	if(test == true) {
	                		System.out.println("Qual o comentário?");
	                    	scanner.nextLine();
	                    	String Texto = scanner.nextLine();
	                    	scanner.nextLine();
	                    	Comentario newComentario = new Comentario(Nome, Titulo, Texto);
	                    	LivroEletrônico newLivroE = new LivroEletrônico(Titulo, AutorArtista, Detalhes, EditoraGravadora, Genero, Sinopse, imgPath, AnoPub, null, Formato, FormatoArq, URL, Requisitos, NumLic, Data);
	                    	newLivroE.adicionar(newComentario);
	                    	itens.add(newLivroE);
	                    	itensTotal.put(Titulo, newLivroE);
	                    	break;
	                	}else {
	                		System.out.println("Membro não existe!");
	                		scanner.nextLine();
	                		break;
	                	}
	            	}
	            case 2:
	            	LivroEletrônico newLivroE = new LivroEletrônico(Titulo, AutorArtista, Detalhes, EditoraGravadora, Genero, Sinopse, imgPath, AnoPub, null, Formato, FormatoArq, URL, Requisitos, NumLic, Data);
                	itens.add(newLivroE);
                	itensTotal.put(Titulo, newLivroE);
	            	break;
	            }
	        	break;
	        case 4:
	        	System.out.println("Por favor, digite:");
	        	System.out.println();
	        	System.out.println("Título:");
	        	Titulo = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Autor ou Artista responsável:"); //preenchendo variáveis da classe
	        	AutorArtista = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Detalhes:");
	        	Detalhes = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Editora ou Gravadora:");
	        	EditoraGravadora = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Genêro:");
	        	Genero = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Sinopse:"); 
	        	Sinopse = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Ano de publicação:");
	        	AnoPub = scanner.nextInt();
	        	scanner.nextLine();
	        	System.out.println("URL de Imagem para Capa:");
	        	imgPath = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Localização:");
	        	String Localizacao = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Estado do item:"); 
	        	String Estado3 = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("ISBN:");
	        	int ISBN = scanner.nextInt();
	        	scanner.nextLine();
	        	System.out.println("Edição:");
	        	int Edicao = scanner.nextInt();
	        	scanner.nextLine();
	        	System.out.println("Número total do item:");
	        	int NumTot3 = scanner.nextInt();
	        	scanner.nextLine();
	        	System.out.println("Número disponível da edição:");
	        	int NumED = scanner.nextInt();
	        	scanner.nextLine();
	        	System.out.println("Deseja adicionar algum comentário sobre o item?");
	        	scanner.nextLine();
	        	System.out.println("1. Sim");
	            System.out.println("2. Não");
	            System.out.println();
	            decisao = scanner.nextInt(); 
	            scanner.nextLine();
	            switch(decisao) {
	            case 1:
	            	while(true) {
	            		System.out.println("Qual membro está escrevendo o comentário? (Digite o Nome)");
	                	scanner.nextLine();
	                	String Nome = scanner.nextLine();
	                	scanner.nextLine();
	                	boolean test = buscarMembro(membros, Nome);
	                	if(test == true) {
	                		System.out.println("Qual o comentário?");
	                    	scanner.nextLine();
	                    	String Texto = scanner.nextLine();
	                    	scanner.nextLine();
	                    	Comentario newComentario = new Comentario(Nome, Titulo, Texto);
	                    	LivroFisico newLivroF = new LivroFisico(Titulo, AutorArtista, Detalhes, EditoraGravadora, Genero, Sinopse, imgPath, AnoPub, null, Localizacao, Estado3, ISBN, Edicao, NumTot3, NumED);
	                    	newLivroF.adicionar(newComentario);
	                    	itens.add(newLivroF);
	                    	itensTotal.put(Titulo, newLivroF);
	                    	break;
	                	}else {
	                		System.out.println("Membro não existe!");
	                		scanner.nextLine();
	                		break;
	                	}
	            	}
	            case 2:
	            	LivroFisico newLivroF = new LivroFisico(Titulo, AutorArtista, Detalhes, EditoraGravadora, Genero, Sinopse, imgPath, AnoPub, null, Localizacao, Estado3, ISBN, Edicao, NumTot3, NumED);
                	itens.add(newLivroF);
                	itensTotal.put(Titulo, newLivroF);
	            	break;
	            }
	        	break;
	        case 5:
	        	System.out.println("Por favor, digite:");
	        	System.out.println();
	        	System.out.println("Título:");
	        	Titulo = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Autor ou Artista responsável:"); //preenchendo variáveis da classe
	        	AutorArtista = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Detalhes:");
	        	Detalhes = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Editora ou Gravadora:");
	        	EditoraGravadora = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Genêro:");
	        	Genero = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Sinopse:"); 
	        	Sinopse = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Ano de publicação:");
	        	AnoPub = scanner.nextInt();
	        	scanner.nextLine();
	        	System.out.println("URL de Imagem para Capa:");
	        	imgPath = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Tipo de Item:");
	        	String Tipo = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Formato:");
	        	String Formato2 = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Localização:"); 
	        	String Localizacao2 = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Estado do item:"); 
	        	String Estado4 = scanner.nextLine();
	        	scanner.nextLine();
	        	System.out.println("Número total do item:");
	        	int NumTot4 = scanner.nextInt();
	        	scanner.nextLine();
	        	System.out.println("Número disponível do item:");
	        	int NumDisp4 = scanner.nextInt();
	        	scanner.nextLine();
	        	System.out.println("Deseja adicionar algum comentário sobre o item?");
	        	scanner.nextLine();
	        	System.out.println("1. Sim");
	            System.out.println("2. Não");
	            System.out.println();
	            decisao = scanner.nextInt(); 
	            scanner.nextLine();
	            switch(decisao) {
	            case 1:
	            	while(true) {
	            		System.out.println("Qual membro está escrevendo o comentário? (Digite o Nome)");
	                	scanner.nextLine();
	                	String Nome = scanner.nextLine();
	                	scanner.nextLine();
	                	boolean test = buscarMembro(membros, Nome);
	                	if(test == true) {
	                		System.out.println("Qual o comentário?");
	                    	scanner.nextLine();
	                    	String Texto = scanner.nextLine();
	                    	scanner.nextLine();
	                    	Comentario newComentario = new Comentario(Nome, Titulo, Texto);
	                    	Outros newOutro = new Outros(Titulo, AutorArtista, Detalhes, EditoraGravadora, Genero, Sinopse, imgPath, AnoPub, null, Tipo, Formato2, Localizacao2, Estado4, NumTot4, NumDisp4);
	                    	newOutro.adicionar(newComentario);
	                    	itens.add(newOutro);
	                    	itensTotal.put(Titulo, newOutro);
	                    	break;
	                	}else {
	                		System.out.println("Membro não existe!");
	                		scanner.nextLine();
	                		break;
	                	}
	            	}
	            case 2:
	            	Outros newOutro = new Outros(Titulo, AutorArtista, Detalhes, EditoraGravadora, Genero, Sinopse, imgPath, AnoPub, null, Tipo, Formato2, Localizacao2, Estado4, NumTot4, NumDisp4);
                	itens.add(newOutro);
                	itensTotal.put(Titulo, newOutro);
	            	break;
	            }
	        	break;
	        case 6:
	        	return;
	        default:
	        	System.out.println("Opção inválida. Por favor, escolha novamente.");
	        	System.out.println();
	        }
    	}
    }

    private static void editarItem(Scanner scanner) {
        // Lógica para editar um item existente
        System.out.println("Operação de Edição de Item");
    }

    private static void removerItem(Scanner scanner, List<Item> itens, Map<String, Item> itensTotal) {
        // Lógica para remover um item
    	if(itens == null) {
    		System.out.println("Não há itens!");
            System.out.println();
            return;
    	}
        System.out.println("Operação de Remoção de Item");
        System.out.println();
        System.out.println("Qual Item deseja remover? (Digite o Nome)"); //descobrir item
        System.out.println();
    	String Titulo = scanner.nextLine();
    	scanner.nextLine();
    	if(itensTotal.containsKey(Titulo)) {
    		itensTotal.remove(Titulo);
    	}else {
    		System.out.println("Item não existe");
            System.out.println();
            return;
    	}
    	Item itest = buscaItem(itens, Titulo); //buscar item disponível
    	if(itest == null) { //verificar se item está disponível
    		return;
    	}else {
    		itens.remove(itest);
    	}
    	System.out.println("Item removido!");
        System.out.println();
        return;
    }
    
    private static boolean buscarMembro(List<MembroM> membros, String name) {
    	if(membros == null) { //se membros é null, não há membros
    		return false;
    	}
        String Nome = name;
        Iterator<MembroM> it = membros.iterator();
        while(it.hasNext()) {
        	MembroM test = it.next();
        	if(test.getNome() == Nome) { //verificar se membro existe
        		return true;
        	}
        }
    	return false;
    }

    private static void adicionarMembro(Scanner scanner, List<MembroM> membros) { //método para adicionar Membro
        // Lógica para adicionar um novo membro
    	while(true) {
    	String Nome, Identificacao;
    	int Contato, Data;
    	System.out.println("Operação de Adição de Membro"); //descobrir que tipo de membro
    	System.out.println();
        System.out.println("1. Estudante");
        System.out.println("2. Funcionário");
        System.out.println("3. Professor");
        System.out.println("4. Retorna");
        int decisaoMembro = scanner.nextInt(); //variáveis da classe
        int Limite, Prazo;
        double Multa;
        scanner.nextLine();
        switch(decisaoMembro) {
        case 1:
        	System.out.println("Por favor, digite:");
        	System.out.println();
        	System.out.println("Nome:");
        	Nome = scanner.nextLine();
        	scanner.nextLine();
        	System.out.println("Identificação:"); //preenchendo variáveis da classe
        	Identificacao = scanner.nextLine();
        	scanner.nextLine();
        	System.out.println("Contato:");
        	Contato = scanner.nextInt();
        	scanner.nextLine();
        	System.out.println("Data:");
        	Data = scanner.nextInt();
        	scanner.nextLine();
        	System.out.println("Faz Pós-Graduação? (true ou false)");
        	boolean Pós = scanner.nextBoolean();
        	scanner.nextLine();
        	Limite = 3; Prazo = 5; Multa = 3.50;
        	Estudante newMembro = new Estudante(Nome, Identificacao, Contato, Data, Limite, Prazo, Multa, null, Pós); //criando instância
        	if(membros.contains(newMembro)) {
        		System.out.println("Membro já existe");
        		break;
        	}
        	membros.add(newMembro); //adicionando
        	((MembroControllerImpl) membroController).setMembros(membros);
        	break;
        case 2:
        	System.out.println("Por favor, digite:");
        	System.out.println();
        	System.out.println("Nome:");
        	Nome = scanner.nextLine();
        	scanner.nextLine();
        	System.out.println("Identificação:"); //preenchendo variáveis da classe
        	Identificacao = scanner.nextLine();
        	scanner.nextLine();
        	System.out.println("Contato:");
        	Contato = scanner.nextInt();
        	scanner.nextLine();
        	System.out.println("Data:");
        	Data = scanner.nextInt();
        	scanner.nextLine();
        	Limite = 5; Prazo = 10; Multa = 1.50;
        	Funcionário newMembro2 = new Funcionário(Nome, Identificacao, Contato, Data, Limite, Prazo, Multa, null); //criando instância
        	if(membros.contains(newMembro2)) {
        		System.out.println("Membro já existe");
        		break;
        	}
        	membros.add(newMembro2); //adicionando
        	((MembroControllerImpl) membroController).setMembros(membros);
        	break;
        case 3:
        	System.out.println("Por favor, digite:");
        	System.out.println();
        	System.out.println("Nome:");
        	Nome = scanner.nextLine();
        	scanner.nextLine();
        	System.out.println("Identificação:"); //preenchendo variáveis da classe
        	Identificacao = scanner.nextLine();
        	scanner.nextLine();
        	System.out.println("Contato:");
        	Contato = scanner.nextInt();
        	scanner.nextLine();
        	System.out.println("Data:");
        	Data = scanner.nextInt();
        	scanner.nextLine();
        	Limite = 7; Prazo = 10; Multa = 1.50;
        	Professor newMembro3 = new Professor(Nome, Identificacao, Contato, Data, Limite, Prazo, Multa, null); //criando instância
        	if(membros.contains(newMembro3)) {
        		System.out.println("Membro já existe");
        		break;
        	}
        	membros.add(newMembro3); //adicionando
        	((MembroControllerImpl) membroController).setMembros(membros);
        	break;
        case 4:
        	return;
        default:
        	System.out.println("Opção inválida. Por favor, escolha novamente.");
        	System.out.println();
        }
      }
    }

    private static void editarMembro(Scanner scanner, List<MembroM> membros) {
        // Lógica para editar um membro existente
    	while(true) {
    		System.out.println("Operação de Edição de Membro");
            System.out.println();
            System.out.println("Qual Membro deseja editar? (Digite o Nome)"); //descobrir Membro
            System.out.println();
            String Nome = scanner.nextLine();
            scanner.nextLine();
            boolean test = buscarMembro(membros, Nome);
            if(test == false) {
            	System.out.println("Membro não existe!");
            	System.out.println();
            	return;
            }else {
            	int Number;
            	MembroM memb = buscaM(membros, Nome);
            	System.out.println("O que deseja editar?"); 
                System.out.println();
                System.out.println("1. Nome");
                System.out.println("2. Identificação");
                System.out.println("3. Contato");
                System.out.println("4. Data");
                System.out.println("5. Retorna");
                System.out.println();
                int decisaoMembro = scanner.nextInt();
                scanner.nextLine();
                switch(decisaoMembro) {
                case 1:
                	System.out.println("Novo nome"); 
                    System.out.println();
                    Nome = scanner.nextLine();
                    scanner.nextLine();
                    memb.setNome(Nome);
                    System.out.println("Sucesso!"); 
                    System.out.println();
                    ((MembroControllerImpl) membroController).setMembros(membros);
                    break;
                case 2:
                	System.out.println("Nova Identificação"); 
                    System.out.println();
                    Nome = scanner.nextLine();
                    scanner.nextLine();
                    memb.setIdentificacao(Nome);
                    System.out.println("Sucesso!"); 
                    System.out.println();
                    ((MembroControllerImpl) membroController).setMembros(membros);
                    break;
                case 3:
                	System.out.println("Novo Contato"); 
                    System.out.println();
                    Number = scanner.nextInt();
                    scanner.nextLine();
                    memb.setContato(Number);
                    System.out.println("Sucesso!"); 
                    System.out.println();
                    ((MembroControllerImpl) membroController).setMembros(membros);
                    break;
                case 4:
                	System.out.println("Nova Data"); 
                    System.out.println();
                    Number = scanner.nextInt();
                    scanner.nextLine();
                    memb.setData(Number);
                    System.out.println("Sucesso!"); 
                    System.out.println();
                    ((MembroControllerImpl) membroController).setMembros(membros);
                    break;
                case 5:
                	return;
                default:
                	System.out.println("Opção inválida. Por favor, escolha novamente.");
                	System.out.println();
                }
            }
        }
    }

    private static void removerMembro(Scanner scanner, List<MembroM> membros) {
        // Lógica para remover um membro
        System.out.println("Operação de Remoção de Membro");
        System.out.println();
    	if(membros == null) { //se membros é null, não há membros
    		System.out.println("Não existem Membros!");
            System.out.println();
    		return;
    	}
        System.out.println("Qual Membro deseja remover? (Digite o Nome)"); //descobrir Membro
        System.out.println();
        String Nome = scanner.nextLine();
        scanner.nextLine();
        Iterator<MembroM> it = membros.iterator();
        while(it.hasNext()) {
        	MembroM test = it.next();
        	if(test.getNome() == Nome) { //verificar se membro existe
        		membros.remove(test); //remover membro
        		System.out.println("Membro removido!");
                System.out.println();
                ((MembroControllerImpl) membroController).setMembros(membros);
                return;
        	}
        }
        System.out.println("Membro não existe!");
        System.out.println();
    	return;
    }

    // Métodos para gerar relatórios e estatísticas
    private static void gerarRelatorioAtividadesMembros() {
        // Lógica para gerar o Relatório de Atividades de Membros
        System.out.println("Gerando Relatório de Atividades de Membros");
    }

    private static void gerarRelatorioUsoItens() {
        // Lógica para gerar o Relatório de Uso de Itens Multimídia
        System.out.println("Gerando Relatório de Uso de Itens Multimídia");
    }

    private static void gerarRelatorioMultas() {
        // Lógica para gerar o Relatório de Multas e Pagamentos
        System.out.println("Gerando Relatório de Multas e Pagamentos");
    }

    private static void gerarRelatorioDisponibilidadeItens() {
        // Lógica para gerar o Relatório de Disponibilidade de Itens
        System.out.println("Gerando Relatório de Disponibilidade de Itens");
    }

    private static void gerarEstatisticasUsoPorPerfil() {
        // Lógica para gerar as Estatísticas de Uso por Perfil de Membro
        System.out.println("Gerando Estatísticas de Uso por Perfil de Membro");
    }

    private static void gerarRelatorioItensPopulares() {
        // Lógica para gerar o Relatório de Itens Mais Populares
        System.out.println("Gerando Relatório de Itens Mais Populares");
    }
}
