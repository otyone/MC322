package biblioteca.models.ItemMulti;

public class CDAudio extends Item {
	private String Lista, Duracao, Estado; //atributos específicos, seguidos de construtores e getters/setters
	private int NumTot, NumDisp;
	public CDAudio() {
		super();
		Lista = Duracao = Estado = "Empty";
		NumTot = NumDisp = 0;
	}
	public CDAudio(String titulo, String autorartista, String editoragravadora, String genero, String sinopse,
			String imgpath, int anopub, String lista, String duracao, String estado, int numTot, int numDisp) {
		super(titulo, autorartista, editoragravadora, genero, sinopse, imgpath, estado, anopub);
		Lista = lista;
		Duracao = duracao;
		Estado = estado;
		NumTot = numTot;
		NumDisp = numDisp;
	}
	public String getLista() {
		return Lista;
	}
	public void setLista(String lista) {
		Lista = lista;
	}
	public String getDuracao() {
		return Duracao;
	}
	public void setDuracao(String duracao) {
		Duracao = duracao;
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
