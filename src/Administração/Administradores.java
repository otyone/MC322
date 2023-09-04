package Administração;
import Membros.Funcionário;

public class Administradores extends Funcionário {
	public Administradores() {
		super();
	}
	public Administradores(String nome, String endereço, int contato, int numID, int data) {
		super(nome, endereço, contato, numID, data);
	}
}