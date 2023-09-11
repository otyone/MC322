package biblioteca.models.Membros;

public class Funcionário extends MembroM {
	public Funcionário() {
		super();
	}
	public Funcionário(String nome, String identificacao, int contato, int data, int limiteEmprestimo,
			int prazoEmprestimo, double multaAtraso) {
		super(nome, identificacao, contato, data, limiteEmprestimo, prazoEmprestimo, multaAtraso);
	}
}
