package biblioteca.models;

public class CSingleton {
	private static CSingleton instance;
	public String texto;
	private CSingleton(String texto) {
		this.texto = texto;
	}
	public static CSingleton getInstance(String texto) {
		if (instance == null) {
			instance = new CSingleton(texto);
		}
		return instance;
	}
}