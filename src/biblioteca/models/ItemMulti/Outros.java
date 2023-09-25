package biblioteca.models.ItemMulti;

import java.util.List;

import biblioteca.models.Comentario;

public class Outros extends Item{
	private String Tipo, Formato, Localização, Estado; //atributos específicos, seguidos de construtores e getters/setters
	private int NumTot, NumDisp;
	public Outros() {
		super();
		Tipo = Formato = Localização = Estado = "Empty";
		NumTot = NumDisp = 0;
	}
	public Outros(String titulo, String autorartista, String detalhes, String editoragravadora, String genero, String sinopse,
			String imgpath, int anopub, List<Comentario> comentarios, String tipo, String formato, String localização, String estado, int numTot, int numDisp) {
		super(titulo, autorartista, detalhes, editoragravadora, genero, sinopse, imgpath, anopub, comentarios);
		Tipo = tipo;
		Formato = formato;
		Localização = localização;
		Estado = estado;
		NumTot = numTot;
		NumDisp = numDisp;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getFormato() {
		return Formato;
	}
	public void setFormato(String formato) {
		Formato = formato;
	}
	public String getLocalização() {
		return Localização;
	}
	public void setLocalização(String localização) {
		Localização = localização;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public int getNumTot() {
		return NumTot;
	}
	public void setNumTot(int numTot) {
		NumTot = numTot;
	}
	public int getNumDisp() {
		return NumDisp;
	}
	public void setNumDisp(int numDisp) {
		NumDisp = numDisp;
	}
	
}
