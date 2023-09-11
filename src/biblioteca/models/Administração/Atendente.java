package biblioteca.models.Administração;
import biblioteca.models.Membros.*;

public class Atendente extends Funcionário {
	public Atendente() {
		super();
	}
	public Atendente(String nome, String identificacao, int contato, int data, int limiteEmprestimo,
			int prazoEmprestimo, double multaAtraso) {
		super(nome, identificacao, contato, data, limiteEmprestimo, prazoEmprestimo, multaAtraso);
	}
}