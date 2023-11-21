package ObserverDesign;
import biblioteca.models.ItemMulti.*;

public class CObserver implements Notificar {
	private Item news;
	
	@Override
	public void update(Object i) {	
		this.setNews((Item) i);
	}

	public Item getNews() {
		return news;
	}

	public void setNews(Item news) {
		this.news = news;
	}
	
}