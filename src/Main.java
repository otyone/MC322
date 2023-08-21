import bibliotecauno.AlunoProfessor;
import bibliotecauno.Emprestimo;
import bibliotecauno.Funcionario;
import bibliotecauno.Livro;

public class Main {

	public static void main(String[] args) {
		Livro livro = new Livro("MC322", "Bruno Cafeo", "Unicamp", "Programação", 1, 2023, 9999, 199.90);
		AlunoProfessor aluno = new AlunoProfessor("Victor Iori", "Engenharia de Controle e Automação", "12/2027",248206 , true);
		Funcionario funcionario = new Funcionario();
		Emprestimo emprestimo = new Emprestimo();
		System.out.println("Livro:\t" + livro.getTitulo());
		System.out.println("Aluno:\t" + aluno.getNome());
		System.out.println("Funcionario:\t" + funcionario.getNome());
		funcionario.setNome("João");
		System.out.println("Funcionario:\t" + funcionario.getNome());
		System.out.println("Código ISBN do livro emprestado:\t" + emprestimo.getISBN());
		emprestimo.setISBN(9999);
		System.out.println("Código ISBN do livro emprestado:\t" + emprestimo.getISBN());
		}

}