package ObserverDesign;
import java.util.ArrayList;
import java.util.List;
import biblioteca.models.ItemMulti.*;

public class Subject {
	private Item news;
	private List<Notificar> usuarios = new ArrayList<>();
	
	public void addOb(Notificar usuario) {
		this.usuarios.add(usuario);
	}
	
	public void removerOb(Notificar usuario) {
		this.usuarios.remove(usuario);
	}
	
	public void setNotificar(Item news) {
		this.news = news;
		for(Notificar usuario : this.usuarios) {
			usuario.update(this.news);
		}
	}
}