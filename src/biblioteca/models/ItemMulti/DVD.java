package biblioteca.models.ItemMulti;

public class DVD extends Item {
	private String Elenco, Duracao, LegendaAudio, Estado; //atributos específicos, seguidos de construtores e getters/setters
	private int NumTot, NumDisp;
	public DVD() {
		super();
		Elenco = Duracao = LegendaAudio = Estado = "Empty";
		NumTot = NumDisp = 0;
	}
	public DVD(String titulo, String autorartista, String editoragravadora, String genero, String sinopse,
			String imgpath, int anopub, String elenco, String duracao, String legendaAudio, String estado, int numTot, int numDisp) {
		super(titulo, autorartista, editoragravadora, genero, sinopse, imgpath, estado, anopub);
		Elenco = elenco;
		Duracao = duracao;
		LegendaAudio = legendaAudio;
		Estado = estado;
		NumTot = numTot;
		NumDisp = numDisp;
	}
	public String getElenco() {
		return Elenco;
	}
	public void setElenco(String elenco) {
		Elenco = elenco;
	}
	public String getDuracao() {
		return Duracao;
	}
	public void setDuracao(String duracao) {
		Duracao = duracao;
	}
	public String getLegendaAudio() {
		return LegendaAudio;
	}
	public void setLegendaAudio(String legendaAudio) {
		LegendaAudio = legendaAudio;
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
