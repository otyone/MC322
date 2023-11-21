package Factory;

public class Musica extends ItemMultimedia{
	private String texto;
	
	public Musica(String texto) {
		this.texto = texto;
	}

	@Override
	public String getTexto() {
		return this.texto;
	}
}