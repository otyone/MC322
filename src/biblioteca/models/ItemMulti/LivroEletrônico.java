package biblioteca.models.ItemMulti;

public class LivroEletrônico extends Item {
	private String Formato, FormatoArq, URL, Requisitos; //atributos específicos, seguidos de construtores e getters/setters
	private int NumLic, Data;
	public LivroEletrônico() {
		super();
		Formato = FormatoArq = URL = Requisitos = "Empty";
		NumLic = Data = 0;
	}
	public LivroEletrônico(String titulo, String autorartista, String editoragravadora, String genero, String sinopse,
			String imgpath, int anopub, String formato, String formatoArq, String uRL, String requisitos, int numLic, int data) {
		super(titulo, autorartista, editoragravadora, genero, sinopse, imgpath, requisitos, anopub);
		Formato = formato;
		FormatoArq = formatoArq;
		URL = uRL;
		Requisitos = requisitos;
		NumLic = numLic;
		Data = data;
	}
	public String getFormato() {
		return Formato;
	}
	public void setFormato(String formato) {
		Formato = formato;
	}
	public String getFormatoArq() {
		return FormatoArq;
	}
	public void setFormatoArq(String formatoArq) {
		FormatoArq = formatoArq;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getRequisitos() {
		return Requisitos;
	}
	public void setRequisitos(String requisitos) {
		Requisitos = requisitos;
	}
	public int getNumLic() {
		return NumLic;
	}
	public void setNumLic(int numLic) {
		NumLic = numLic;
	}
	public int getData() {
		return Data;
	}
	public void setData(int data) {
		Data = data;
	}
	
}
