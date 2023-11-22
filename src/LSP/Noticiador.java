package LSP;
import ISP.*;

public class Noticiador extends Dispositivo implements Noticia {

	public Noticiador(Integer tamanho) {
		super(tamanho);
	}
	
	public void noticia(String texto) {
		System.out.println("Segue última notícia reportada: " +texto);
	}
	
	public String getFuncao() {
		return "Noticiador: reportar mensagens e/ou notícias";
	}

}