package bibliotecauno;

public class AlunoProfessor {
	private String Nome, Curso, Validade;
	private int RA; private boolean Aluno;
	public AlunoProfessor() {
		Nome = Curso = Validade = "Empty";
		RA = 0;
		Aluno = false;
	}
	public AlunoProfessor(String n1, String n2, String n3, int m1, boolean word) {
		Nome = n1;
		Curso = n2;
		Validade = n3;
		RA = m1;
		Aluno = word;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCurso() {
		return Curso;
	}
	public void setCurso(String curso) {
		Curso = curso;
	}
	public String getValidade() {
		return Validade;
	}
	public void setValidade(String validade) {
		Validade = validade;
	}
	public int getRA() {
		return RA;
	}
	public void setRA(int rA) {
		RA = rA;
	}
	public boolean isAluno() {
		return Aluno;
	}
	public void setAluno(boolean aluno) {
		Aluno = aluno;
	}
}
