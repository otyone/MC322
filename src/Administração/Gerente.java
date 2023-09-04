package Administração;
import Membros.Funcionário;

public class Gerente extends Funcionário {
	public Gerente() {
		super();
	}
	public Gerente(String nome, String endereço, int contato, int numID, int data) {
		super(nome, endereço, contato, numID, data);
	}
}