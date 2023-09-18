package biblioteca.models.Administração;
import java.util.List;

import biblioteca.models.Membros.*;
import biblioteca.models.Pedidos.Empréstimo;

public class Gerente extends Funcionário {
	public Gerente() {
		super();
	}
	public Gerente(String nome, String identificacao, int contato, int data, int limiteEmprestimo, int prazoEmprestimo,
			double multaAtraso, List<Empréstimo> emprestimos) {
		super(nome, identificacao, contato, data, limiteEmprestimo, prazoEmprestimo, multaAtraso, emprestimos);
	}
}