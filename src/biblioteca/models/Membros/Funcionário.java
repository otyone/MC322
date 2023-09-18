package biblioteca.models.Membros;

import java.util.List;

import biblioteca.models.Pedidos.Empréstimo;

public class Funcionário extends MembroM {
	public Funcionário() {
		super();
	}
	public Funcionário(String nome, String identificacao, int contato, int data, int limiteEmprestimo,
			int prazoEmprestimo, double multaAtraso, List<Empréstimo> emprestimos) {
		super(nome, identificacao, contato, data, limiteEmprestimo, prazoEmprestimo, multaAtraso, emprestimos);
	}
}
