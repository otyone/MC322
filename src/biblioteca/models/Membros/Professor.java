package biblioteca.models.Membros;

import java.util.List;

import biblioteca.models.Pedidos.Empréstimo;

public class Professor extends MembroM {
	public Professor() {
		super();
	}
	public Professor(String nome, String identificacao, int contato, int data, int limiteEmprestimo,
			int prazoEmprestimo, double multaAtraso, List<Empréstimo> emprestimos) {
		super(nome, identificacao, contato, data, limiteEmprestimo, prazoEmprestimo, multaAtraso, emprestimos);
	}
}
