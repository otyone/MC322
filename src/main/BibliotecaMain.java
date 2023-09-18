package main;

import biblioteca.controllers.*;
import biblioteca.models.*;
import biblioteca.views.*;
import biblioteca.models.Membros.*;
import biblioteca.models.Pedidos.*;
import biblioteca.models.ItemMulti.*;

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
        itens = null; membros = null; itensTotal = null; //inicializando com null (garantir bom funcionamento)
        
        Set<Categoria> Categorias = new HashSet<>();//Set de Categorias
        Categoria Artes = new Categoria("Artes"); Categoria Tecnologia = new Categoria("Tecnologia"); //criando Categorias-Exemplo
        Categorias.add(Tecnologia); Categorias.add(Artes); //adicionando categorias
        
        Set<Empréstimo> Empréstimos = new HashSet<>(); //set de Empréstimos
        List<Reserva> Reservas = new LinkedList<>(); //lista de reservas de itens
        Empréstimos = null; Reservas = null; //inicializando com null (garantir bom funcionamento)
        
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
                    menuGerenciamentoItens(scanner, bibliotecaView, Reservas, itens, itensTotal, Empréstimos, membros);
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
            }
        }
    }

    private static void menuGerenciamentoItens(Scanner scanner, BibliotecaView bibliotecaView, List<Reserva> Reservas, List<Item> itens, Map<String, Item> itensTotal, Set<Empréstimo> Empréstimos, List<MembroM> membros) {
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
                    adicionarItem(scanner, itensTotal, itens);
                    break;
                case 3:
                    editarItem(scanner);
                    break;
                case 4:
                    removerItem(scanner, itens, itensTotal);
                    break;
                case 5:
                    realizarEmprestimo(scanner, itens, itensTotal, membros, Empréstimos, Reservas);
                    break;
                case 6:
                    realizarRenovacao(scanner);
                    break;
                case 7: 
                    break;
                case 8:
                    devolverItem(scanner, Empréstimos, itens);
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
                    editarMembro(scanner);
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
    
    private static void devolverItem(Scanner scanner, Set<Empréstimo> Empréstimos, List<Item> itens) {
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

    // Métodos para realizar empréstimo
    private static void realizarEmprestimo(Scanner scanner, List<Item> itens, Map<String, Item> itensTotal, List<MembroM> membros, Set<Empréstimo> empréstimos, List<Reserva> reservas) {
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
    private static void adicionarItem(Scanner scanner, Map<String, Item> itensTotal, List<Item> itens) {
        // Lógica para adicionar um novo item
        System.out.println("Operação de Adição de Item");
        System.out.println();
        
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
    
    private static boolean buscarMembro(Scanner scanner, List<MembroM> membros, String name) {
    	if(membros == null) { //se membros é null, não há membros
    		return false;
    	}
        System.out.println("Qual Membro deseja buscar? (Digite o Nome)");
        System.out.println();
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
        	String Nome = scanner.nextLine();
        	scanner.nextLine();
        	boolean test = buscarMembro(scanner, membros, Nome); //verificar se membro já existe
        	if(test == true) {
        		System.out.println("Membro já existe");
        		break;
        	}else {}
        	System.out.println("Identificação:"); //preenchendo variáveis da classe
        	String Identificacao = scanner.nextLine();
        	scanner.nextLine();
        	System.out.println("Contato:");
        	int Contato = scanner.nextInt();
        	scanner.nextLine();
        	System.out.println("Data:");
        	int Data = scanner.nextInt();
        	scanner.nextLine();
        	System.out.println("Faz Pós-Graduação? (true ou false)");
        	boolean Pós = scanner.nextBoolean();
        	scanner.nextLine();
        	Limite = 3; Prazo = 5; Multa = 3.50;
        	Estudante newMembro = new Estudante(Nome, Identificacao, Contato, Data, Limite, Prazo, Multa, null, Pós); //criando instância
        	membros.add(newMembro); //adicionando
        	break;
        case 2:
        	System.out.println("Por favor, digite:");
        	System.out.println();
        	System.out.println("Nome:");
        	Nome = scanner.nextLine();
        	scanner.nextLine();
        	test = buscarMembro(scanner, membros, Nome); //verificar se membro já existe
        	if(test == true) {
        		System.out.println("Membro já existe");
        		break;
        	}else {}
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
        	membros.add(newMembro2); //adicionando
        	break;
        case 3:
        	System.out.println("Por favor, digite:");
        	System.out.println();
        	System.out.println("Nome:");
        	Nome = scanner.nextLine();
        	scanner.nextLine();
        	test = buscarMembro(scanner, membros, Nome); //verificar se membro já existe
        	if(test == true) {
        		System.out.println("Membro já existe");
        		break;
        	}else {}
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
        	membros.add(newMembro3); //adicionando
        	break;
        case 4:
        	return;
        default:
        	System.out.println("Opção inválida. Por favor, escolha novamente.");
        	System.out.println();
        }
      }
    }

    private static void editarMembro(Scanner scanner) {
        // Lógica para editar um membro existente
        System.out.println("Operação de Edição de Membro");
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
