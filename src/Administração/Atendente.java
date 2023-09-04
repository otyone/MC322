package Administração;
import Membros.Funcionário;

public class Atendente extends Funcionário {
	public Atendente() {
		super();
	}
	public Atendente(String nome, String endereço, int contato, int numID, int data) {
		super(nome, endereço, contato, numID, data);
	}
}