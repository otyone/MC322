package biblioteca.models.Administração;
import biblioteca.models.Membros.*;

public class Gerente extends Funcionário {
	public Gerente() {
		super();
	}
	public Gerente(String nome, String identificacao, int contato, int data, int limiteEmprestimo, int prazoEmprestimo,
			double multaAtraso) {
		super(nome, identificacao, contato, data, limiteEmprestimo, prazoEmprestimo, multaAtraso);
	}
}