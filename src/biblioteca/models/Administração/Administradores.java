package biblioteca.models.Administração;
import biblioteca.models.Membros.*;

public class Administradores extends Funcionário {
	public Administradores() {
		super();
	}
	public Administradores(String nome, String identificacao, int contato, int data, int limiteEmprestimo,
			int prazoEmprestimo, double multaAtraso) {
		super(nome, identificacao, contato, data, limiteEmprestimo, prazoEmprestimo, multaAtraso);
	}
}