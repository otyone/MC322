package biblioteca.models;

public class Comentario {
	private int membroId, itemId;
	private String Texto;
	public Comentario(int membroId, int itemId, String texto) {
		this.membroId = membroId;
		this.itemId = itemId;
		Texto = texto;
	}
	public int getMembroId() {
		return membroId;
	}
	public void setMembroId(int membroId) {
		this.membroId = membroId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getTexto() {
		return Texto;
	}
	public void setTexto(String texto) {
		Texto = texto;
	}
}