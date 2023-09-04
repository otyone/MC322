import ItemMultimidia.*; //import de bibliotecas
import Membros.*;
import Pedidos.*;
import Administração.*;
import Relatórios.*;
import java.util.Scanner;

public class Main {
	
	static boolean test(Pedido[] Pedidos, Membro membro, Item item) {//programa exemplo para testar se é possível fazer empréstimo
		if(Pedidos[0] == null) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Item[] Itens = new Item[5]; //criando objetos (itens como livros e membros como alunos, etc)
		Itens[0] = new LivroFisico("Livro Fisico", "Bruno", "Unicamp", "Cientifico", "Livro para programação", "diretorio.com", 2023, "Estante 23", "Bom", 9999, 12, 25, 17);
		Itens[1] = new LivroEletrônico("Livro Fisico", "Bruno", "Unicamp", "Cientifico", "Livro para programação", "diretorio.com", 2023, "PDF", ".PDF", "diretório", "Adobe", 20, 2023);
		Itens[2] = new CDAudio("Livro Fisico", "Bruno", "Unicamp", "Cientifico", "Livro para programação", "diretorio.com", 2023, "Musica1Musica2Musica3", "10 minutos e 53 segundos", "Bom", 15, 8);
		Itens[3] = new DVD("Livro Fisico", "Bruno", "Unicamp", "Cientifico", "Livro para programação", "diretorio.com", 2023, "Vocalista único: Bruno", "17 minutos e 33 segundos", "Sem legenda, Áudio Português", "Ótimo", 11, 11);
		Itens[4] = new Outros("Livro Fisico", "Bruno", "Unicamp", "Cientifico", "Livro para programação", "diretorio.com", 2023, "Pasta", ".zip", "Prateleira 11", "Ruim", 1, 1);
		Membro[] Membros = new Membro[6];
		Membros[0] = new Estudante("Victor", "Campinas", 01234, 18117, 2022, false);
		Membros[1] = new Professor("Victor", "Campinas", 01234, 18117, 2022);
		Membros[2] = new Funcionário("Victor", "Campinas", 01234, 18117, 2022);
		Membros[3] = new Administradores("Victor", "Campinas", 01234, 18117, 2022);
		Membros[4] = new Atendente("Victor", "Campinas", 01234, 18117, 2022);
		Membros[5] = new Gerente("Victor", "Campinas", 01234, 18117, 2022);
		Pedido[] Pedidos = new Pedido[4]; //criando objeto para pedidos (empréstimos, multas, etc)
		for(int i = 0; i > 4; i++) { //inicializando Pedidos
			Pedidos[i] = null;
		}
		Scanner scanner = new Scanner(System.in); //iniciliazando para input de usuário
		System.out.print("Empréstimo de qual Item (0 a 4) e por qual pessoa (de 0 a 5)?"); //pergunta para usuário
		int num1 = scanner.nextInt(); //guardando dados
		int num2 = scanner.nextInt();
		scanner.close(); //fechando scanner
		boolean Result = test(Pedidos, Membros[num1], Itens[num2]); //rodando test
		if(Result == true) { // consequência de test
			Pedidos[0] = new Empréstimo(Itens[num2], Membros[num1]);
			Pedidos[1] = new Reserva(Itens[4], Membros[4]);
		}
		System.out.print("Primeiro Item: " +Itens[0].getTitulo() +", Terceiro Membro: " +Membros[2].getNome() +", Primeiro Pedido: " +Pedidos[0].getPedinte().getNome() +"*" +Pedidos[0].getObjeto().getTitulo());
	}
}
