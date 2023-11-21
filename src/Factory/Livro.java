package Factory;

public class Livro extends ItemMultimedia{
	private String texto;
	
	public Livro(String texto) {
		this.texto = texto;
	}
	
	@Override
	public String getTexto() {
		return this.texto;
	}
}