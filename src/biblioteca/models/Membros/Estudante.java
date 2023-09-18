package biblioteca.models.Membros;

import java.util.List;

import biblioteca.models.Pedidos.Empréstimo;

public class Estudante extends MembroM {
	private boolean Pós;
	public Estudante () {
		super();
		Pós = false;
	}
	public Estudante(String nome, String identificacao, int contato, int data, int limiteEmprestimo,
			int prazoEmprestimo, double multaAtraso, List<Empréstimo> emprestimos, boolean pós) {
		super(nome, identificacao, contato, data, limiteEmprestimo, prazoEmprestimo, multaAtraso, emprestimos);
		Pós = pós;
	}
	public boolean isPós() {
		return Pós;
	}
	public void setPós(boolean pós) {
		Pós = pós;
	}
}
