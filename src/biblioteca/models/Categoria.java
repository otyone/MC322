package biblioteca.models;

public class Categoria {
	private String Nome;
	public Categoria(String nome) {
		Nome = nome;
	}
	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}
}