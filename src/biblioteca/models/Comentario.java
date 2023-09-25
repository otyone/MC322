package biblioteca.models;

public class Comentario {
	private String membroId, itemId;
	private String Texto;
	public Comentario(String membroId, String itemId, String texto) {
		this.membroId = membroId;
		this.itemId = itemId;
		Texto = texto;
	}
	public String getMembroId() {
		return membroId;
	}
	public void setMembroId(String membroId) {
		this.membroId = membroId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getTexto() {
		return Texto;
	}
	public void setTexto(String texto) {
		Texto = texto;
	}
}