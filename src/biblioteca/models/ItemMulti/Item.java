package biblioteca.models.ItemMulti;

import biblioteca.models.ItemMultimidia;

public class Item implements ItemMultimidia { //criando a superclasse 
	private String Titulo, AutorArtista, Detalhes, EditoraGravadora, Genero, Sinopse; //atributos básicos que toda classe possui
	private int AnoPub;
	private String imgPath; //url da imagem que seria representativa (poderia utilizar uma biblioteca ImageIO para demonstrar
	public Item() { //construtor padrão
		Titulo = AutorArtista = EditoraGravadora = Genero = Sinopse = imgPath = Detalhes = "Empty";
		AnoPub = 0;
	}
	public Item(String titulo, String autorartista, String editoragravadora, String genero, String sinopse, String imgpath, String detalhes, int anopub) { //construtor especifico
		Titulo = titulo;
		AutorArtista = autorartista;
		EditoraGravadora = editoragravadora;
		Genero = genero;
		Sinopse = sinopse;
		AnoPub = anopub;
		imgPath = imgpath;
		Detalhes = detalhes;
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
	public String getDetalhes() {
		return Detalhes;
	}
	public void setDetalhes(String detalhes) {
		Detalhes = detalhes;
	}
}
