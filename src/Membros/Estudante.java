package Membros;

public class Estudante extends Membro {
	private boolean Pós;
	public Estudante () {
		super();
		Pós = false;
	}
	public Estudante(String nome, String endereço, int contato, int numID, int data, boolean pós) {
		super(nome, endereço, contato, numID, data);
		Pós = pós;
	}
	public boolean isPós() {
		return Pós;
	}
	public void setPós(boolean pós) {
		Pós = pós;
	}
}
