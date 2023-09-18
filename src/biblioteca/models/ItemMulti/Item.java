package biblioteca.models.ItemMulti;

import biblioteca.models.*;
import biblioteca.controllers.ComentarioController;
import java.util.List;
import java.util.LinkedList;

public class Item implements ItemMultimidia, ComentarioController{ //criando a superclasse 
	private String Titulo, AutorArtista, Detalhes, EditoraGravadora, Genero, Sinopse; //atributos básicos que toda classe possui
	private int AnoPub;
	private String imgPath; //url da imagem que seria representativa (poderia utilizar uma biblioteca ImageIO para demonstrar
	List<Comentario> comentarios = new LinkedList<>();
	public Item() { //construtor padrão
		Titulo = AutorArtista = EditoraGravadora = Genero = Sinopse = imgPath = Detalhes = "Empty";
		AnoPub = 0;
		comentarios = null;
	}
	public Item(String titulo, String autorArtista, String detalhes, String editoraGravadora, String genero,
			String sinopse, int anoPub, String imgPath, List<Comentario> comentarios) { //construtor específico
		Titulo = titulo;
		AutorArtista = autorArtista;
		Detalhes = detalhes;
		EditoraGravadora = editoraGravadora;
		Genero = genero;
		Sinopse = sinopse;
		AnoPub = anoPub;
		this.imgPath = imgPath;
		this.comentarios = comentarios;
	}
	public String getTitulo() {// getters e setters
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getAutorArtista() {
		return AutorArtista;
	}
	public void setAutorArtista(String autorArtista) {
		AutorArtista = autorArtista;
	}
	public String getEditoraGravadora() {
		return EditoraGravadora;
	}
	public void setEditoraGravadora(String editoraGravadora) {
		EditoraGravadora = editoraGravadora;
	}
	public String getGenero() {
		return Genero;
	}
	public void setGenero(String genero) {
		Genero = genero;
	}
	public String getSinopse() {
		return Sinopse;
	}
	public void setSinopse(String sinopse) {
		Sinopse = sinopse;
	}
	public int getAnoPub() {
		return AnoPub;
	}
	public void setAnoPub(int anoPub) {
		AnoPub = anoPub;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String getDetalhes() { //implementação de métodos
		return Detalhes;
	}
	public void setDetalhes(String detalhes) {
		Detalhes = detalhes;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	@Override
	public void adicionar(Comentario comentario) {// implementação de métodos
		comentarios.add(comentario);		
	}
	@Override
	public void remover(Comentario comentario) {
		comentarios.remove(comentario);
	}
	@Override
	public void consultar() {
		for(Comentario comentario : comentarios) {
			System.out.println("membroId:" + comentario.getMembroId() + " itemId:" + comentario.getItemId() + " texto:" + comentario.getTexto());
		}
	}
}
