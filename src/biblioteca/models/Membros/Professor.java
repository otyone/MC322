package biblioteca.models.Membros;

public class Professor extends MembroM {
	public Professor() {
		super();
	}
	public Professor(String nome, String identificacao, int contato, int data, int limiteEmprestimo,
			int prazoEmprestimo, double multaAtraso) {
		super(nome, identificacao, contato, data, limiteEmprestimo, prazoEmprestimo, multaAtraso);
	}
}
