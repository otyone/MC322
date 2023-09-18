package biblioteca.models.ItemMulti;

import java.util.List;

import biblioteca.models.Comentario;

public class LivroFisico extends Item {
	private String Localização, Estado; //atributos específicos, seguidos de construtores e getters/setters
	private int ISBN, Edição, NumTot, NumEd;
	public LivroFisico() {
		super();
		Localização = Estado = "Empty";
		ISBN = Edição = NumTot = NumEd = 0;
	}
	public LivroFisico(String titulo, String autorartista, String editoragravadora, String genero, String sinopse,
			String imgpath, int anopub, List<Comentario> comentarios, String localização, String estado, int iSBN, int edição, int numTot, int numEd) {
		super(titulo, autorartista, editoragravadora, genero, sinopse, imgpath, anopub, estado, comentarios);
		Localização = localização;
		Estado = estado;
		ISBN = iSBN;
		Edição = edição;
		NumTot = numTot;
		NumEd = numEd;
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
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public int getEdição() {
		return Edição;
	}
	public void setEdição(int edição) {
		Edição = edição;
	}
	public int getNumTot() {
		return NumTot;
	}
	public void setNumTot(int numTot) {
		NumTot = numTot;
	}
	public int getNumEd() {
		return NumEd;
	}
	public void setNumEd(int numEd) {
		NumEd = numEd;
	}
	
}
