package OCP;
import SRP.*;

public class Relatório implements Mostrar{
	private String nome;
	private int codigo;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public void display(String texto1, String texto2, String texto3) {
		System.out.println("Relatório gerado");
		System.out.println("Nome do Relatório: " +this.nome);
		System.out.println(" ");
		System.out.println("Código do Relatório: " +this.codigo);
		System.out.println(" ");
		System.out.println("Nome do Item: " +texto1 +"\n" + "Informação 2: " +texto2 +"\n" + "Informação 3: " +texto3 +"\n");
		System.out.println(" ");
		System.out.println("Fim de Relatório");
	}
}