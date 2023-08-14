package bibliotecauno;

public class Livro {
	private String Titulo, Autor, Editora, Disciplina;
	private int Edicao, Ano, ISBN; private double Preco;
	public Livro() {
		Titulo = Autor = Editora = Disciplina = "Empty";
		Edicao = Ano = ISBN = 0;
		Preco = (float) 0;
	}
	public Livro(String n1, String n2, String n3, String n4, int m1, int m2, int m3, double f1) {
		Titulo = n1;
		Autor = n2;
		Editora = n3;
		Disciplina = n4;
		Edicao = m1;
		Ano = m2;
		ISBN = m3;
		Preco = f1;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getAutor() {
		return Autor;
	}
	public void setAutor(String autor) {
		Autor = autor;
	}
	public String getEditora() {
		return Editora;
	}
	public void setEditora(String editora) {
		Editora = editora;
	}
	public String getDisciplina() {
		return Disciplina;
	}
	public void setDisciplina(String disciplina) {
		Disciplina = disciplina;
	}
	public int getEdicao() {
		return Edicao;
	}
	public void setEdicao(int edicao) {
		Edicao = edicao;
	}
	public int getAno() {
		return Ano;
	}
	public void setAno(int ano) {
		Ano = ano;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public double getPreco() {
		return Preco;
	}
	public void setPreco(float preco) {
		Preco = preco;
	}
}
