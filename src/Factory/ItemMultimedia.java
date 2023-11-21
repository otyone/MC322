package Factory;

public abstract class ItemMultimedia implements IItemMultimediaFactory{
	
	public abstract String getTexto();

	public static ItemMultimedia getItemMultimedia(String tipo, String texto) {
		if("Livro".equalsIgnoreCase(tipo)) return new Livro(texto);
		else if("Musica".equalsIgnoreCase(tipo)) return new Musica(texto);
		return null;
	}
}